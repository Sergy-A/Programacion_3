package Proyecto_Cine;
import java.util.Scanner;

public class MenuPrincipal {
    private Teatro teatro;
    private Scanner scanner = new Scanner(System.in);
    private String[] franjas = {"14:00 - 16:30", "16:30 - 19:00", "19:00 - 21:00"};

    public MenuPrincipal(Teatro teatro) {
        this.teatro = teatro;
    }

    public void iniciar() {
        int op;
        do {
            System.out.println("\n=== CINEMASTAR ===\n1. Crear Película\n2. Asignar Función\n3. Ventas\n4. Salir");
            op = leerEntero("Opción: ");
            if (op == 1) menuPeliculas();
            else if (op == 2) menuFunciones();
            else if (op == 3) menuVentas();
        } while (op != 4);
        
        System.out.println("¡Gracias por usar CinemaStar!");
    }

    private int leerEntero(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Entrada no válida. " + msg);
        }
        int v = scanner.nextInt();
        scanner.nextLine();
        return v;
    }

    private void menuPeliculas() {
        teatro.listarPeliculas();
        System.out.print("\n¿Agregar película? (S/N): ");
        if (!scanner.nextLine().trim().equalsIgnoreCase("S")) return;

        System.out.print("Nombre: "); String n = scanner.nextLine();
        System.out.print("Idioma: "); String i = scanner.nextLine();
        System.out.print("Tipo (35mm / 3D): "); String t = scanner.nextLine().trim();
        int d = leerEntero("Duración (min): ");

        // Creación condicional del objeto según su subclase
        Pelicula p = t.equalsIgnoreCase("35mm") ? new Pelicula2D(n, i, d) : 
                     (t.equalsIgnoreCase("3D") ? new Pelicula3D(n, i, d) : null);

        if (p != null && d > 0) teatro.agregarPelicula(p);
        else System.out.println("Error en los datos o formato.");
    }

    private void menuFunciones() {
        if (teatro.getContadorPeliculas() == 0) { System.out.println("Sin películas cargadas."); return; }
        
        Sala sala = teatro.getSala(leerEntero("Sala (1-3): "));
        if (sala == null) return;

        System.out.println("Franjas: [1] 14:00-16:30 | [2] 16:30-19:00 | [3] 19:00-21:00");
        int f = leerEntero("Franja (1-3): ") - 1;

        teatro.listarPeliculas();
        Pelicula p = teatro.getPeliculaPorIndice(leerEntero("Seleccione Película: ") - 1);

        if (p != null) sala.asignarFuncion(p, f, franjas[f]);
    }

    private void menuVentas() {
        Sala sala = teatro.getSala(leerEntero("Sala (1-3): "));
        if (sala == null) return;

        int f = leerEntero("Franja (1: 14:00 | 2: 16:30 | 3: 19:00): ") - 1;
        if (f < 0 || f >= 3 || sala.getFunciones()[f] == null) {
            System.out.println("No hay función en ese horario.");
            return;
        }

        Funcion fn = sala.getFunciones()[f];
        while (true) {
            fn.mostrarMapaEscenario();
            System.out.print("Ingrese sillas a comprar (ej: A1,B2) o 'SALIR': ");
            String txt = scanner.nextLine().trim();
            if (txt.equalsIgnoreCase("SALIR")) break;

            int total = 0, exitos = 0;
            // Separa la entrada por comas para procesar múltiples compras a la vez
            for (String c : txt.split(",")) {
                int costo = fn.comprarSilla(c.trim());
                if (costo != -1) { total += costo; exitos++; }
            }
            System.out.println(exitos > 0 ? "ÉXITO. Compradas: " + exitos + " | Total: $" + total : "Error en la compra.");
        }
    }
}