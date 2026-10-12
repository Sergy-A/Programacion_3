package Pilas_y_Colas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PilaN5 {

    public static void main(String[] args) {
        int n = 5;
        List<Stack<Integer>> pilas = new ArrayList<>();
 for (int x = 0; x < n; x++) {
  pilas.add(new Stack<>());
    }

  Scanner scanner = new Scanner(System.in);
  System.out.println("Ingrese triplos de numeros enteros (i,j,k) ingrese i=0 para salir");
 while (true) {
  System.out.println("Ingrese i:");
  int i = scanner.nextInt();
 if (i == 0) {
  break;
            }
 System.out.println("Ingrese j:");
  int j = scanner.nextInt();

  System.out.println("Ingrese k: (-1 para eliminar el elemento superior de la pila correspondiente)");
     int k = scanner.nextInt();

          int index = Math.abs(i) - 1;
  if (index < 0 || index >= n) {
  System.out.println("Invalido debe estar entre 1 y 5");
 continue;
            }

 if (k == -1) {
         if (!pilas.get(index).isEmpty()) {
      int valorEliminado = pilas.get(index).pop();
      System.out.println("Numero " + valorEliminado + " eliminado de la pila p" + Math.abs(i));
    } else {
      System.out.println("La pila p" + Math.abs(i) + " está vacía");
                }
   } else if (k == 0) {
      if (i > 0) {
      pilas.get(index).push(j);
              System.out.println("Numero " + j + " agregado a la pila P" + i);
      } else {
       if (!pilas.get(index).isEmpty()) {
        int valorEliminado = pilas.get(index).pop();
        System.out.println("Numero " + valorEliminado + " eliminado de la pila p" + Math.abs(i));
      } else {
             System.out.println("La pila p" + Math.abs(i) + " está vacía");
               }
          }
     } else {
       System.out.println("Invalido (debe ser -1 o 0).");
           }

      System.out.println("--Contenido de las pilas--");
    for (int x = 0; x < n; x++) {
               System.out.println("Pila p" + (x + 1) + ": " + pilas.get(x));
      }
  }

  scanner.close();
    }
}