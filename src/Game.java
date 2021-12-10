import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    Player player1;
    Player player2;
    int turnCounter;
    int gameCounter;
    LocalDate timeStamp;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.turnCounter = 0;
        this.gameCounter = 0;
        this.timeStamp = null;
    }

    public void setPlayer(int i, Player player) {
        if(i == 0) {
            this.player1 = player;
        } else {
            this.player2 = player;
        }
    }

    private void setTurnCounterCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }
    public void incrementTurnCounter() {
        this.turnCounter += 1;
    }
    private void setGameCounter(int gameCounter) {
        this.gameCounter = gameCounter;
    }
    public void incrementGameCounter() {
        this.gameCounter += 1;
    }


    public static void playGame(Scanner scan, String gameType){
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
            System.out.println(result);

            if(result == 1){
                winner = "Winner: Player1";
            } else if( result == -1) {
                winner = "Winner: Player2";
            } else {
                winner = "Tie";
            }

            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime timeStamp = LocalDateTime.now();

            String resultString = dateTimeFormat.format(timeStamp) + ", " +
                    winner + ", " +
                    "Player1: " + player1.getPlayerName() + ", " +
                    "Player1 Weapon: " + player1.getWeapon() + ", " +
                    "Player2: " + player2.getPlayerName() + ", " +
                    "Player2 Weapon: " + player2.getWeapon();
            System.out.println( resultString );
            game.incrementGameCounter();

            System.out.println(" ");

            boolean loopAgain = true;
            while (loopAgain) {
                System.out.println("Would you like to play again? (y/n)");
                String again = scan.nextLine();
                if (again.toLowerCase().equals("y") || again.toLowerCase().equals("yes")) {
                    playOn = true;
                    loopAgain = false;
                } else if (again.toLowerCase().equals("n") || again.toLowerCase().equals("no")) {
                    playOn = false;
                    loopAgain = false;
                } else {
                    System.out.println("I don't understand. Please enter a Y or an N.");
                }
            }

        }

    }



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
            System.out.println("");
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
                String respnse = scan.nextLine();
                if (
                        respnse.toLowerCase().equals("r") ||
                        respnse.toLowerCase().equals("p") ||
                        respnse.toLowerCase().equals("s")
                ) {
                    if (respnse.toLowerCase().equals("r")) {
                        player.setWeapon("rock");
                    } else if (respnse.toLowerCase().equals("p")) {
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

    public static int findWinner(Player player1, Player player2){
        int result = 0;
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
                return 1;

            } else {
                return -1;

            }
        } else if (Arrays.equals(play, case2)) {
            //rock
            if(p1Weapon.equals("rock")){
                return 1;
            } else {
                return -1;
            }
        }else if (play.equals(case3)) {
            //scissors
            if(p1Weapon.equals("scissors")){
                return 1;
            } else {
                return -1;
            }
        }

        return 0;
    }






    public static void clearScreenHack(){
        for(int i = 0; i < 20; i++) {
            System.out.println(" ");
        }
    }

    public static void clearScreen(){
        try{
            String operatingSystem = System.getProperty("os.name");

            if(operatingSystem.contains("Windows")){
                ProcessBuilder clearProcess = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = clearProcess.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder clearProcess = new ProcessBuilder("clear");
                Process startProcess = clearProcess.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
