public class Board {
    public static int pileSize;
    
    public static void populate() {
        pileSize = (int) (Math.random() * 40) + 10;
    }
}
