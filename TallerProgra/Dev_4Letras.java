package TallerProgra;

import java.util.ArrayList;

public class Dev_4Letras {
    
    public static String[] isFourLetters(String[] palabras) {
        ArrayList<String> resultado = new ArrayList<>();
        
        // Filtramos las palabras que tengan 4 letras o menos
        for (String palabra : palabras) {
            if (palabra.length() <= 4) {
                resultado.add(palabra);
            }
        }
        
        // Convertimos la lista a arreglo
        return resultado.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(
            isFourLetters(new String[]{"Europa", "Mapa", "Sur"}))); // [Mapa]
        
        System.out.println(java.util.Arrays.toString(
            isFourLetters(new String[]{"Canguro", "Oso", "elefante"}))); // [Oso]
        
        System.out.println(java.util.Arrays.toString(
            isFourLetters(new String[]{"Ryan", "Trisha", "Jason", "Matt"}))); // [Ryan, Matt]
    }
}