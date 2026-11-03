package TallerProgra;

public class N_MasGrande {
    
    public static int secondLargest(int[] arr) {
        // Inicializamos con el valor más pequeño posible
        int mayor = Integer.MIN_VALUE;
        int segundoMayor = Integer.MIN_VALUE;
        
        // Recorremos el arreglo una sola vez
        for (int num : arr) {
            if (num > mayor) {
                // Si encontramos un nuevo mayor, el anterior mayor pasa a ser el segundo
                segundoMayor = mayor;
                mayor = num;
            } else if (num > segundoMayor && num != mayor) {
                // Si el número está entre el segundo mayor y el mayor (y no es duplicado)
                segundoMayor = num;
            }
        }
        
        return segundoMayor;
    }

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{10, 40, 30, 20, 50}));   // 40
        System.out.println(secondLargest(new int[]{25, 143, 89, 13, 105})); // 105
        System.out.println(secondLargest(new int[]{54, 23, 11, 17, 10}));   // 23
    }
}