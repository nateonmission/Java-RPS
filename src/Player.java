import java.util.Random;

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

    /////////////// SETTERS & GETTERS  ///////////////
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setComputer(boolean computer) {
        this.isComputer = computer;
    }

    private void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon() {
        this.gamesWon += 1;
    }

    public void setWeapon(String weapon) { this.weapon = weapon; }

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


    ////////////////  AUTOMATED PLAYER  //////////////////
    public static String getAutomatedPlay(){
        String[] playOptions = {"rock","paper","scissors"};

        int randomNumber = new Random().nextInt(playOptions.length);
        return playOptions[randomNumber];
    }

}
