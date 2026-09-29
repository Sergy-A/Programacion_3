package Proyecto_Cine;
// Clase abstracta base que maneja el comportamiento general de las salas
abstract class Sala {
    protected int numero;
    protected Funcion[] funciones = new Funcion[3]; // Arreglo fijo para las 3 franjas horarias del día

    public Sala(int numero) {
        this.numero = numero;
    }

    public int getNumero() { return numero; }
    public Funcion[] getFunciones() { return funciones; }

    public abstract boolean esPeliculaPermitida(Pelicula pelicula); // Restricción de formato por tipo de sala

    public boolean asignarFuncion(Pelicula pelicula, int indiceFranja, String textoFranja) {
        // Valida que la franja esté libre y sea compatible con el tipo de película
        if (indiceFranja < 0 || indiceFranja >= 3 || funciones[indiceFranja] != null) {
            System.out.println("Error: Franja no válida o ya se encuentra ocupada.");
            return false;
        }
        if (!esPeliculaPermitida(pelicula)) {
            System.out.println("Error: Formato de película no permitido en la Sala " + numero + ".");
            return false;
        }

        funciones[indiceFranja] = new Funcion(pelicula, textoFranja, this.numero);
        System.out.println("Éxito: Función programada correctamente.");
        return true;
    }
}

// Subclase para Salas 1 y 2 (Tienen General y Preferencial, solo admiten 35mm)
class SalaEstandar extends Sala {
    public SalaEstandar(int numero) { super(numero); }

    @Override
    public boolean esPeliculaPermitida(Pelicula pelicula) {
        return pelicula instanceof Pelicula2D; // Solo permite objetos de tipo 2D / 35mm
    }
}

// Subclase para Sala 3 (Exclusiva para 3D)
class Sala3D extends Sala {
    public Sala3D(int numero) { super(numero); }

    @Override
    public boolean esPeliculaPermitida(Pelicula pelicula) {
        return pelicula instanceof Pelicula3D; // Solo permite objetos de tipo 3D
    }
}