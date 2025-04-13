package Algoritmos;

public class SumaArreglo {
    public static int suma(int[] arr) { // recorre todo el arreglo para poder sumarlos 
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }
}
