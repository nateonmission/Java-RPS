import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

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

    public static void promptPlayer(Player player){
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
        } else {
            System.out.println("______ _                         _____             ");
            System.out.println("| ___ \\ |                      |_   _|            ");
            System.out.println("| |_/ / | __ _ _   _  ___ _ __    | |_      _____  ");
            System.out.println("|  __/| |/ _` | | | |/ _ \\ '__|   | \\ \\ /\\ / / _ \\ ");
            System.out.println("| |   | | (_| | |_| |  __/ |      | |\\ V  V / (_) |");
            System.out.println("\\_|   |_|\\__,_|\\__, |\\___|_|      \\_/ \\_/\\_/ \\___/ ");
            System.out.println("                __/ |                              ");
            System.out.println("               |___/                              ");
        }

        boolean loopAgain = true;
        while(loopAgain) {
            System.out.println(player.playerName + ", Select your weapon of choice:");
            System.out.println("            [R]ock, [P]aper, [S]cissors");
            String respnse = scan.nextLine();
            if(
                    respnse.toLowerCase().equals("r") ||
                    respnse.toLowerCase().equals("p") ||
                    respnse.toLowerCase().equals("s")
            ){
                if(respnse.toLowerCase().equals("r")){
                    player.setWeapon("rock");
                } else if(respnse.toLowerCase().equals("p")) {
                    player.setWeapon("paper");
                } else {
                    player.setWeapon("scissors");
                }
                loopAgain = false;

            } else {
                System.out.println("I do not understand. Please enter an R, P, or S");
            }
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
        System.out.println("(other)");
        return 0;
    }


}
