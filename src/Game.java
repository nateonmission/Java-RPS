import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    int gameCounter;
    LocalDateTime timeStamp;
    int p1Wins;
    int p2Wins;
    ArrayList<String> matchRecord;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.gameCounter = 0;
        this.timeStamp = LocalDateTime.now();
        this.p1Wins = 0;
        this.p2Wins = 0;
        this.matchRecord = new ArrayList<String>();
    }

    ///////////////  SETTERS  //////////////////
    public void incrementGameCounter() {
        this.gameCounter += 1;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setWins() {

        this.p1Wins = player1.getGamesWon();
        this.p2Wins = player2.getGamesWon();
    }



    public int[] getWins() {
        int[] winsArray = {p1Wins, p2Wins, gameCounter} ;
        return winsArray;
    }

    ///////////////  PLAYGAME  ////////////////
    public static int[] playGame(Scanner scan, String gameType){
        boolean playOn = true;
        clearScreenHack();

        System.out.println("Player 1, What is your name?");
        String name1 = scan.nextLine();

        Player player1 = new Player(0, name1, false);
        Player player2;

        if(gameType.equals("p")) {
            System.out.println("Player 2, What is your name?");
            String name2 = scan.nextLine();
            player2 = new Player(1, name2, false);
        } else {
            player2 = new Player(1, "Computer", true);
        }

        Game game = new Game(player1, player2);


        while(playOn) {
            clearScreenHack();
            Game.promptPlayer(player1);
            Game.promptPlayer(player2);

            int result = Game.findWinner(player1, player2);
            String winner;
            if(result == 1){
                winner = "Winner: Player1";
            } else if( result == -1) {
                winner = "Winner: Player2";
            } else {
                winner = "Tie";
            }

            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime timeStamp = LocalDateTime.now();
            game.setTimeStamp(timeStamp);

            String resultString = dateTimeFormat.format(timeStamp) + ", " +
                    winner + ", " +
                    "Player1: " + player1.getPlayerName() + ", " +
                    "Player1 Weapon: " + player1.getWeapon() + ", " +
                    "Player2: " + player2.getPlayerName() + ", " +
                    "Player2 Weapon: " + player2.getWeapon() + "\r\n";
            System.out.println( resultString );
            game.matchRecord.add(resultString);

            System.out.println(" ");

            boolean loopAgain = true;
            while (loopAgain) {
                System.out.println("Would you like to play again? (y/n)");
                String again = scan.nextLine();
                if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes")) {
                    loopAgain = false;
                } else if (again.equalsIgnoreCase("n") || again.equalsIgnoreCase("no")) {
                    playOn = false;
                    loopAgain = false;
                } else {
                    System.out.println("I don't understand. Please enter a Y or an N.");
                }

            }// loopAgain
            System.out.println(game.gameCounter);
            game.incrementGameCounter();


        }// playOn
        clearScreenHack();
        game.setWins();
        Helpers.writeMatchHistory(game.matchRecord);
        return game.getWins();
    }

    /////////////////  PROMPT PLAYER  //////////////////
    public static void promptPlayer(Player player)  {
        Scanner scan = new Scanner(System.in);

        if(player.playerNumber == 0) {
            System.out.println("______ _                         _____            ");
            System.out.println("| ___ \\ |                       |  _  |           ");
            System.out.println("| |_/ / | __ _ _   _  ___ _ __  | | | |_ __   ___ ");
            System.out.println("|  __/| |/ _` | | | |/ _ \\ '__| | | | | '_ \\ / _ \\");
            System.out.println("| |   | | (_| | |_| |  __/ |    \\ \\_/ / | | |  __/");
            System.out.println("\\_|   |_|\\__,_|\\__, |\\___|_|     \\___/|_| |_|\\___|");
            System.out.println("                __/ |                             ");
            System.out.println("               |___/                              ");
        } else if(player.playerNumber == 1 && !player.isComputer){
            System.out.println("______ _                         _____             ");
            System.out.println("| ___ \\ |                      |_   _|            ");
            System.out.println("| |_/ / | __ _ _   _  ___ _ __    | |_      _____  ");
            System.out.println("|  __/| |/ _` | | | |/ _ \\ '__|   | \\ \\ /\\ / / _ \\ ");
            System.out.println("| |   | | (_| | |_| |  __/ |      | |\\ V  V / (_) |");
            System.out.println("\\_|   |_|\\__,_|\\__, |\\___|_|      \\_/ \\_/\\_/ \\___/ ");
            System.out.println("                __/ |                              ");
            System.out.println("               |___/                              ");
        } else {
            System.out.println("   _____                            _            ");
            System.out.println("  / ____|                          | |           ");
            System.out.println(" | |     ___  _ __ ___  _ __  _   _| |_ ___ _ __ ");
            System.out.println(" | |    / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__|");
            System.out.println(" | |___| (_) | | | | | | |_) | |_| | ||  __/ |   ");
            System.out.println("  \\_____\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|   ");
            System.out.println("                       | |                       ");
            System.out.println("                       |_|                      ");
        }


        if(!player.isComputer) {
            boolean loopAgain = true;
            while (loopAgain) {
                System.out.println(player.playerName + ", Select your weapon of choice:");
                System.out.println("            [R]ock, [P]aper, [S]cissors");
                String response = scan.nextLine();
                if (
                        response.equalsIgnoreCase("r") ||
                        response.equalsIgnoreCase("p") ||
                        response.equalsIgnoreCase("s")
                ) {
                    if (response.equalsIgnoreCase("r")) {
                        player.setWeapon("rock");
                    } else if (response.equalsIgnoreCase("p")) {
                        player.setWeapon("paper");
                    } else {
                        player.setWeapon("scissors");
                    }
                    loopAgain = false;

                } else {
                    System.out.println("I do not understand. Please enter an R, P, or S");
                }
            }
        } else {
            System.out.println("COMPUTER is making its choice");
            player.setWeapon( Player.getAutomatedPlay());

        }
    }

    /////////////////// FIND WINNER  ////////////////////
    public static int findWinner(Player player1, Player player2){
        String p1Weapon = player1.getWeapon();
        String p2Weapon = player2.getWeapon();

        if(p1Weapon.equals(p2Weapon)){
            return 0;
        }

        String[] play= {p1Weapon, p2Weapon};
        Arrays.sort(play);

        String[] case1 = {"paper","rock"}; //paper
        String[] case2 = {"rock","scissors"}; //rock
        String[] case3 = {"paper","scissors"}; //scissors

        if(Arrays.equals(play, case1)){
            //paper
            if(p1Weapon.equals("paper")){
                player1.incrementGamesWon();
                return 1;

            } else {
                player2.incrementGamesWon();
                return -1;

            }
        } else if (Arrays.equals(play, case2)) {
            //rock
            if(p1Weapon.equals("rock")){
                player1.incrementGamesWon();
                return 1;
            } else {
                player2.incrementGamesWon();
                return -1;
            }
        }else if (Arrays.equals(play, case3)) {
            //scissors
            if(p1Weapon.equals("scissors")){
                player1.incrementGamesWon();
                return 1;
            } else {
                player2.incrementGamesWon();
                return -1;
            }
        }

        return 0;
    }

    ///////////////  CLEAR SCREEN  ///////////////
    public static void clearScreenHack(){
        for(int i = 0; i < 20; i++) {
            System.out.println(" ");
        }
    }

}
