import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// R is for Reader!
public final class R {

    public static String getScenariosJSON() {
        return "";
    }

    public static String getStatement() {
        File f = new File("txt/statement.txt");
        String catchMessage = "statement file not found :(\ncheck out https://github.com/nknish/micromanager to find the statement";
        return getWholeFile(f, catchMessage);
    }

    //
    private static String getWholeFile(File f, String catchMessage) {
        try {
            Scanner s = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while (s.hasNext()) {
                sb.append(s.nextLine()).append("\n");
            }
            s.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            return catchMessage;
        }
    }

    // non-instantiable
    private R() {
    }
}
