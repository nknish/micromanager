import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public final class Game {
    // all of the scenarios, parsed from JSON!
    private final ArrayList<Scenario> scenarios = R.getScenariosJSON();

    // scanner to take input
    private Scanner k = new Scanner(System.in);

    // names of thingies
    private final String gn = Micromanager.guide;
    private final String pn = Micromanager.playerName;
    private final String tn = Micromanager.townName;
    private final String[] months = { "january", "february", "march", "april", "may", "june", "july", "august",
            "september", "october", "november", "december" };
    private final String[] adjectives = { "lovely", "quaint", "charming", "sweet", "peaceful", "cozy", "idyllic" };

    protected Game() {
        for (Scenario s : scenarios) {
            // pretty print the month design, increment the month variable
            nextMonth();

            // print out context, provide options, store those options for the next part
            String[] responsesWithIndices = printScenarioAndReturnPossibleResponses(s);

            // take player's response, grab the possible outcomes for that response
            List<Scenario.Outcome> outcomes = getResponseAndItsPossibleOutcomes(s, responsesWithIndices);

            // see how lucky they are! pick one outcome of (possibly) multiple
            Scenario.Outcome outcome = rollDice(outcomes);

            // print results and update them on the backend
            handleOutcome(outcome);

            // display the ending, wait to proceed to next month until they're ready
            endScenario(s.ending);
        }
    }

    private void nextMonth() {
        P.clear();
        Success.nextMonth();
        String line = "*******************************************************************************";
        String m = "  " + getMonth(0) + "  ";
        String s = "";
        while (s.length() < m.length()) {
            s = s + " ";
        }
        while (s.length() < line.length()) {
            s = s + "*";
            if (s.length() == line.length())
                break;
            s = "*" + s;
        }
        while (m.length() < line.length()) {
            m = m + "*";
            if (m.length() == line.length())
                break;
            m = "*" + m;
        }

        P.printlnInstAndPause(line);
        P.printlnInstAndPause(line);
        P.printlnInstAndPause(s);
        P.printlnInstAndPause(m);
        P.printlnInstAndPause(s);
        P.printlnInstAndPause(line);
        P.printlnInstAndPause(line);
        P.println();
        P.println("\t...in the " + adjectives[(int) (Math.random() * adjectives.length)] + " little town of " + tn);
        P.println();
    }

    private String[] printScenarioAndReturnPossibleResponses(Scenario s) {
        // prompt
        P.println(s.prompt, gn);
        P.println();
        if (s.responses.size() == 2) {
            P.println("you only have two choices:", gn);
        } else {
            P.println("you've got a handful of options:", gn);
        }

        // get all responses in order
        String[] responsesWithIndices = new String[s.responses.size() + 1];
        for (String response : s.responses.keySet()) {
            int index = Integer.parseInt(response.substring(1, 2));
            responsesWithIndices[index] = response;
        }

        // print all possible responses
        for (String responseString : responsesWithIndices) {
            if (responseString != null)
                P.println("......" + responseString);
        }

        P.println("so. what's your choice?", gn);

        return responsesWithIndices;
    }

    private List<Scenario.Outcome> getResponseAndItsPossibleOutcomes(Scenario s, String[] responses) {
        int responseNumber;
        while (true) {
            P.print("", pn);
            String userInput = k.nextLine().strip();
            String failMessage = "invalid input...try again";
            try {
                responseNumber = Integer.parseInt(userInput);
                if (responseNumber == 0)
                    throw new IndexOutOfBoundsException();
                return s.responses.get(responses[responseNumber]);
            } catch (NumberFormatException e) { // response is not an integer
                failMessage = "try again. make sure you're just entering a number!";
            } catch (IndexOutOfBoundsException e) { // response is out of bounds
                failMessage = "try again. make sure you only choose one of the numbers listed above!";
            }
            P.println(failMessage, gn);
        }
    }

    private Scenario.Outcome rollDice(List<Scenario.Outcome> os) {
        int bar = 67; // how high of a score do you need to get an odds boost?

        // check for odds boosts and implement them
        for (Scenario.Outcome o : os) {
            if (!o.oddsBooster.equals("none")) {
                if (o.oddsBooster.equals("cli")) {
                    if (Success.getCli() >= bar) {
                        if (Math.random() <= o.odds) {
                            return o;
                        }
                    }
                } else if (o.oddsBooster.equals("con")) {
                    if (Success.getCon() >= bar) {
                        if (Math.random() <= o.odds) {
                            return o;
                        }
                    }
                } else if (o.oddsBooster.equals("civ")) {
                    if (Success.getCiv() >= bar) {
                        if (Math.random() <= o.odds) {
                            return o;
                        }
                    }
                } else if (Success.hasSpecial(o.oddsBooster)) {
                    return o; // an outcome that occurs based on a special previous precondition
                }
            }
        }

        // if none of the boosts came through, calculate it like normal
        double res = Math.random();
        for (Scenario.Outcome o : os) {
            res -= o.odds;
            if (res <= 0)
                return o;
        }

        // backup (should never occur)
        P.print("something went wrong", "system");
        return os.get(0);
    }

    private void handleOutcome(Scenario.Outcome o) {
        // calculate success metrics
        Success.updateScores(o.dCli, o.dCon, o.dCiv);
        if (o.special != null) {
            Success.addSpecial(o.special);
        }

        // tell the player what happened
        P.println();
        P.println(o.result, gn);
        P.println();
        P.println("here's how you did on all key metrics:", gn);
        P.println("......climate-friendliness score: " + o.dCli + "/10");
        P.println("........consumer happiness score: " + o.dCon + "/10");
        P.println("..........civic engagement score: " + o.dCiv + "/10");
        if (Success.getMonth() == 1)
            return;
        P.println("and here are your total scores:", gn);
        P.println("......climate-friendliness score: " + Success.getCli());
        P.println("........consumer happiness score: " + Success.getCon());
        P.println("..........civic engagement score: " + Success.getCiv());
    }

    private void endScenario(String s) {
        P.println();
        if (s.equals(""))
            return;
        P.println(s, gn);
        P.println();
        P.print("[press enter to proceed from " + getMonth(0) + " to " + getMonth(1) + "] ");
        k.nextLine();
    }

    private String getMonth(int offset) {
        return months[(Success.getMonth() + 2 + offset) % 12];
    }
}
