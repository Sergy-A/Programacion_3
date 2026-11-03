package TallerProgra;

public class VTS_FavorEncontra {
    
    public static int getVotoConteo (int Afavor, int Encontra) {
        // Restamos los votos negativos de los positivos
        return Afavor - Encontra;
    }

    public static void main(String[] args) {
        System.out.println(getVotoConteo(13, 0));    // 13
        System.out.println(getVotoConteo(2, 33));    // -31
        System.out.println(getVotoConteo(132, 132)); // 0
    }
}
