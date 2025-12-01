import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Wheel of Fortune!");
        
        Scanner newScanner = new Scanner(System.in); // Input reader
        WheelOfFortune newGame = new WheelOfFortune(); // Game manager
        
        Player gamePlayers = new Player(); // Player data storage

        System.out.print("How many players will be playing (1-5)? ");
        int numOfPlayers = newScanner.nextInt(); // Get player count
        newScanner.nextLine();
        
        newGame.setupGame(numOfPlayers, gamePlayers); // Set up game and players
        
        boolean playing = true; // Main loop condition
        
        while (playing) {
            newGame.playRound(gamePlayers, ""); // Play one round, passing dummy string
        }
        
        newScanner.close();
    }
}