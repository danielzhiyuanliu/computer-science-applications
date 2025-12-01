import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortune {
    private Board board;
    private Player[] players;
    private int numPlayers;
    private int currentPlayerIndex;
    private Random random;

    // Constructor
    public WheelOfFortune() {
        this.board = new Board();
        this.players = new Player[5]; 
        this.numPlayers = 0;
        this.currentPlayerIndex = 0;
        this.random = new Random();
    }

    public Player getCurrentPlayer() {
        if (currentPlayerIndex >= 0 && currentPlayerIndex < numPlayers) {
            return players[currentPlayerIndex];
        }
        return null;
    }

    // Check for duplicate names
    public void setupGame(Scanner scanner) {
        int count = 0;
        while (count < 1 || count > 5) {
            System.out.print("Enter number of players (1-5): ");
            try {
                count = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        this.numPlayers = count;
        
        for (int i = 0; i < numPlayers; i++) {
            String name;
            boolean nameExists;
            
            do {
                System.out.print("Enter name for Player " + (i + 1) + ": ");
                name = scanner.nextLine().trim();
                nameExists = false;

                // Check for duplicates among players already created (j < i)
                for (int j = 0; j < i; j++) {
                    if (players[j].getName().equalsIgnoreCase(name)) {
                        nameExists = true;
                        System.out.println("ERROR: The name '" + name + "' is already taken. Please enter a different name.");
                        break;
                    }
                }
                
                if (name.isEmpty()) {
                    System.out.println("ERROR: Player name cannot be empty.");
                }
            } while (name.isEmpty() || nameExists);

            players[i] = new Player(name);
        }
    }

    public void loadPhrase() {
        try (Scanner fileScanner = new Scanner(new File("phrases.txt"))) {
            String[] phrases = new String[100];
            int phraseCount = 0;
            
            while (fileScanner.hasNextLine() && phraseCount < phrases.length) {
                phrases[phraseCount] = fileScanner.nextLine();
                phraseCount++;
            }

            if (phraseCount == 0) {
                System.out.println("Error: phrases.txt is empty. Using default phrase.");
                this.board.loadPhrase("A SAMPLE PHRASE");
                return;
            }

            int randomIndex = random.nextInt(phraseCount);
            String selectedPhrase = phrases[randomIndex];
            this.board.loadPhrase(selectedPhrase);

        } catch (FileNotFoundException e) {
            System.out.println("Error: phrases.txt file not found. Using default phrase.");
            this.board.loadPhrase("A SAMPLE PHRASE");
        }
    }

    public int spinWheel() {
        // Randomly choose an index between 0 and 52 (53 total spaces)
        // 0-49: Cash values ($100 to $5000)
        // 50: Lose a Turn (-1)
        // 51: Bankrupt (-2)
        // 52: Still cash (gives a slightly higher chance of cash)
        
        int roll = random.nextInt(53); 

        if (roll == 50) {
            return -1; // Lose a Turn
        } else if (roll == 51) {
            return -2; // Bankrupt
        } else {
            // Cash value (Roll 0-49 maps to $100-$5000, Roll 52 maps to $3500, average cash value)
            return (random.nextInt(50) + 1) * 100;
        }
    }

    public void changePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        System.out.println("\n--- Turn change! It's now " + getCurrentPlayer().getName() + "'s turn. ---");
    }

    public void buyVowel(Scanner scanner) {
        Player p = getCurrentPlayer();
        final int VOWEL_COST = 500;

        if (p.getRoundScore() < VOWEL_COST) {
            System.out.println("INPUT ERROR: " + p.getName() + ", you need $" + VOWEL_COST + " to buy a vowel (current score: $" + p.getRoundScore() + "). Please choose a different option (L or S).");
            return;
        }

        boolean validVowelGuess = false;
        while (!validVowelGuess) {
            System.out.println("Guessed Letters: " + board.getGuessedLetters());
            System.out.print("Buy a vowel for $" + VOWEL_COST + ". Enter A, E, I, O, or U: ");
            String vowelGuess = scanner.nextLine().trim().toUpperCase();

            if (vowelGuess.length() == 1 && "AEIOU".indexOf(vowelGuess) != -1) {
                
                char guess = vowelGuess.charAt(0);
                int count = board.guessLetter(guess);

                if (count == -1) {
                    System.out.println("INPUT ERROR: " + guess + " was already guessed. Try another vowel.");
                    continue; 
                }
                
                p.deductRoundScore(VOWEL_COST);
                validVowelGuess = true;

                if (count > 0) {
                    System.out.println("SUCCESS: Found " + count + " " + guess + "'s! You spent $" + VOWEL_COST + ".");
                    System.out.println("New Puzzle: " + board.getDisplayPhrase());
                } else {
                    System.out.println("FAILURE: " + guess + " is not in the puzzle. You spent $" + VOWEL_COST + " and lost turn.");
                    changePlayer();
                }
            } else {
                System.out.println("INPUT ERROR: Invalid vowel input. Please enter A, E, I, O, or U.");
            }
        }
    }

    // FIXED: Use board.getPhrase()
    public boolean solvePuzzle(Scanner scanner) {
        Player p = getCurrentPlayer();
        
        while (true) {
            System.out.print(p.getName() + ", type the complete phrase to solve the puzzle (case-sensitive): ");
            String solveAttempt = scanner.nextLine().trim().toUpperCase(); // Convert attempt to uppercase
            
            // FIX: Use getter to access the phrase for comparison
            if (solveAttempt.equals(board.getPhrase())) { 
                return true;
            } else { 
                System.out.println("FAILURE: That is incorrect! You lose your turn.");
                changePlayer();
                return false;
            }
        }
    }

    public boolean playRound(Scanner scanner) {
        loadPhrase();
        System.out.println("\n=============================================");
        System.out.println("               NEW ROUND STARTED               ");
        System.out.println("=============================================");
        System.out.println("The puzzle is: " + board.getDisplayPhrase());
        
        Player p = getCurrentPlayer(); 

        while (!board.isSolved()) {
            p = getCurrentPlayer();
            
            boolean validChoiceMade = false;
            
            while (!validChoiceMade) {
                System.out.println("\n---------------------------------------------");
                System.out.println(p.getName() + "'s turn | Round Score: $" + p.getRoundScore());
                System.out.println("Puzzle: " + board.getDisplayPhrase());
                
                System.out.print("Choose (L)etter, (V)owel, or (S)olve: ");
                String choice = scanner.nextLine().trim().toUpperCase();
                
                if (choice.equals("L")) {
                    validChoiceMade = true;
                    int points = spinWheel();

                    // --- SPIN OUTCOME HANDLING ---
                    if (points == -1) {
                        System.out.println("The wheel landed on LOSE A TURN!");
                        changePlayer();
                        break; 
                    } else if (points == -2) {
                        System.out.println("The wheel landed on BANKRUPT!");
                        p.resetRoundScore();
                        System.out.println("Your current round score has been reset to $0.");
                        changePlayer();
                        break; 
                    }
                    // --- END SPIN OUTCOME HANDLING ---
                    
                    System.out.println("The wheel spun to $" + points + "!");
                    
                    boolean validConsonantGuess = false;
                    while (!validConsonantGuess) {
                        
                        System.out.println("Guessed Letters: " + board.getGuessedLetters()); 
                        System.out.print("Guess a consonant: ");
                        String letterGuess = scanner.nextLine().trim().toUpperCase();
                        
                        if (letterGuess.length() != 1) {
                            System.out.println("INPUT ERROR: Please enter only one letter.");
                            continue;
                        }
                        
                        char guess = letterGuess.charAt(0);
                        
                        if ("AEIOU".indexOf(guess) != -1) {
                            System.out.println("INPUT ERROR: You must guess a consonant (not a vowel). Try again.");
                            continue; 
                        }

                        if ("BCDFGHJKLMNPQRSTVWXYZ".indexOf(guess) != -1) {
                            validConsonantGuess = true;
                            
                            int count = board.guessLetter(guess); 
                            
                            if (count > 0) {
                                p.addRoundScore(count * points);
                                System.out.println("SUCCESS: Found " + count + " " + guess + "'s! You earned $" + (count * points) + ".");
                            } else if (count == -1) {
                                System.out.println("INPUT ERROR: " + guess + " was already guessed. Try again.");
                                validConsonantGuess = false; 
                                continue;
                            } else { 
                                System.out.println("FAILURE: " + guess + " is not in the puzzle. Lost turn.");
                                changePlayer();
                            }
                        } else {
                             System.out.println("INPUT ERROR: Invalid character entered. Please enter a consonant.");
                        }
                    } 
                    
                } else if (choice.equals("V")) {
                    buyVowel(scanner); 
                    if (!board.isSolved()) {
                        validChoiceMade = true;
                    }
                    
                } else if (choice.equals("S")) {
                    validChoiceMade = true;
                    if (solvePuzzle(scanner)) {
                        break;
                    }
                } else {
                    System.out.println("INPUT ERROR: Invalid choice. Please enter L, V, or S.");
                }
            } 
            
            if (board.isSolved()) {
                System.out.println("\n*** The puzzle is solved: " + board.getDisplayPhrase() + " ***");
                break;
            }
        } 
        
        if (board.isSolved()) {
            p = getCurrentPlayer(); 
            p.bankScore();
            System.out.println("\n>>> CONGRATULATIONS, " + p.getName() + "! You won the round!");
            System.out.println(">>> Your Round Score ($" + p.getRoundScore() + ") has been banked.");
            System.out.println(">>> Total Winnings: $" + p.getTotalWinnings());
            return true;
        }
        return false;
    }

    public boolean playAgain(Scanner scanner) {
        System.out.print("\nDo you want to play another round? (y/n): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("y")) {
            for (int i = 0; i < numPlayers; i++) {
                players[i].resetRoundScore();
            }
            this.currentPlayerIndex = 0;
            return true;
        }
        return false;
    }

    public void displayFinalScores() {
        System.out.println("\n=============================================");
        System.out.println("             GAME OVER - FINAL SCORES          ");
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(players[i].getName() + ": $" + players[i].getTotalWinnings());
        }
        System.out.println("=============================================");
    }
}