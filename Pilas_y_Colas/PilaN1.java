package Pilas_y_Colas;

import java.util.Stack;

public class PilaN1 {

  public static <A> void PilaN1(Stack<A> fuente, Stack<A> destino) { // metodo que recibe dos pilas y mueve los elementos de la pila fuente a la pila destino
    Stack<A> aux = new Stack<>();
    Stack<A> fuenteRestaurada = new Stack<>();

    while (!fuente.isEmpty()) { // mientraas la pila fuente no este vacia, se van a ir moviendo los elementos de la pila fuente a la pila destino
      A elemento = fuente.pop();
      aux.push(elemento);
      fuenteRestaurada.push(elemento);// guardamos los elementos en una pila auxiliar y en una pila para restaurar la fuente
    }

    while (!fuenteRestaurada.isEmpty()) {// mientras la pila fuente restaurada no este vacia, se van a ir moviendo los elementos de la pila fuente restaurada a la pila fuente}
     fuente.push(fuenteRestaurada.pop());
  }

  while (!aux.isEmpty()) { // mientras la pila auxiliar no este vacio, se van a ir moviendo los elementos de la pila auxiliar a la pila destino
   A elemento = aux.pop();
   destino.push(elemento);
  }

  }
   // metodo para probar el elemento de la pila
  public static void main(String[] args) {
    Stack<Integer> OriginalPila = new Stack<>();
    OriginalPila.push(10);
    OriginalPila.push(50);
    OriginalPila.push(100); // pila1 = [10, 50, 100] elemento 1000 es el tope de la pila

    Stack<Integer> CopiaPila = new Stack<>();

    System.out.println("Pila original antes de copiar: " + OriginalPila);

    PilaN1(OriginalPila, CopiaPila); // se llama al metodo PilaN1 para mover los elementos de la pila original a la pila copia

    System.out.println("Pila original despues de copiar: " + OriginalPila);
    System.out.println("Destino de la pila (copia): " + CopiaPila);
    }

}
