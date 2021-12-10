import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        printOpening();
        scan.nextLine();

        clearScreenHack();
        printMainMenu();

        boolean loopAgain = true;
        while(loopAgain) {
            String response = scan.nextLine();


            if (response.toLowerCase().equals("p")) {
                humanGame(scan);
            } else if(response.toLowerCase().equals("x")) {
                loopAgain = false;

            } else {
                System.out.println("I do not understand. Please enter a P, C, G, or X");
            }
        }

        System.out.println("GOODBYE");
        scan.close();
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

    public static void printOpening() {
        System.out.println("______           _       ______                       _____      _                        ");
        System.out.println("| ___ \\         | |      | ___ \\                     /  ___|    (_)                       ");
        System.out.println("| |_/ /___   ___| | __   | |_/ /_ _ _ __   ___ _ __  \\ `--.  ___ _ ___ ___  ___  _ __ ___ ");
        System.out.println("|    // _ \\ / __| |/ /   |  __/ _` | '_ \\ / _ \\ '__|  `--. \\/ __| / __/ __|/ _ \\| '__/ __|");
        System.out.println("| |\\ \\ (_) | (__|   < _  | | | (_| | |_) |  __/ |_   /\\__/ / (__| \\__ \\__ \\ (_) | |  \\__ \\");
        System.out.println("\\_| \\_\\___/ \\___|_|\\_( ) \\_|  \\__,_| .__/ \\___|_( )  \\____/ \\___|_|___/___/\\___/|_|  |___/");
        System.out.println("                     |/            | |          |/                                        ");
        System.out.println("                                   |_|                                                    ");
        System.out.println("Press ENTER key to continue.");
    }

    public static void printMainMenu(){
        System.out.println("========================================");
        System.out.println("=               MAIN MENU              =");
        System.out.println("========================================");
        System.out.println("[P]lay a 2-person game");
        System.out.println("[C]omputer opponent vs. you");
        System.out.println("[G]ame history");
        System.out.println("e[X]it");
        System.out.println("Enter [P, C, G, or X], then press ENTER");
    }

    public static void humanGame(Scanner scan){
        boolean playOn = true;

        clearScreenHack();
        System.out.println("Player 1, What is your name?");
        String name1 = scan.nextLine();

        System.out.println("Player 2, What is your name?");
        String name2 = scan.nextLine();

        Player player1 = new Player(0, name1, false);
        Player player2 = new Player(1, name2, false);

        Game game = new Game(player1, player2);

        while(playOn) {
            clearScreenHack();
            Game.promptPlayer(player1);
            Game.promptPlayer(player2);
            int result = Game.findWinner(player1, player2);
            System.out.println(result);

            game.incrementGameCounter();
            playOn =false;

        }

    }


}
