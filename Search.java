import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
    public Search(String searchTerm, String fileName) {
        readFile(searchTerm, fileName);
    }

    private static void readFile(String searchTerm, String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchTerm)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        if (args.length != 3 || !args[0].equals("search")) {
            System.out.println("Correct format is: \n>> search <search-term> <file-name>");
        } else {
            readFile(args[1], args[2]);
        }   
    }
}