package Algoritmos;

import java.util.Arrays;

public class Ejercicio1 {

    public static ResultadoCalculo calcular(int[] valores) {
        int[] arrAux = new int[valores[0]]; // crea un nuevo arreglo que va a tomar el tamanio del primer valor del arreglo 
        int index = 0;

        for (int i = 1; i < valores.length - 1 && index < valores[0]; i++) { // recorre todo el for  

            if (index > valores[0]) break;

            if (Potencia.esPotenciaDeDos(valores[i])) {
                arrAux[index] = valores[i];
                index++;
            }

            if (!(valores[i] % 5 == 0 && Paridad.esImpar(valores[i + 1]))) { // verifica funciones  
                arrAux[index] = valores[i];
            }
        }

        boolean resultado = (SumaArreglo.suma(arrAux) == valores[valores.length - 1]);
        return new ResultadoCalculo(resultado, arrAux);
    }

    public static void main(String[] args) {
        int[] valores = {4, 2, 5, 7, 6, 13};
        ResultadoCalculo res = calcular(valores);
        
        System.out.println("¿La suma de los valores coincide con el resultado? " + res.resultado);
        System.out.println("Arreglo auxiliar: " + Arrays.toString(res.arregloAuxiliar));
    }
}
