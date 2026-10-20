package ArrayList_list;

import java.util.List;
import java.util.ArrayList;

public class ListaCompras {
    public static void main(String[] args) {
        // Creamos la lista usando la interfaz List y la clase ArrayList
        List<String> compras = new ArrayList<>();

        // Vamos gregar elementos con .add()
        compras.add("Manzanas");
        compras.add("Leche");
        compras.add("Pan");
        compras.add("Café");

        
        System.out.println("Lista de compras inicial: " + compras);

        //  Obtener un elemento específico por su posición (índice empieza en 0) con .get()
        System.out.println("El primer producto es: " + compras.get(0));

        // Para saber cuántos elementos hay con .size()
        System.out.println("Total de productos: " + compras.size());

        // Usamos remove para eliminar un elemento (por nombre o por índice)
        compras.remove("Leche"); 

        // Usamos para verificar si un elemento existe con .contains()
        if (compras.contains("Café")) {
            System.out.println("¡No olvides comprar el café!");
        }

        //  Al final se mostrara la lista actualizada
        System.out.println("Lista de compras final: " + compras);
    }
}
