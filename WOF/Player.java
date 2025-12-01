public class Player {
    private String playerOneName = null; // Player 1 name
    private String playerTwoName = null; // Player 2 name
    private String playerThreeName = null; // Player 3 name
    private String playerFourName = null; // Player 4 name
    private String playerFiveName = null; // Player 5 name

    private int playerOneScore = 0; // Player 1 round score
    private int playerTwoScore = 0; // Player 2 round score
    private int playerThreeScore = 0; // Player 3 round score
    private int playerFourScore = 0; // Player 4 round score
    private int playerFiveScore = 0; // Player 5 round score
    
    private int playerOneTotalWinnings = 0; // Player 1 total banked money
    private int playerTwoTotalWinnings = 0; // Player 2 total banked money
    private int playerThreeTotalWinnings = 0; // Player 3 total banked money
    private int playerFourTotalWinnings = 0; // Player 4 total banked money
    private int playerFiveTotalWinnings = 0; // Player 5 total banked money
    
    public Player() {
    }

    public void setPlayerName(String name) {
        // Assign name to the first available player slot
        if (playerOneName == null) {
            playerOneName = name;
        } else if (playerTwoName == null) {
            playerTwoName = name;
        } else if (playerThreeName == null) {
            playerThreeName = name;
        } else if (playerFourName == null) {
            playerFourName = name;
        } else {
            playerFiveName = name;
        } 
    } 

    public String getPlayerName(int currentPlayer) {
        // Retrieve name based on player index
        if (currentPlayer == 1) {
            return playerOneName;
        } else if (currentPlayer == 2) {
            return playerTwoName;
        } else if (currentPlayer == 3) {
            return playerThreeName;
        } else if (currentPlayer == 4) {
            return playerFourName;
        } else {
            return playerFiveName;
        }
    }

    public int getPlayerScore (int currentPlayer) {
        // Retrieve current round score
        if (currentPlayer == 1) {
            return playerOneScore;
        } else if (currentPlayer == 2) {
            return playerTwoScore;
        } else if (currentPlayer == 3) {
            return playerThreeScore;
        } else if (currentPlayer == 4) {
            return playerFourScore;
        } else {
            return playerFiveScore;
        }
    }

    public int getTotalWinnings (int currentPlayer) {
        // Retrieve total banked winnings
        if (currentPlayer == 1) {
            return playerOneTotalWinnings;
        } else if (currentPlayer == 2) {
            return playerTwoTotalWinnings;
        } else if (currentPlayer == 3) {
            return playerThreeTotalWinnings;
        } else if (currentPlayer == 4) {
            return playerFourTotalWinnings;
        } else {
            return playerFiveTotalWinnings;
        }
    }

    public void addPoints(int currentPlayer, int points) {
        // Add points to current round score
        if (currentPlayer == 1) {
            playerOneScore += points;
        } else if (currentPlayer == 2) {
            playerTwoScore += points;
        } else if (currentPlayer == 3) {
            playerThreeScore += points;
        } else if (currentPlayer == 4) {
            playerFourScore += points;
        } else {
            playerFiveScore += points;
        }
    }

    public boolean checkVowelEligibility(int currentPlayer) {
        return getPlayerScore(currentPlayer) >= 500; // Check if score is $500 or more
    }

    public void deductVowelCost(int currentPlayer) {
        // Deduct $500 for a vowel purchase
        if (checkVowelEligibility(currentPlayer)) {
            if (currentPlayer == 1) {
                playerOneScore = playerOneScore - 500;
            } else if (currentPlayer == 2) {
                playerTwoScore = playerTwoScore - 500;
            } else if (currentPlayer == 3) {
                playerThreeScore = playerThreeScore - 500;
            } else if (currentPlayer == 4) {
                playerFourScore = playerFourScore - 500;
            } else {
                playerFiveScore = playerFiveScore - 500;
            }
        }
    }
    
    public void bankAndResetScore(int winningPlayer) {
        // Transfer winning score to total winnings; reset all round scores
        if (winningPlayer == 1) {
            playerOneTotalWinnings += playerOneScore;
            playerOneScore = 0;
        } else if (winningPlayer == 2) {
            playerTwoTotalWinnings += playerTwoScore;
            playerTwoScore = 0;
        } else if (winningPlayer == 3) {
            playerThreeTotalWinnings += playerThreeScore;
            playerThreeScore = 0;
        } else if (winningPlayer == 4) {
            playerFourTotalWinnings += playerFourScore;
            playerFourScore = 0;
        } else if (winningPlayer == 5) {
            playerFiveTotalWinnings += playerFiveScore;
            playerFiveScore = 0;
        }
        
        // Reset scores for non-winners
        if (winningPlayer != 1) { playerOneScore = 0; }
        if (winningPlayer != 2) { playerTwoScore = 0; }
        if (winningPlayer != 3) { playerThreeScore = 0; }
        if (winningPlayer != 4) { playerFourScore = 0; }
        if (winningPlayer != 5) { playerFiveScore = 0; }
    }
    
    public void resetRoundScores(int totalPlayers) {
        // Reset all player's current round scores
        if (totalPlayers >= 1) { playerOneScore = 0; }
        if (totalPlayers >= 2) { playerTwoScore = 0; }
        if (totalPlayers >= 3) { playerThreeScore = 0; }
        if (totalPlayers >= 4) { playerFourScore = 0; }
        if (totalPlayers >= 5) { playerFiveScore = 0; }
    }
}