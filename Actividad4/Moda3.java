package Moda;

import java.util.Arrays;
import java.util.PriorityQueue;

class Limits {//podemos crear otra clase para esta seccion
    int[] a;
    int prim;
    int ult;

    Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }

    int length() {
        return ult - prim + 1;
    }
}

class SetVectors { //podemos crear otra clase para esta seccion
    PriorityQueue<Limits> queue;

    SetVectors() {
        queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.length(), p1.length()));
    }

    void insertar(Limits p) {
        if (p.prim <= p.ult) queue.add(p);
    }

    Limits mayor() {
        return queue.poll();
    }

    int longMayor() {
        return queue.isEmpty() ? 0 : queue.peek().length();
    }

    boolean esVacio() {
        return queue.isEmpty();
    }

    void destruir() {
        queue.clear();
    }
}

public class Moda3 {

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();

        heterogeneo.insertar(new Limits(a, prim, ult));

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            Limits p = heterogeneo.mayor();
            int mediana = p.a[(p.prim + p.ult) / 2];

            int izq, der;
            int[] resultado = pivote2(p.a, mediana, p.prim, p.ult);
            izq = resultado[0];
            der = resultado[1];

            Limits p1 = new Limits(p.a, p.prim, izq - 1);
            Limits p2 = new Limits(p.a, izq, der - 1);
            Limits p3 = new Limits(p.a, der, p.ult);

            if (p1.prim <= p1.ult) heterogeneo.insertar(p1);
            if (p3.prim <= p3.ult) heterogeneo.insertar(p3);
            if (p2.prim <= p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) return a[prim];

        Limits p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.a[p.prim];
    }

    static int[] pivote2(int[] a, int mediana, int prim, int ult) {
        int[] temp = Arrays.copyOfRange(a, prim, ult + 1);
        int izq = prim, der = prim;

        for (int i = prim; i <= ult; i++) {
            if (a[i] < mediana) {
                temp[izq - prim] = a[i];
                izq++;
                der++;
            } else if (a[i] == mediana) {
                temp[der - prim] = a[i];
                der++;
            }
        }

        for (int i = prim; i <= ult; i++) {
            a[i] = temp[i - prim];
        }

        return new int[]{izq, der};
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 2, 3, 3, 3, 4, 2, 5};
        int moda = moda3(arreglo, 0, arreglo.length - 1);
        System.out.println("La moda del arreglo es: " + moda);
    }
}
