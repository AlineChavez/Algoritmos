package Moda;

public class Moda2 {

    public static int moda2(int[] array) {
        int first = 1;
        int p = 0;
        int end = array.length - 1;
        int moda = array[0];
        int frec = 1;
        int maxfrec = 0;

        while (first <= end) {
            if (array[p] == array[first]) {
                frec++;
                first++;
            } else {
                if (frec > maxfrec) {
                    maxfrec = frec;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                frec = 1;
            }
        }

        // Comprobación final fuera del bucle por si la última secuencia es la más larga
        if (frec > maxfrec) {
            moda = array[p];
        }

        return moda;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 4, 4}; // Arreglo ordenado
        int moda = moda2(array);

        System.out.println("La moda del arreglo es: " + moda);
    }
}
