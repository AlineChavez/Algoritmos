package Algoritmos;

public class viajemasbarato {
    public static int[][] calcularcostes(int[][] t) {
        int n = t.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            c[i][i] = 0;
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                c[i][j] = t[i][j];
                for (int k = i + 1; k < j; k++) {
                    c[i][j] = Math.min(c[i][j], t[i][k] + c[k][j]);
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[][] t = {
            {0, 3, 1, 6, 999},
            {0, 0, 1, 2, 999},
            {0, 0, 0, 1, 4},
            {0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0}
        };
        int[][] c = calcularcostes(t);
        System.out.println("matriz de costes mínimos c:");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print((c[i][j] == 999 ? "inf" : c[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
