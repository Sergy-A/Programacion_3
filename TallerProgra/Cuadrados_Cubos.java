package TallerProgra;

public class Cuadrados_Cubos {
    
    public static boolean VerificarCuadros_Cubos (int[] arr) {
        // Calculamos la raíz cuadrada del primer número y la raíz cúbica del segundo
        double raizCuadrada = Math.sqrt(arr[0]);
        double raizCubica = Math.cbrt(arr[1]);
        
        // Comparamos ambas raíces (usamos una pequeña tolerancia por precisión decimal)
        return Math.abs(raizCuadrada - raizCubica) < 0.0001;
    }

    public static void main(String[] args) {
        System.out.println(VerificarCuadros_Cubos(new int[]{4, 8}));   // true
        System.out.println(VerificarCuadros_Cubos(new int[]{16, 48})); // false
        System.out.println(VerificarCuadros_Cubos(new int[]{9, 27}));  // true
    }
}
