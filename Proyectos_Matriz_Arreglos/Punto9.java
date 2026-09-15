import java.util.Scanner;

public class Punto9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();
        
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + i + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        System.out.print("Ingrese el numero a buscar: ");
        int x = scanner.nextInt();
        
        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (numeros[i] == x) {
                contador++;
            }
        }
        
        System.out.println("El numero " + x + " se encuentra " + contador + " veces en el arreglo.");
    }
}