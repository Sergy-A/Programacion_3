package ArrayList_list;

import java.util.List;
import java.util.ArrayList;

public class InventarioJuegos {
    public static void main(String[] args) {
        // Vamos a Declarar  la lista de juegos
        List<String> juegos = new ArrayList<>();

        // Vamos a agregando juegos al inventario
        juegos.add("Minecraft");
        juegos.add("FIFA");
        juegos.add("Grand Theft Auto V");
        juegos.add("God of War");

        System.out.println("--- VIDEOJUEGOS DISPONIBLES ---");

        
        for (String juego : juegos) {
            System.out.println("- " + juego);
        }

        // Vamos a modificar o actualizar un elemento en una posición específica con .set()
        // Cambiamos la "FIFA" por "EA Sports FC" en el índice 1
        juegos.set(1, "EA Sports FC");

        System.out.println("\n--- INVENTARIO ACTUALIZADO ---");
        for (int i = 0; i < juegos.size(); i++) {
            System.out.println((i + 1) + ". " + juegos.get(i));
        }
        
        //  Para limpiar toda la lista usamos .clear()
        // juegos.clear();
    }
}
