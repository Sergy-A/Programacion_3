import java.util.Scanner;

public class Punto21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el orden M de la matriz cuadrada: ");
        int m = scanner.nextInt();
        
        int[][] matriz = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        int[] b = new int[m];
        
        for (int i = 0; i < m; i++) {
            int sumaParesFila = 0;
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] % 2 == 0) {
                    sumaParesFila += matriz[i][j];
                }
            }
            b[i] = sumaParesFila;
        }
        
        System.out.println("\nVector B con la suma de pares por fila:");
        for (int i = 0; i < m; i++) {
            System.out.println("B[" + i + "] = " + b[i]);
        }
    }
}