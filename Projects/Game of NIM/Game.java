import java.util.Scanner;

public class Game { 
    public static Scanner newScanner = new Scanner(System.in);

    public static int scoreOne = 0;
    public static int scoreTwo = 0;

    public static String chosenPlayer = null;

    public void play() {

        double choosePlayer = Math.random();

        if (choosePlayer >= 0.5) {
            chosenPlayer = GameRunner.playerOne;
        } else {
            chosenPlayer = GameRunner.playerTwo;
        }

        while (!(Board.getPileSize() <= 1)) {
            myTurn(); //if the pile size is not too small, then switch turns
        }

        Game.switchPlayers();  //switching because we are at 1 they lose, 
        System.out.println("\nThe game is over! The winner is " + Game.chosenPlayer + ".");
        
        if (Game.chosenPlayer.equals(GameRunner.playerOne)) {
            scoreOne += 1;
        } else {
            scoreTwo += 1;
        } 
        
        System.out.println("The scores for " + GameRunner.playerOne + " is " + scoreOne + ".");
        System.out.println("The scores for " + GameRunner.playerTwo + " is " + scoreTwo + ".");
            
        System.out.println("\nDo you want to play again?");
        Boolean wantReplay = newScanner.nextBoolean();

        if (wantReplay) {
            GameRunner.isPlaying = true;
        } else {
            GameRunner.isPlaying = false;
            newScanner.close();
        }
    }


    public void myTurn() {
        int boardSize = Board.getPileSize();
        
        System.out.println("The turn goes to " + chosenPlayer + ".\n");
        System.out.print("How many pieces do you want to choose? ");
        int choosePiece = newScanner.nextInt();
        newScanner.nextLine();

        if (choosePiece < 1) {
            System.out.println("You must take at least one piece.");
            myTurn(); // don't switch players or penalize for mistake, prompt again
        } else if (choosePiece > (0.5 * boardSize)) {
            System.out.println("You can take no more than half the size of the pile.");
            myTurn();
        } else {
            int newSize = Board.subtractPile(choosePiece);
            System.out.println("\nThe new pile size is " + newSize + ".");
            switchPlayers();
        }
    }

    public static void switchPlayers() {
        if (chosenPlayer == GameRunner.playerOne) {
                chosenPlayer = GameRunner.playerTwo; // checks player and swaps to other
            } else {
                chosenPlayer = GameRunner.playerOne;
            }
    }
}