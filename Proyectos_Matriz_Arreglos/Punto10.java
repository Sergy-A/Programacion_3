import java.util.Scanner;

public class Punto10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño N del arreglo: ");
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            a[i] = scanner.nextInt();
        }
        
        int tamB = (n % 2 == 0) ? (n / 2) : (n / 2 + 1);
        int[] b = new int[tamB];
        
        for (int i = 0; i < tamB; i++) {
            int opuestoIndex = n - 1 - i;
            if (i == opuestoIndex) {
                b[i] = a[i]; // Si es el elemento central de un arreglo de tamaño impar
            } else {
                b[i] = a[i] + a[opuestoIndex];
            }
        }
        
        System.out.print("\nArreglo resultante B: ");
        for (int i = 0; i < tamB; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}