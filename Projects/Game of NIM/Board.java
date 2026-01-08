public class Board {
    private static int pileSize;

    public static void populate() {
        pileSize = (int) (Math.random() * 41) + 10; // casting rounds down 39.999 repeating so make it 41
    }
    
    public static int getPileSize() {
        return pileSize;
    }

    public static int subtractPile(int removeTiles) {
        pileSize -= removeTiles;
        return pileSize;
    }
}
