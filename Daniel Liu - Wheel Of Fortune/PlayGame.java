import java.util.Scanner; // the only thing that doesn't work is solving

public class PlayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WheelOfFortune game = new WheelOfFortune();

        System.out.println("Welcome to Wheel of Fortune!");
        game.setupGame(scanner);

        boolean playing = true;
        
        while (playing) {
            game.playRound(scanner);

            playing = game.playAgain(scanner);
        }

        game.displayFinalScores();
        
        scanner.close();
    }
}