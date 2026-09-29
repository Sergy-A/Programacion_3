package Proyecto_Cine;
public class Teatro {
    private Sala[] salas = new Sala[3];
    private Pelicula[] listaPeliculas = new Pelicula[50]; // Arreglo estático de catálogo
    private int contadorPeliculas = 0;

    public Teatro() {
        salas[0] = new SalaEstandar(1);
        salas[1] = new SalaEstandar(2);
        salas[2] = new Sala3D(3);
    }

    public boolean agregarPelicula(Pelicula p) {
        if (contadorPeliculas >= listaPeliculas.length) return false;
        listaPeliculas[contadorPeliculas++] = p;
        return true;
    }

    public void listarPeliculas() {
        if (contadorPeliculas == 0) {
            System.out.println("No hay películas registradas.");
            return;
        }
        for (int i = 0; i < contadorPeliculas; i++) {
            System.out.print("[" + (i + 1) + "] ");
            listaPeliculas[i].mostrarInformacion();
        }
    }

    public Pelicula getPeliculaPorIndice(int i) {
        return (i >= 0 && i < contadorPeliculas) ? listaPeliculas[i] : null;
    }

    public Sala getSala(int num) {
        return (num >= 1 && num <= 3) ? salas[num - 1] : null;
    }

    public int getContadorPeliculas() { return contadorPeliculas; }
}