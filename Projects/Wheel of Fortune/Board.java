import java.io.File;
import java.util.Scanner;

public class Board {
    private String phrase; // The secret phrase/puzzle
    private String displayPhrase; // The phrase shown to players (with underscores)
    private String guessedLetters; // All revealed letters
    private String wrongGuesses; // Only incorrect guesses

    public Board() {
        phrase = "";
        displayPhrase = "";
        guessedLetters = "";
        wrongGuesses = "";
    }

    public String getPhrase() {
        return phrase; // Access secret phrase
    }

    public String getDisplayPhrase() {
        return displayPhrase; // Access displayed puzzle
    }
    
    public String getWrongGuesses() {
        return wrongGuesses; // Access incorrect guesses
    }

    public void setPhrase(String newPhrase) {
        phrase = newPhrase.toUpperCase(); // Set new phrase in uppercase
        displayPhrase = hideMessage(newPhrase); // Create hidden display
        guessedLetters = ""; // Reset guesses
        wrongGuesses = ""; // Reset wrong guesses
    }
    
    public void setDisplayPhrase(String newDisplayPhrase) {
        displayPhrase = newDisplayPhrase; // Set the solved phrase
    }
    
    public String loadPhrase() {
        String tempPhrase = "";
        int numOfLines = 0;
        
        // Pass 1: Count lines in the file
        try {
            Scanner newScanner = new Scanner(new File("phrases.txt")); 

            try {
                while (true) { // Loop until file ends (no hasNextLine)
                    tempPhrase = newScanner.nextLine().trim();
                    numOfLines++; // Count lines for randomization
                }
            } catch (java.util.NoSuchElementException e) {
                // End of file reached
            }
            newScanner.close();
        } catch(Exception e) { System.out.println("File Error"); } // Handle file access issue
  
        // Fallback if file is empty or error occurred
        if (numOfLines == 0) {
            phrase = "DEFAULT PHRASE";
            displayPhrase = hideMessage(phrase);
            guessedLetters = "";
            wrongGuesses = "";
            return phrase;
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1); // Random line number
  
        // Pass 2: Re-read file to find the random phrase
        try{
            int count = 0;
            Scanner newScanner = new Scanner(new File("phrases.txt"));
            
            try {
                while (true) { // Loop until file ends
                    count++;
                    String temp = newScanner.nextLine().trim();
                    if (count == randomInt){
                        tempPhrase = temp; // Select phrase at random line
                    }
                }
            } catch (java.util.NoSuchElementException e) {
                // End of file reached
            }
            newScanner.close();
        } catch (Exception e) { System.out.println("File Error"); } // Handle file access issue
        
        phrase = tempPhrase.toUpperCase(); // Store uppercase phrase
        displayPhrase = hideMessage(phrase); // Initialize display
        guessedLetters = "";
        wrongGuesses = "";
        return phrase;
    }

    public String hideMessage(String message) {
        String hidden = ""; 
        int n = message.length();
        
        for (int i = 0; i < n; i++) {
            String c = message.substring(i, i + 1);

            if (c.equals(" ")) {
                hidden = hidden + " "; // Keep spaces visible
            } else {
                hidden = hidden + "_"; // Hide letters
            }
        } return hidden;
    }
    
    public boolean isLetterAlreadyGuessed(String letter) {
        return guessedLetters.indexOf(letter) != -1; // Check if letter exists in guessedLetters
    }

    public int checkAndRevealLetter(String letter) {
        
        if (isLetterAlreadyGuessed(letter)) {
            return -1; // Already guessed
        }

        guessedLetters = guessedLetters + letter; // Add to all guesses
        
        boolean found = false;
        String newDisplay = "";
        
        for (int i = 0; i < phrase.length(); i++) {
            String originalChar = phrase.substring(i, i + 1);
            String displayChar = displayPhrase.substring(i, i + 1);
            
            if (originalChar.equals(letter)) {
                newDisplay = newDisplay + letter; // Reveal the letter
                found = true;
            } 
            else if (!displayChar.equals("_")) {
                newDisplay = newDisplay + displayChar; // Keep already revealed letters
            }
            else {
                newDisplay = newDisplay + "_"; // Keep hidden
            }
        }
        
        displayPhrase = newDisplay; // Update display
        
        if (found) {
            return 1; // Correct guess
        } else {
            wrongGuesses = wrongGuesses + letter; // Add to incorrect list
            return 0; // Incorrect guess
        }
    }
    
    public int countLetter(String letter) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            String originalChar = phrase.substring(i, i + 1);
            if (originalChar.equals(letter)) {
                count++; // Count occurrences of letter
            }
        }
        return count;
    }

    public boolean isSolved() {
        return displayPhrase.indexOf("_") == -1; // Check if any letter is still hidden
    }
    
    public boolean hasHiddenVowels() {
        // Check if vowels A, E, I, O, U are in the phrase AND not yet revealed
        if (phrase.indexOf("A") != -1 && displayPhrase.indexOf("A") == -1) {
            return true;
        }
        if (phrase.indexOf("E") != -1 && displayPhrase.indexOf("E") == -1) {
            return true;
        }
        if (phrase.indexOf("I") != -1 && displayPhrase.indexOf("I") == -1) {
            return true;
        }
        if (phrase.indexOf("O") != -1 && displayPhrase.indexOf("O") == -1) {
            return true;
        }
        if (phrase.indexOf("U") != -1 && displayPhrase.indexOf("U") == -1) {
            return true;
        }
        
        return false; // All vowels are revealed or not in phrase
    }

    public static void main(String[] args) {
    }
}