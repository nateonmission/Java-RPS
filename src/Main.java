import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        printOpening();
        scan.nextLine();

        Game.clearScreenHack();
        printMainMenu();

        boolean loopAgain = true;
        while(loopAgain) {
            String response = scan.nextLine();

            if (response.toLowerCase().equals("p")) {
                Game.playGame(scan, response);
            } else if (response.toLowerCase().equals("c")) {
                Game.playGame(scan, response);
            } else if(response.toLowerCase().equals("x")) {
                loopAgain = false;

            } else {
                System.out.println("I do not understand. Please enter a P, C, G, or X");
            }
        }

        System.out.println("GOODBYE");
        scan.close();
        System.exit(0);
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





}
