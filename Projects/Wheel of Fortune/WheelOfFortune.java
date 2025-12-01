import java.util.Scanner;

public class WheelOfFortune {
    Scanner newScanner = new Scanner(System.in); // User input
    private int currentPlayer = 1; // Current player number
    private int totalPlayers = 0; // Total players in game
    private Board gameBoard; // Puzzle and guess management

    public WheelOfFortune() {
        gameBoard = new Board(); // Initialize puzzle board
    }
    
    public Board getGameBoard() {
        return gameBoard; // Provide access to board
    }
    
    public void nextTurn() {
        currentPlayer++; // Increment player turn
        currentPlayer = (currentPlayer - 1) % totalPlayers + 1; // Cycle through players
    }
    
    // Helper method to format the phrase with spaces between characters
    private String formatDisplayPhrase(String phrase) {
        String spacedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            String c = phrase.substring(i, i + 1);
            
            if (c.equals(" ")) {
                 spacedPhrase += "  "; // Double space for block separation
            } else {
                 spacedPhrase += c;
                 spacedPhrase += " ";
            }
        }
        return spacedPhrase.trim(); // Remove trailing space
    }
    
    public void setupGame (int numOfPlayers, Player gamePlayers) {
        totalPlayers = numOfPlayers; // Set player count

        if (numOfPlayers < 1 || numOfPlayers > 5) {
            System.out.println("Please choose a number between 1 and 5.");
            System.out.print("How many players will be playing (1-5)? ");
            numOfPlayers = newScanner.nextInt();
            newScanner.nextLine();
            totalPlayers = numOfPlayers;
        }
        
        if (totalPlayers >= 1 && totalPlayers <= 5) {
            int playerCount = 0;

            while (playerCount != totalPlayers) {
                System.out.print("Enter name for Player " + (playerCount + 1) + ": ");
                String playerName = newScanner.next();
                gamePlayers.setPlayerName(playerName);
                playerCount++;
            }
            newScanner.nextLine(); 

            System.out.println("Let's start the game!"); // Announce game start
        }
    }
    
    public int spinWheel() {
        int spinValue = ((int) (Math.random() * 50) + 1) * 100; // Calculate spin amount ($100 to $5000)
        System.out.println("The wheel landed on $" + spinValue + "!");
        return spinValue;
    }
    
    public void playRound (Player gamePlayers, String dummyPhrase) { 
        if (gameBoard.getPhrase().equals("")) {
             String newPhrase = gameBoard.loadPhrase(); // Load phrase if new round
             System.out.println("\n--- NEW ROUND STARTED ---");
             System.out.println("The phrase is: " + formatDisplayPhrase(gameBoard.getDisplayPhrase()));
        }

        String name = gamePlayers.getPlayerName(currentPlayer); // Get current player name
        
        boolean turnLost = true; // Turn status (true=lost/solved, false=keep turn)
        boolean puzzleSolved = false; // Puzzle solution status

        do {
            System.out.println("\n"); // Display separator
            System.out.println("It is " + name + "'s turn!");
            System.out.println("Current Score: $" + gamePlayers.getPlayerScore(currentPlayer));
            System.out.println("Current Phrase: " + formatDisplayPhrase(gameBoard.getDisplayPhrase())); // Format phrase display
            
            String wrongGuesses = gameBoard.getWrongGuesses();
            if (wrongGuesses.length() > 0) {
                System.out.println("Wrong Guesses: " + wrongGuesses);
            } else {
                System.out.println("Wrong Guesses: None");
            }

            boolean canBuyVowel = gameBoard.hasHiddenVowels(); // Check if vowels are left
            
            String choicePrompt = "Choose (L)etter or (S)olve";
            if (canBuyVowel) {
                 choicePrompt = "Choose (L)etter, (V)owel, or (S)olve"; // Add Vowel option
            }
            
            System.out.print(name + ", " + choicePrompt + ": ");
            String playerChoice = newScanner.nextLine().toUpperCase();
            
            int actionResult = -1; // -1=Invalid, 0=Keep Turn, 1=Lose Turn, 2=Solved

            if (playerChoice.equals("L")) {
                actionResult = guessLetter(gamePlayers);
            } else if (playerChoice.equals("V")) {
                if (canBuyVowel) {
                    actionResult = buyVowel(gamePlayers);
                } else {
                    System.out.println("All vowels have been revealed. Please choose (L)etter or (S)olve.");
                }
            } else if (playerChoice.equals("S")) {
                actionResult = solvePuzzle(gamePlayers);
            } else {
                System.out.println("Invalid choice: " + playerChoice + ". Please try again.");
            }
            
            if (actionResult == 2) { // Puzzle solved
                puzzleSolved = true;
                turnLost = true;
            } else if (actionResult == 1) { // Turn lost
                turnLost = true;
            } else if (actionResult == 0) { // Correct guess, keep turn
                turnLost = false;
            } else if (actionResult == -1) { // Invalid action, repeat turn
                turnLost = false;
            }
            
        } while (turnLost == false && !puzzleSolved); // Continue if turn not lost and not solved

        if (puzzleSolved || gameBoard.isSolved()) {
            System.out.println("\n*** CONGRATULATIONS! The puzzle is SOLVED! ***");
            System.out.println("The phrase was: " + gameBoard.getPhrase());
            gamePlayers.bankAndResetScore(currentPlayer); // Transfer round score to total winnings
            System.out.println(name + " wins the round! Total Winnings: $" + gamePlayers.getTotalWinnings(currentPlayer));
            
            if (playAgain()) {
                gameBoard.setPhrase(""); // Reset board for new round
                gamePlayers.resetRoundScores(totalPlayers);
                currentPlayer = 1;
            } else {
                System.out.println("Thanks for playing! Final scores:");
                for (int i = 1; i <= totalPlayers; i++) {
                    System.out.println(gamePlayers.getPlayerName(i) + ": $" + gamePlayers.getTotalWinnings(i));
                }
                System.exit(0); // Terminate program
            }
        } else {
            nextTurn(); // Pass turn to next player
        }
    }
    
    private int guessLetter(Player gamePlayers) {
        System.out.print("Guess a consonant: ");
        String guessedLetter = newScanner.next().toUpperCase();
        newScanner.nextLine(); 
        
        if (guessedLetter.length() != 1 || guessedLetter.equals(" ")) {
            System.out.println("Invalid input. Please guess a single letter.");
            return -1; // Invalid input
        }
        
        guessedLetter = guessedLetter.substring(0, 1);
        
        if (guessedLetter.equals("A") || guessedLetter.equals("E") || guessedLetter.equals("I") || guessedLetter.equals("O") || guessedLetter.equals("U")) {
            System.out.println("That is a vowel. Please choose (V)owel option to buy a vowel.");
            return -1; // Guess was a vowel
        }
        
        if (gameBoard.isLetterAlreadyGuessed(guessedLetter)) {
            System.out.println("You already guessed the letter '" + guessedLetter + "'. Try another consonant.");
            return -1; // Already guessed
        }
        
        int spinAmount = spinWheel(); // Spin the wheel
        
        int checkResult = gameBoard.checkAndRevealLetter(guessedLetter); // Check letter
        
        if (checkResult == 1) { // Correct guess
            int count = gameBoard.countLetter(guessedLetter); // Count occurrences
            int pointsEarned = count * spinAmount; // Calculate earnings
            gamePlayers.addPoints(currentPlayer, pointsEarned); // Add points to score
            System.out.println("CORRECT! " + count + " " + guessedLetter + "'s found. You earned $" + pointsEarned + "!");
            
            if (gameBoard.isSolved()) { // If this guess solved the puzzle
                return 2; // Return 2 to end the round immediately
            }
            return 0; // Keep turn
        } else if (checkResult == 0) { // Incorrect guess
            System.out.println("INCORRECT! " + guessedLetter + " is not in the phrase. Turn lost.");
            return 1; // Lose turn
        } else {
            return -1; // Should not happen
        }
    }
    
    private int buyVowel(Player gamePlayers) {
        if (!gamePlayers.checkVowelEligibility(currentPlayer)) {
            System.out.println("You need at least $500 to buy a vowel. Current Score: $" + gamePlayers.getPlayerScore(currentPlayer) + ". Turn lost.");
            return 1; // Lose turn (not enough money)
        }
        
        System.out.print("Buy a vowel (A, E, I, O, U): ");
        String guessedVowel = newScanner.next().toUpperCase();
        newScanner.nextLine(); 
        
        if (guessedVowel.length() != 1 || (!guessedVowel.equals("A") && !guessedVowel.equals("E") && !guessedVowel.equals("I") && !guessedVowel.equals("O") && !guessedVowel.equals("U"))) {
            System.out.println("Invalid input. Please choose A, E, I, O, or U.");
            return -1; // Invalid input
        }
        
        guessedVowel = guessedVowel.substring(0, 1);
        
        if (gameBoard.isLetterAlreadyGuessed(guessedVowel)) {
            System.out.println("The vowel '" + guessedVowel + "' is already revealed. Choose a different vowel or action.");
            return -1; // Already revealed
        }
        
        gamePlayers.deductVowelCost(currentPlayer); // Pay $500
        System.out.println("Vowel cost: $500. New Score: $" + gamePlayers.getPlayerScore(currentPlayer));

        int checkResult = gameBoard.checkAndRevealLetter(guessedVowel); // Check vowel
        
        if (checkResult == 1) {
            System.out.println("CORRECT! The vowel(s) are revealed.");
            
            if (gameBoard.isSolved()) { // If this purchase solved the puzzle
                return 2; // Return 2 to end the round immediately
            }
            return 0; // Keep turn
        } else if (checkResult == 0) {
            System.out.println("INCORRECT! The vowel is not in the phrase. Turn lost.");
            return 1; // Lose turn
        } else {
            return -1; // Should not happen
        }
    }
    
    private int solvePuzzle(Player gamePlayers) {
        System.out.print("Enter your guess for the entire phrase: ");
        String guessedPhrase = newScanner.nextLine().toUpperCase();
        
        if (guessedPhrase.equals(gameBoard.getPhrase())) {
            gameBoard.setDisplayPhrase(gameBoard.getPhrase()); // Set phrase as solved
            return 2; // Solved
        } else {
            System.out.println("INCORRECT! That is not the phrase. Turn lost.");
            return 1; // Lose turn
        }
    }
    
    private boolean playAgain() {
        System.out.print("\nWould you like to play another round? (Y/N): ");
        String choice = newScanner.next().toUpperCase();
        newScanner.nextLine(); 
        
        return choice.equals("Y");
    }
}