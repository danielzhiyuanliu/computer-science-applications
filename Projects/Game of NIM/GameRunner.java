/**
 * Project 2.2.11
 *
 * GameRunner Class for the Game of Nim 
*/

import java.util.Scanner;

public class GameRunner {
    public static Scanner mainScanner = new Scanner(System.in);
    
    public static Boolean isPlaying = false;

    public static String playerOne;
    public static String playerTwo;
    public static void main(String[] args) {        
        System.out.println("\nWelcome to the Game of Nim!\n");

        System.out.println("In this game, players take turns removing pieces from the pile.");
        System.out.println("The last player to take a piece loses.\n");

        Game nim = new Game();  
        isPlaying = true;

        System.out.print("What is Player One's name? ");
        playerOne = mainScanner.nextLine();

        System.out.print("What is Player Two's name? ");
        playerTwo = mainScanner.nextLine();
        
        while (isPlaying) {
            Board.populate(); 
            System.out.println("\nThe pile size is " + Board.pileSize + ".\n");
            
            nim.play();
        }
    }
}
