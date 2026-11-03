package TallerProgra;

public class VTS_FavorEncontra {
    
    public static int getVoteCount(int upvotes, int downvotes) {
        // Restamos los votos negativos de los positivos
        return upvotes - downvotes;
    }

    public static void main(String[] args) {
        System.out.println(getVoteCount(13, 0));    // 13
        System.out.println(getVoteCount(2, 33));    // -31
        System.out.println(getVoteCount(132, 132)); // 0
    }
}
