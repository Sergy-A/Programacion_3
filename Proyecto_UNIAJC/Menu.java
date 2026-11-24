package Proyecto_UNIAJC;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object sistema = null;

        try {
            sistema = Class.forName("Proyecto_UNIAJC.servicio.SistemaUNI")
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (ReflectiveOperationException e) {
            System.out.println("Error al cargar SistemaUNI: " + e.getMessage());
        }

        int opcion = 0;

        do {
            System.out.println("\n=== PLANIFICACIÓN ACADÉMICA SISTEMA UNIVERSITARIO ===");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5. Crear materia");
            System.out.println("6. Agregar pre-requisito");
            System.out.println("7. Mostrar pre-requisitos");
            System.out.println("8. Inscribir estudiante");
            System.out.println("9. Cancelar inscripcion");
            System.out.println("10. Mostrar cola de espera");
            System.out.println("=== GESTION DE HORARIOS ===");
            System.out.println("11. Reservar horario en aula");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar disponibilidad");
            System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
            System.out.println("14. Agregar conexion entre edificios");
            System.out.println("15. Calcular ruta mas corta (Dijkstra)");
            System.out.println("=== REPORTES ACADEMICOS ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte academico");
            System.out.println("18. Navegador de reportes (atras/adelante)");
            System.out.println("=== SISTEMA DESHACER/REHACER ===");
            System.out.println("19. Deshacer última operacion");
            System.out.println("20. Rehacer ultima operacion");
            System.out.println("=== PROCESAMIENTO POR LOTES ===");
            System.out.println("21. Procesar archivo CSV");
            System.out.println("=== SALIR ===");
            System.out.println("22. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("REGISTRO DE ESTUDIANTE");
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Semestre actual: ");
                        int semestre = Integer.parseInt(scanner.nextLine());

                        java.lang.reflect.Method registrar = sistema.getClass().getMethod(
                                "registrarEstudiante", String.class, String.class, String.class, int.class);
                        registrar.invoke(sistema, id, nombre, email, semestre);
                        System.out.println("Estudiante registrado exitosamente.");
                        break;

                    case 2:
                        System.out.print("ID a buscar: ");
                        String idBuscar = scanner.nextLine();
                        Object estudiante = sistema.getClass()
                                .getMethod("buscarEstudiante", String.class)
                                .invoke(sistema, idBuscar);
                        estudiante.getClass()
                                .getMethod("mostrarInformacion")
                                .invoke(estudiante);
                        break;

                    case 15:
                        // Ejemplo Dijkstra origen 0, destino 3 (Ingenieria a Rectoria)
                        sistema.getClass()
                                .getMethod("calcularRutaDijkstra", int.class, int.class)
                                .invoke(sistema, 0, 3);
                        break;

                    case 22:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción en desarrollo o inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
            }

        } while (opcion != 22);

        scanner.close();
    }
}
