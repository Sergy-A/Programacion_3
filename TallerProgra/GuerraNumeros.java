package TallerProgra;
public class GuerraNumeros {
    
    public static int warOfNumbers(int[] numeros) {
        int sumaPares = 0;
        int sumaImpares = 0;
        
        // Sumamos por separado los pares e impares
        for (int num : numeros) {
            if (num % 2 == 0) {
                sumaPares += num;
            } else {
                sumaImpares += num;
            }
        }
        
        // Retornamos la diferencia (siempre positiva)
        return Math.abs(sumaPares - sumaImpares);
    }

    public static void main(String[] args) {
        System.out.println(warOfNumbers(new int[]{2, 8, 7, 5})); // 2
        System.out.println(warOfNumbers(new int[]{12, 90, 75})); // 27
        System.out.println(warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243})); // 168
    }
}
