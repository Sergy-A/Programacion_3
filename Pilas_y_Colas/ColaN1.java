package Pilas_y_Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ColaN1 {

    public static void main(String[] args) {

        // creamos las 3 cajas del supermercado (cada una es una cola)
        Queue<String> caja1 = new LinkedList<>();
        Queue<String> caja2 = new LinkedList<>();
        Queue<String> caja3 = new LinkedList<>();

        // controlamos los carritos de compras que estén disponibles (empezando con 25)
        int carritosDisponibles = 25;

        // simulador de llegada de clientes al supermercado
        int clientes = 10;
        Random random = new Random();

        System.out.println("-- Simulacion del supermercado inicio");

        for (int i = 1; i <= clientes; i++) {
            String cliente = "Cliente #" + i;
            System.out.println("llegada del cliente " + cliente + "!");

            // Regla: Si hay carrito disponible, el cliente puede entrar al supermercado y elegir una caja para hacer su compra.
            // si no hay carrito disponible, el cliente espera a que alguien desocupe uno
            while (carritosDisponibles == 0) {
                System.out.println("No hay carritos disponibles, " + cliente + " espera a que alguien desocupe uno.");
                // simulamos que un cliente desocupó un carrito
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                carritosDisponibles++;
                System.out.println("Un carrito se ha desocupado, " + cliente + " puede entrar al supermercado.");
            }

            // El cliente coge un carrito
            carritosDisponibles--;
            System.out.println("--> " + cliente + " coge un carrito, (Quedan " + carritosDisponibles + " carritos disponibles)");

            // Regla: El cliente va a la caja con la menor cantidad de clientes en la cola.
            Queue<String> cajaElegida = elegirCajaConMenosGente(caja1, caja2, caja3);
            cajaElegida.add(cliente);

            if (!caja1.isEmpty() && random.nextBoolean()) {
                String atendido = caja1.poll();
                carritosDisponibles++;
                System.out.println(" [Caja 1] Paga " + atendido + ", libera su carrito (Total carritos: " + carritosDisponibles + ")");
            }
            if (!caja2.isEmpty() && random.nextBoolean()) {
                String atendido = caja2.poll();
                carritosDisponibles++;
                System.out.println(" [Caja 2] Paga " + atendido + ", libera su carrito (Total carritos: " + carritosDisponibles + ")");
            }

            System.out.println();
        }

        System.out.println("-- Simulacion del supermercado finalizada --");

    }
 //Metodo auxiliar para buscar cual de las tres cajas tiene menos fila
 private static Queue<String> elegirCajaConMenosGente(Queue<String> c1, Queue<String> c2, Queue<String> c3 ){
 if (c1.size() <= c2.size() && c1.size() <= c3.size()) {
    return c1;
 }else if (c2.size() <= c1.size() && c2.size() <= c3.size()){
    return c2;
 }else {
    return c3;
 }
 }

}
