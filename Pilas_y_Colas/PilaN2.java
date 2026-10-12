package Pilas_y_Colas;

import java.util.Stack;

public class PilaN2 {

    public static boolean esFormaXY(String secuencia) {
        Stack<Character> pila = new Stack<>();
        int i = 0;
        int n = secuencia.length();

        while (i < n && secuencia.charAt(i) != '&') {
            pila.push(secuencia.charAt(i));
            i++;
        }

        if (i >= n || secuencia.charAt(i) != '&') {
            return false;
        }

        i++; // se salta el '&'

        if (pila.isEmpty()) {
            return false;
        }

        while (i < n) {
            char caracterActual = secuencia.charAt(i);
            char caracterPila = pila.pop();

            if (caracterActual != caracterPila) {
                return false;
            }
            i++;
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String prueba1 = "salon&nolas"; // (invertida correcta)
        String prueba2 = "fila&alif"; // (invertida correcta)
        String prueba3 = "mazorca&acroza"; // (invertida incorrecta) faltan caracteres
        String prueba4 = "abc&xyz"; // (invertida incorrecta) No es la misma palabra invertida

        System.out.println(prueba1 + " es la forma X & Y " + esFormaXY(prueba1));
        System.out.println(prueba2 + " es la forma X & Y " + esFormaXY(prueba2));
        System.out.println(prueba3 + " es la forma X & Y " + esFormaXY(prueba3));
        System.out.println(prueba4 + " es la forma X & Y " + esFormaXY(prueba4));
    }
}
