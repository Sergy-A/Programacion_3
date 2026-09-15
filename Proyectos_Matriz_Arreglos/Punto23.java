import java.util.Scanner;

public class Punto23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de filas (N): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas (M): ");
        int m = scanner.nextInt();
        
        int[][] matriz = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        int[] resultado = new int[n];
        
        for (int i = 0; i < n; i++) {
            int mayorAbs = Math.abs(matriz[i][0]);
            int valorOriginal = matriz[i][0];
            
            for (int j = 1; j < m; j++) {
                if (Math.abs(matriz[i][j]) > mayorAbs) {
                    mayorAbs = Math.abs(matriz[i][j]);
                    valorOriginal = matriz[i][j];
                }
            }
            resultado[i] = valorOriginal;
        }
        
        System.out.println("\nMayor valor absoluto por cada fila:");
        for (int i = 0; i < n; i++) {
            System.out.println("Fila " + i + ": " + resultado[i]);
        }
    }
}