public class Punto20 {
    public static void main(String[] args) {
        int[][] matriz = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j >= i) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 1; // Asignamos 1s por debajo de la diagonal principal
                }
            }
        }
        
        System.out.println("--- MATRIZ 10x10 ---");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}