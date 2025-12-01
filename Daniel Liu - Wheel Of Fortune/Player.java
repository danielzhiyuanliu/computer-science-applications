public class Player {
    private String name;
    private int roundScore;
    private int totalWinnings;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.roundScore = 0;
        this.totalWinnings = 0;
    }

    // Accessors (Getters)
    public String getName() {
        return name;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }

    // Mutators (Setters/Updaters)
    public void addRoundScore(int points) {
        if (points > 0) {
            this.roundScore += points;
        }
    }

    public void deductRoundScore(int cost) {
        this.roundScore -= cost;
    }

    public void bankScore() {
        this.totalWinnings += this.roundScore;
    }

    public void resetRoundScore() {
        this.roundScore = 0;
    }
}