package Pilas_y_Colas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class PilaN4 {

public static void main(String [] args){
 int n = 5;

 // Creamos una pila de enteros n (p1 a p5)
 List<Stack<Integer>> pilas = new ArrayList<>();
 for(int k = 0; k < n; k++) {
    pilas.add(new Stack <>());
 }

 Scanner scanner = new Scanner(System.in); 
 System.out.println("Ingrese 5 numeros enteros (i.j) ingrese i=0 para salir");

 while (true) {
    System.out.println("Ingrese i: (1-5)");
    int i = scanner.nextInt();
    
    if(i == 0) {
        break;// salir del bucle
        }

     System.out.println("ingrese j:");
     int j = scanner.nextInt();
     
     // validarmos que i este en el rango de 1 a 5
     int index = Math.abs(i)-1;
     if(index < 0 || index >= n) {
        System.out.println(" i debe estar entre 1 y 5");
        continue;
     }
 if (i > 0) {
         // Agregamos el numero j a la pila corespondiente
         pilas.get(index).push(j);
         System.out.println("Numero " + j + " agregado a la pila p" + i);
}
 else {
         // i es negativo, eliminamos el elemento superior de la pila correspondiente
  if (!pilas.get(index).isEmpty()) {
             int valorEliminado = pilas.get(index).pop();
             System.out.println("Numero " + valorEliminado + " eliminado de la pila p" + Math.abs(i));
  }
   else {
             System.out.println("La pila p" + Math.abs(i) + " está vacía");
         }
     }
 }

 // Mostramos el contenido de cada pila
 for(int k = 0; k < n; k++) {
    System.out.println("Pila p" + (k + 1) + ":" + pilas.get(k));
}

scanner.close();

 }
}

