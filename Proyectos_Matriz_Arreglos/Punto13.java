import java.util.Scanner;

public class Punto13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de elementos N: ");
        int n = scanner.nextInt();
        
        double[] a = new double[n];
        double suma = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            a[i] = scanner.nextDouble();
            suma += a[i];
        }
        
        double media = suma / n;
        
        int cantMayores = 0;
        int cantMenores = 0;
        
        for (int i = 0; i < n; i++) {
            if (a[i] > media) cantMayores++;
            else if (a[i] < media) cantMenores++;
        }
        
        double[] mayores = new double[cantMayores];
        double[] menores = new double[cantMenores];
        
        int imay = 0, imen = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > media) mayores[imay++] = a[i];
            else if (a[i] < media) menores[imen++] = a[i];
        }
        
        System.out.println("\nMedia calculada: " + media);
        System.out.print("Mayores que la media: ");
        for (double v : mayores) System.out.print(v + " ");
        
        System.out.print("\nMenores que la media: ");
        for (double v : menores) System.out.print(v + " ");
        System.out.println();
    }
}