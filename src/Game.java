public class Game {
    Player player1;
    Player player2;
    int gameCounter;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.gameCounter = 0;
    }

    public void setPlayer(int i, Player player) {
        if(i == 1) {
            this.player1 = player;
        } else {
            this.player2 = player;
        }
    }

    private void setGameCounter(int gameCounter) {
        this.gameCounter = gameCounter;
    }
    public void incrementGameCounter(int gameCounter) {
        this.gameCounter = this.gameCounter++;
    }
}
