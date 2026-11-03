package TallerProgra;

import java.util.Arrays;

public class SociedadSecreta {
    
    public static String societyName(String[] nombres) {
        // Extraemos la primera letra de cada nombre en mayúscula
        char[] iniciales = new char[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            iniciales[i] = Character.toUpperCase(nombres[i].charAt(0));
        }
        
        // Ordenamos las iniciales alfabéticamente
        Arrays.sort(iniciales);
        
        // Convertimos el arreglo de caracteres a String
        return new String(iniciales);
    }

    public static void main(String[] args) {
        System.out.println(societyName(new String[]{"Adam", "Sarah", "Malcolm"})); // AMS
        System.out.println(societyName(new String[]{"Harry", "Newt", "Luna", "Cho"})); // CHLN
        System.out.println(societyName(new String[]{"Phoebe", "Chandler", "Rachel", "Ross", "Monica", "Joey"})); // CJMPRR
    }
}
