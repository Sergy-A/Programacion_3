import java.util.Scanner;

public class Punto8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = 30;
        int[] numeros = new int[n];
        
        System.out.println("Ingrese 30 numeros:");
        for (int i = 0; i < n; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        int mayor = numeros[0];
        int menor = numeros[0];
        
        for (int i = 1; i < n; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        
        int repMayor = 0;
        int repMenor = 0;
        
        for (int i = 0; i < n; i++) {
            if (numeros[i] == mayor) {
                repMayor++;
            }
            if (numeros[i] == menor) {
                repMenor++;
            }
        }
        
        System.out.println("\nNumero mayor: " + mayor + " (se repite " + repMayor + " veces)");
        System.out.println("Numero menor: " + menor + " (se repite " + repMenor + " veces)");
    }
}