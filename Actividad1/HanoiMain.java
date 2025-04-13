package Juego;
import java.util.Scanner;

public class HanoiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scanner.nextInt();
        scanner.close();

        HanoiSolver solver = new HanoiSolver();
        solver.torresHanoi(numDiscos, 1, 2, 3);

        
        System.out.println("Total de movimientos: " + solver.getMovimientos());
    }
}
