import java.util.Scanner;

public class Punto22 {
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
        
        int mayor = matriz[0][0];
        int fMayor = 0, cMayor = 0;
        
        int menor = matriz[0][0];
        int fMenor = 0, cMenor = 0;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    fMayor = i;
                    cMayor = j;
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    fMenor = i;
                    cMenor = j;
                }
            }
        }
        
        System.out.println("\n--- MATRIZ ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        
        System.out.println("\nMayor: " + mayor + " en la posicion [" + fMayor + "][" + cMayor + "]");
        System.out.println("Menor: " + menor + " en la posicion [" + fMenor + "][" + cMenor + "]");
    }
}