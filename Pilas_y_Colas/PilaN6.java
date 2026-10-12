package Pilas_y_Colas;

import java.util.Stack;

public class PilaN6 {

    // Clase interna para representar un nodo de la pila
    static class Nodo {
        char dato;
        Nodo sig;

        public Nodo(char dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    // clase interna para representar la lista circular
    static class ListaCircular {
        Nodo cabeza = null;
        Nodo cola = null;

        // utilizamos el metodo agregarFinal para agregar un nodo al final de la lista circular
        public void agregarFinal(char dato) {
            Nodo nuevoNodo = new Nodo(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
                cola.sig = cabeza; // Apunta al primer nodo para formar la lista circular
            } else {
                cola.sig = nuevoNodo;
                cola = nuevoNodo;
                cola.sig = cabeza; // Apunta al primer nodo para mantener la circularidad
            }
        }
    }

    // vamos a verificar si la cadena es un palindromo utilizando una pila y una lista circular
    public static boolean esPalindromo(String cadena) {
        String cadenaLimpia = cadena.replaceAll("\\s+", "").toLowerCase();

        if (cadenaLimpia.isEmpty()) {
            return true;
        }

        Stack<Character> pila = new Stack<>();
        ListaCircular listaCircular = new ListaCircular();

        // Agregamos los caracteres de la cadena a la pila y a la lista circular
        for (int i = 0; i < cadenaLimpia.length(); i++) {
            char c = cadenaLimpia.charAt(i);
            pila.push(c);
            listaCircular.agregarFinal(c);
        }

        Nodo actual = listaCircular.cabeza;
        for (int i = 0; i < cadenaLimpia.length(); i++) {
            char cPila = pila.pop();
            char cLista = actual.dato;

            if (cPila != cLista) {
                return false;
            }
            actual = actual.sig;
        }
        return true;
    }

    // vamos a probar el metodo esPalindromo con un ejemplo
    public static void main(String[] args) {
        String f1 = "Samuel come una sandia";
        String f2 = "reconocer";
        String f3 = "animacion";

        System.out.println("La cadena \"" + f1 + "\" es palindromo? " + esPalindromo(f1));
        System.out.println("La cadena \"" + f2 + "\" es palindromo? " + esPalindromo(f2));
        System.out.println("La cadena \"" + f3 + "\" es palindromo? " + esPalindromo(f3));
    }
}
