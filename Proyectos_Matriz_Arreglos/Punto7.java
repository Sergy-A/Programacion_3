import java.util.Scanner;

public class Punto7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] a = new int[10];
        int cantPares = 0;
        int cantImpares = 0;
        
        System.out.println("Ingrese 10 numeros enteros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
            if (a[i] % 2 == 0) {
                cantPares++;
            } else {
                cantImpares++;
            }
        }
        
        int[] pares = new int[cantPares];
        int[] impares = new int[cantImpares];
        
        int idxPar = 0;
        int idxImpar = 0;
        
        for (int i = 0; i < 10; i++) {
            if (a[i] % 2 == 0) {
                pares[idxPar] = a[i];
                idxPar++;
            } else {
                impares[idxImpar] = a[i];
                idxImpar++;
            }
        }
        
        System.out.print("\nArreglo de pares: ");
        for (int i = 0; i < cantPares; i++) {
            System.out.print(pares[i] + " ");
        }
        
        System.out.print("\nArreglo de impares: ");
        for (int i = 0; i < cantImpares; i++) {
            System.out.print(impares[i] + " ");
        }
        System.out.println();
    }
}