public class Board {
    private String phrase; // Made private
    private String displayPhrase;
    private String guessedLetters;

    // Constructor
    public Board() {
        this.phrase = "";
        this.displayPhrase = "";
        this.guessedLetters = "";
    }

    // Accessors
    public String getDisplayPhrase() {
        return displayPhrase;
    }
    
    public String getGuessedLetters() {
        return guessedLetters;
    }
    
    // Getter to allow WheelOfFortune to check the solution
    public String getPhrase() {
        return phrase;
    }

    // Mutators
    public void loadPhrase(String newPhrase) {
        this.phrase = newPhrase.toUpperCase(); // Phrase is stored uppercase
        this.displayPhrase = initializeDisplay(this.phrase);
        this.guessedLetters = "";
    }

    private String initializeDisplay(String p) {
        String display = "";
        for (int i = 0; i < p.length(); i++) {
            if (Character.isLetter(p.toUpperCase().charAt(i))) {
                display += "_ ";
            } else if (Character.isWhitespace(p.toUpperCase().charAt(i))) {
                display += "  ";
            } else {
                display += p.toUpperCase().charAt(i) + " ";
            }
        }
        return display.trim();
    }

    // Returns: count (positive) if correct, 0 if not found, -1 if already guessed, -2 if not a letter.
    public int guessLetter(char guess) {
        char upperGuess = Character.toUpperCase(guess);
        
        if (!Character.isLetter(upperGuess)) {
            return -2;
        }
        
        if (guessedLetters.indexOf(upperGuess) != -1) {
            return -1; 
        }

        guessedLetters += upperGuess;
        
        int count = 0;
        String newDisplay = "";
        
        for (int i = 0; i < phrase.length(); i++) {
            char phraseChar = phrase.toUpperCase().charAt(i);

            if (phraseChar == upperGuess) {
                newDisplay += upperGuess + " ";
                count++;
            } else {
                if (Character.isLetter(phraseChar) && guessedLetters.indexOf(phraseChar) == -1) {
                    newDisplay += "_ ";
                } 
                else if (Character.isLetter(phraseChar) && guessedLetters.indexOf(phraseChar) != -1) {
                    newDisplay += phraseChar + " ";
                } 
                else if (Character.isWhitespace(phraseChar)) {
                    newDisplay += "  ";
                } else {
                    newDisplay += phraseChar + " ";
                }
            }
        }

        this.displayPhrase = newDisplay.trim();
        return count;
    }

    public boolean isSolved() {
        return this.displayPhrase.indexOf('_') == -1;
    }
}