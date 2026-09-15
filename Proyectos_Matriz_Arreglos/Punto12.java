import java.util.Scanner;

public class Punto12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del arreglo A: ");
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            a[i] = scanner.nextInt();
        }
        
        System.out.print("Ingrese el valor X a buscar: ");
        int x = scanner.nextInt();
        
        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) contador++;
        }
        
        int[] b = new int[contador];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                b[idx++] = i + 1; // Posiciones basadas en indice 1
            }
        }
        
        System.out.print("Arreglo resultante de posiciones: ");
        for (int i = 0; i < contador; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}