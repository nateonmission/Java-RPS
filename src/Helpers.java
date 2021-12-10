import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helpers {


    public static void writeMatchHistory(ArrayList<String> gameResults){
        createOrOpenFile();

        try {
            FileWriter histWriter = new FileWriter("gameHistory.txt", true);

            for(String line : gameResults) {
                histWriter.write(line);
            }
            histWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void writeMatchStats(String matchStats){
        createOrOpenFile();

        try {
            FileWriter statsWriter = new FileWriter("gameHistory.txt", true);

            statsWriter.write(matchStats);

            statsWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }



    private static void createOrOpenFile(){
        try {
            File histFile = new File("gameHistory.txt");
            if (histFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("Writing to existing file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
