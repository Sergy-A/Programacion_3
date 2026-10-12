package Pilas_y_Colas;

import java.util.LinkedList;
import java.util.Queue;

public class ColaN2 {
   
// Estructura de un Nodo para nuestra lista enlazada de trabajadores
    static class Trabajador {
        String numSeguridadSocial;
        String nombre;
        int diasTrabajados;
        Trabajador siguiente;

        public Trabajador(String numSeguridadSocial, String nombre, int diasTrabajados) {
            this.numSeguridadSocial = numSeguridadSocial;
            this.nombre = nombre;
            this.diasTrabajados = diasTrabajados;
            this.siguiente = null;
        }
    }

    // Estructura auxiliar para representar el reporte diario que viene en la Cola
    static class ReporteDia {
        String numSeguridadSocial;
        String entidadAnunciada;

        public ReporteDia(String numSeguridadSocial, String entidadAnunciada) {
            this.numSeguridadSocial = numSeguridadSocial;
            this.entidadAnunciada = entidadAnunciada;
        }
    }

    // Lista enlazada que guarda a los trabajadores ordenada por número de seguridad social
    static class ListaTrabajadores {
        Trabajador cabeza = null;

        // Método para actualizar o añadir trabajadores según el día trabajado
        public void actualizarConCola(Queue<ReporteDia> colaRepartidores) {
            while (!colaRepartidores.isEmpty()) {
                ReporteDia hoy = colaRepartidores.poll();
                
                // Buscamos si el repartidor ya está registrado en nuestra lista
                Trabajador actual = cabeza;
                Trabajador anterior = null;
                boolean encontrado = false;

                while (actual != null && actual.numSeguridadSocial.compareTo(hoy.numSeguridadSocial) <= 0) {
                    if (actual.numSeguridadSocial.equals(hoy.numSeguridadSocial)) {
                        encontrado = true;
                        break;
                    }
                    anterior = actual;
                    actual = actual.siguiente;
                }

                if (encontrado) {
                    // Si ya estaba, le sumamos un día de trabajo más
                    actual.diasTrabajados++;
                    System.out.println("Actualizado: El trabajador " + actual.nombre + " ahora tiene " + actual.diasTrabajados + " días trabajados.");
                } else {
                    // Si no estaba, lo agregamos nuevo manteniendo el orden alfabético/numérico del seguro social
                    // Como no tenemos el nombre en la cola, le ponemos un nombre por defecto o genérico
                    Trabajador nuevo = new Trabajador(hoy.numSeguridadSocial, "Nuevo Repartidor (" + hoy.entidadAnunciada + ")", 1);
                    
                    if (anterior == null) {
                        // Va al principio de la lista
                        nuevo.siguiente = cabeza;
                        cabeza = nuevo;
                    } else {
                        // Va en medio o al final
                        nuevo.siguiente = actual;
                        anterior.siguiente = nuevo;
                    }
                    System.out.println("Nuevo trabajador añadido con seguro: " + hoy.numSeguridadSocial);
                }
            }
        }

        // Método para mostrar la lista completa ordenada
        public void mostrarLista() {
            Trabajador actual = cabeza;
            System.out.println("\n--- LISTA DE TRABAJADORES ACTUALIZADA ---");
            while (actual != null) {
                System.out.println("Seguro: " + actual.numSeguridadSocial + " | Nombre: " + actual.nombre + " | Días trabajados: " + actual.diasTrabajados);
                actual = actual.siguiente;
            }
        }
    }

    // Ejemplo de pruebas
    public static void main(String[] args) {
        ListaTrabajadores empresa = new ListaTrabajadores();

        // Simulamos que ya tenemos algunos trabajadores en nuestra lista ordenada
        empresa.cabeza = new Trabajador("1001", "Carlos Pérez", 5);
        empresa.cabeza.siguiente = new Trabajador("1005", "Ana Gómez", 3);

        // Creamos la cola con los datos del trabajo del día de hoy
        Queue<ReporteDia> colaDelDia = new LinkedList<>();
        colaDelDia.add(new ReporteDia("1001", "Supermercado X")); // Carlos repitió hoy
        colaDelDia.add(new ReporteDia("1003", "Tienda de Ropa Y")); // Trabajador nuevo
        colaDelDia.add(new ReporteDia("1005", "Supermercado X")); // Ana repitió hoy

        System.out.println("Procesando los datos de la cola de trabajo diario...\n");
        empresa.actualizarConCola(colaDelDia);

        // Mostramos cómo quedó la lista final ordenada
        empresa.mostrarLista();
    }
}    

