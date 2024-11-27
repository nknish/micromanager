import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;

// R is for Reader!
public final class R {

    public static List<Scenario> getScenariosJSON() {
        Gson gson = new Gson();
        List<Scenario> scens = new ArrayList<Scenario>();
        int noOfScenarios = 1;
        for (int i = 0; i < noOfScenarios; i++) {
            File f = new File("txt/scenario" + i + ".json");
            String catchMessage = "uh oh, i can't read json and everything's broken";
            String json = getWholeFile(f, catchMessage);
            if (json.equals(catchMessage)) {
                throw new RuntimeException(catchMessage);
            } else {
                scens.add(gson.fromJson(json, Scenario.class));
            }
        }
        return scens;
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
