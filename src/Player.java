public class Player {
    int playerNumber;
    String playerName;
    String weapon;
    boolean isComputer;
    int gamesWon;

    Player(int playerNumber, String playerName, boolean isComputer){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.weapon = null;
        this.isComputer = isComputer;
        this.gamesWon = 0;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setComputer(boolean computer) {
        this.isComputer = computer;
    }

    private void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon(int gamesWon) {
        this.gamesWon = this.gamesWon++;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public String getWeapon() { return weapon;}
    public String getPlayerName() {
        return playerName;
    }

    public  boolean getComputer(){
        return isComputer;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getPlayerNumber() { return playerNumber; }



}
