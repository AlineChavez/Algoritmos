package Juego;

public class HanoiSolver {
    private int movimientos; 

    public HanoiSolver() {
        this.movimientos = 0; 
    }

    public void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            movimientos++; 
        } else {
            torresHanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            movimientos++; 
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }

    public int getMovimientos() {
        return movimientos; 
    }
}
