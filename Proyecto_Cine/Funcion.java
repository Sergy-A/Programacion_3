package Proyecto_Cine;
public class Funcion {
    private Pelicula pelicula;
    private String horaria;
    private boolean[][] sillasGeneral = new boolean[6][12]; // Matriz 6x12 para General (A-F)
    private boolean[][] sillasPreferencial; // Matriz 2x9 para Preferencial (G-H)
    private int numeroSala;

    public Funcion(Pelicula pelicula, String horaria, int numeroSala) {
        this.pelicula = pelicula;
        this.horaria = horaria;
        this.numeroSala = numeroSala;
        
        // Solo las salas 1 y 2 habilitan matriz preferencial
        if (numeroSala == 1 || numeroSala == 2) {
            this.sillasPreferencial = new boolean[2][9];
        }
    }

    public Pelicula getPelicula() { return pelicula; }

    public int getSillasDisponibles() {
        int disponibles = 0;
        for (boolean[] fila : sillasGeneral) {
            for (boolean ocupada : fila) if (!ocupada) disponibles++;
        }
        if (sillasPreferencial != null) {
            for (boolean[] fila : sillasPreferencial) {
                for (boolean ocupada : fila) if (!ocupada) disponibles++;
            }
        }
        return disponibles;
    }

    public void mostrarMapaEscenario() {
        System.out.println("\n--- MAPA SALA " + numeroSala + " (" + horaria + ") ---");
        
        // Imprime filas Preferenciales (H y G) si la sala dispone de ellas
        if (sillasPreferencial != null) {
            for (int i = sillasPreferencial.length - 1; i >= 0; i--) {
                System.out.print((char) ('G' + i) + "  ");
                for (boolean ocupada : sillasPreferencial[i]) {
                    System.out.print(ocupada ? " X " : " - ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------------");
        }

        // Imprime filas Generales (F a A)
        for (int i = sillasGeneral.length - 1; i >= 0; i--) {
            System.out.print((char) ('A' + i) + "  ");
            for (boolean ocupada : sillasGeneral[i]) {
                System.out.print(ocupada ? " X " : " - ");
            }
            System.out.println();
        }
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12");
        System.out.println("               [ PANTALLA ]\n");
    }

    public int comprarSilla(String id) {
        if (id == null || id.length() < 2) return -1;
        
        char filaChar = Character.toUpperCase(id.charAt(0));
        int col;
        try {
            col = Integer.parseInt(id.substring(1)) - 1; // Convierte el número a índice de arreglo (base 0)
        } catch (Exception e) { return -1; }

        // Procesa compra en sección General
        if (filaChar >= 'A' && filaChar <= 'F') {
            int fila = filaChar - 'A';
            if (col < 0 || col >= 12 || sillasGeneral[fila][col]) return -1;
            
            sillasGeneral[fila][col] = true;
            return 8000; // Tarifa General $8.000
        } 
        // Procesa compra en sección Preferencial
        else if ((filaChar == 'G' || filaChar == 'H') && sillasPreferencial != null) {
            int fila = filaChar - 'G';
            if (col < 0 || col >= 9 || sillasPreferencial[fila][col]) return -1;

            sillasPreferencial[fila][col] = true;
            return 12000; // Tarifa Preferencial $12.000
        }
        return -1;
    }
}