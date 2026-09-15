import java.util.Scanner;

public class Punto11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de elementos (N): ");
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        int cantNeg = 0, cantCero = 0, cantPos = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + i + ": ");
            a[i] = scanner.nextInt();
            
            if (a[i] < 0) cantNeg++;
            else if (a[i] == 0) cantCero++;
            else cantPos++;
        }
        
        int[] negativos = new int[cantNeg];
        int[] ceros = new int[cantCero];
        int[] positivos = new int[cantPos];
        
        int in = 0, ic = 0, ip = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                negativos[in++] = a[i];
            } else if (a[i] == 0) {
                ceros[ic++] = a[i];
            } else {
                positivos[ip++] = a[i];
            }
        }
        
        System.out.print("\nNegativos: ");
        for (int x : negativos) System.out.print(x + " ");
        
        System.out.print("\nCeros: ");
        for (int x : ceros) System.out.print(x + " ");
        
        System.out.print("\nPositivos: ");
        for (int x : positivos) System.out.print(x + " ");
        System.out.println();
    }
}