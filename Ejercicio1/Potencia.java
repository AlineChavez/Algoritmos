package Algoritmos;

public class Potencia {
    public static boolean esPotenciaDeDos(int n) { // metodo para obtener potencia a traves de binarios  
        return n > 0 && (n & (n - 1)) == 0;
    }
}
