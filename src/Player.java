public class Player {
    String playerName;
    boolean isComputer;
    int gamesWon;

    Player(String playerName, boolean isComputer){
        this.playerName = playerName;
        this.isComputer = isComputer;
        this.gamesWon = 0;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    private void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon(int gamesWon) {
        this.gamesWon = this.gamesWon++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public  boolean getComputer(){
        return isComputer;
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
