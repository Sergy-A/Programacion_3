package Pilas_y_Colas;

import java.util.Stack;

public class PilaN3 {
    
public static boolean esEquilibrado(String expresion){
    Stack<Character> pila = new Stack<>();

    for(int i= 0; i < expresion.length(); i++) { // Recorremos la expresion caracter por caracter
        char c = expresion.charAt(i);
        
        if (c == '(' || c == '{' || c == '[') { // si es un simbolo de apertura, lo agregamos a la pila 
            pila.push(c);
        }
    else if (c == ')' || c == '}' || c == ']' ) { // si es un simbolo de cierre, verificamos si la pila esta vacia
        if (pila.isEmpty()) {
            return false;
        }
        char tope = pila.pop(); // sacamos el simbolo de apertura de la pila 

        // verificamos si el simbolo de apertura y cierre son del mismo tipo
        if ((c == ')' && tope != '(') ||
            (c == '}' && tope != '{') ||
            (c == ']' && tope != '[')) {
            return false;
        }
        }
    }
     // si la pila esta vacia, significa que todos los simbolos de apertura tienen su simbolo de cierre correcto
     return pila.isEmpty();

    }
    // ejemplo de uso del metodo esEquilibrado
    public static void main(String[] args) {
        String Expresion1 = "((a+b)*5) - 7";
        String Expresion2 = "2*[(a+b)/2.5 + 5 + x - 7*y";

    System.out.println("¿'" + Expresion1 + "' es equilibrado? " + esEquilibrado(Expresion1));
    System.out.println("¿'" + Expresion2 + "' es equilibrado? " + esEquilibrado(Expresion2));
}

}
