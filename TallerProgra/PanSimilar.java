package TallerProgra;

public class  PanSimilar {
    
    public static boolean MismoPan (String[] sandwich1, String[] sandwich2) {
        // Comparamos el primer y último elemento de ambos arreglos
        // (el pan siempre está al inicio y al final)
        return sandwich1[0].equals(sandwich2[0]) 
            && sandwich1[sandwich1.length - 1].equals(sandwich2[sandwich2.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(MismoPan(
            new String[]{"pan blanco", "lechuga", "pan blanco"},
            new String[]{"pan blanco", "tomate", "pan blanco"})); // true

        System.out.println(MismoPan(
            new String[]{"pan integral", "pollo", "pan integral"},
            new String[]{"pan blanco", "pollo", "pan blanco"})); // false

        System.out.println(MismoPan(
            new String[]{"tostada", "queso", "tostada"},
            new String[]{"pan integral", "queso", "tostada"})); // false
    }
}
