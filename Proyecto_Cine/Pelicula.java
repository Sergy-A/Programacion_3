package Proyecto_Cine;
// Clase abstracta base para el catálogo de películas
abstract class Pelicula {
    private String nombre;
    private String idioma;
    private int duracion;

    public Pelicula(String nombre, String idioma, int duracion) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.duracion = duracion;
    }

    public String getNombre() { return nombre; }
    public abstract String getTipo(); // Método polimórfico para obtener el formato (35mm o 3D)

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Idioma: " + idioma + " | Tipo: " + getTipo() + " | Duración: " + duracion + " min");
    }
}

// Subclase para formato tradicional (Salas 1 y 2)
class Pelicula2D extends Pelicula {
    public Pelicula2D(String nombre, String idioma, int duracion) {
        super(nombre, idioma, duracion);
    }

    @Override
    public String getTipo() { return "35mm"; }
}

// Subclase para formato 3D (Sala 3)
class Pelicula3D extends Pelicula {
    public Pelicula3D(String nombre, String idioma, int duracion) {
        super(nombre, idioma, duracion);
    }

    @Override
    public String getTipo() { return "3D"; }
}