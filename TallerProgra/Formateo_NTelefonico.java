package TallerProgra;

public class Formateo_NTelefonico {
    
    public static String FormateoDeNumero (int[] numeros) {
        // Usamos StringBuilder para construir la cadena eficientemente
        StringBuilder sb = new StringBuilder();
        
        // Formato: (XXX) XXX-XXXX
        sb.append("(");
        // Primeros 3 dígitos dentro del paréntesis
        for (int i = 0; i < 3; i++) {
            sb.append(numeros[i]);
        }
        sb.append(") ");
        // Siguientes 3 dígitos
        for (int i = 3; i < 6; i++) {
            sb.append(numeros[i]);
        }
        sb.append("-");
        // Últimos 4 dígitos
        for (int i = 6; i < 10; i++) {
            sb.append(numeros[i]);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(FormateoDeNumero(new int[]{1,2,3,4,5,6,7,8,9,0})); // (123) 456-7890
        System.out.println(FormateoDeNumero(new int[]{5,1,9,5,5,5,4,4,6,8})); // (519) 555-4468
        System.out.println(FormateoDeNumero(new int[]{3,4,5,5,0,1,2,5,2,7})); // (345) 501-2527
    }
}
