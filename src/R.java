import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;

// R is for Read!
public final class R {
    public static ArrayList<Scenario> getScenariosJSON() {
        Gson gson = new Gson();
        ArrayList<Scenario> scens = new ArrayList<Scenario>();
        boolean nothingLeft = false;
        for (int i = 0; !nothingLeft; i++) {
            File f = new File("../json/scenario" + i + ".json");
            String catchMessage = "uh oh, i can't read json and everything's broken";
            String json = getWholeFile(f, catchMessage);
            if (json.equals(catchMessage)) {
                f = new File("json/scenario" + i + ".json");
                json = getWholeFile(f, catchMessage);
            }
            if (json.equals(catchMessage)) {
                if (scens.size() == 0) {
                    throw new RuntimeException(catchMessage);
                } else {
                    nothingLeft = true;
                }
            } else {
                scens.add(gson.fromJson(json, Scenario.class));
            }
        }
        return scens;
    }

    public static String getStatement() {
        File f = new File("txt/statement.txt");
        String catchMessage = "statement file not found :(\ncheck out https://github.com/nknish/micromanager to find the statement";
        String s = getWholeFile(f, catchMessage);
        if (s.equals(catchMessage)) {
            f = new File("../txt/statement.txt");
            s = getWholeFile(f, catchMessage);
        }
        return s;
    }

    public static String getHelp() {
        File f = new File("txt/help.txt");
        String catchMessage = "we need help getting help, sorry :(";
        String s = getWholeFile(f, catchMessage);
        if (s.equals(catchMessage)) {
            f = new File("../txt/help.txt");
            s = getWholeFile(f, catchMessage);
        }
        return s;
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
            return sb.toString().strip();
        } catch (FileNotFoundException e) {
            return catchMessage;
        }
    }

    // non-instantiable
    private R() {
    }
}
