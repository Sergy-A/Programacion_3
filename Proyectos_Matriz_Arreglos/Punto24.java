import java.util.Scanner;

public class Punto24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] cosechaMensual = new double[12];
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        double sumaTotal = 0;
        
        for (int i = 0; i < 12; i++) {
            System.out.print("Ingrese la cosecha total en toneladas para " + meses[i] + ": ");
            cosechaMensual[i] = scanner.nextDouble();
            sumaTotal += cosechaMensual[i];
        }
        
        // a. Promedio anual
        double promedioAnual = sumaTotal / 12;
        
        int superiores = 0;
        int inferiores = 0;
        int posMayor = 0;
        
        for (int i = 0; i < 12; i++) {
            if (cosechaMensual[i] > promedioAnual) {
                superiores++; // b. Meses superiores al promedio
            } else if (cosechaMensual[i] < promedioAnual) {
                inferiores++; // c. Meses inferiores al promedio
            }
            
            if (cosechaMensual[i] > cosechaMensual[posMayor]) {
                posMayor = i; // d. Mes con mayor cosecha
            }
        }
        
        System.out.println("\n--- INFORME ANUAL ---");
        System.out.println("a. Promedio anual de toneladas: " + promedioAnual);
        System.out.println("b. Meses con cosecha superior al promedio: " + superiores);
        System.out.println("c. Meses con cosecha inferior al promedio: " + inferiores);
        System.out.println("d. Mes con mayor produccion: " + meses[posMayor] + " (" + cosechaMensual[posMayor] + " toneladas)");
    }
}