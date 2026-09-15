import java.util.Scanner;

public class Punto17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese numero de columnas: ");
        int columnas = scanner.nextInt();
        
        int[][] matriz = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        // Sumar filas
        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[i][j];
            }
            System.out.println("Suma de la fila " + i + ": " + sumaFila);
        }
        
        // Sumar columnas
        for (int j = 0; j < columnas; j++) {
            int sumaCol = 0;
            for (int i = 0; i < filas; i++) {
                sumaCol += matriz[i][j];
            }
            System.out.println("Suma de la columna " + j + ": " + sumaCol);
        }
    }
}