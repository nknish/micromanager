import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public final class Gameplay {
    // all of the scenarios, parsed from JSON!
    private static ArrayList<Scenario> scenarios;

    // scanner to take input
    private Scanner k = new Scanner(System.in);

    // names of thingies
    private final String gn = Micromanager.guide;
    private final String pn = Micromanager.playerName;

    protected Gameplay() {
        P.clear();
        scenarios = R.getScenariosJSON();
        for (Scenario s : scenarios) {
            Success.nextMonth();
            runScenario(s);
        }
    }

    private void runScenario(Scenario s) {
        String[] responsesWithIndices = printScenarioAndReturnPossibleResponses(s);
        List<Scenario.Outcome> outcomes = getResponseAndItsPossibleOutcomes(s, responsesWithIndices);
        Scenario.Outcome outcome = rollDice(outcomes);
        handleOutcome(outcome);
    }

    private String[] printScenarioAndReturnPossibleResponses(Scenario s) {
        // prompt
        P.println(s.prompt, gn);
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
            try {
                responseNumber = Integer.parseInt(userInput);
                if (responseNumber == 0)
                    throw new IndexOutOfBoundsException();
                return s.responses.get(responses[responseNumber]);
            } catch (NumberFormatException e) { // response is not an integer
            } catch (IndexOutOfBoundsException e) { // response is out of bounds
            }
            P.println("try again. enter a number from the options above!", gn);
        }
    }

    private Scenario.Outcome rollDice(List<Scenario.Outcome> os) {
        int bar = 90; // how high of a score do you need to get an odds boost?

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
        Success.setMoney(Success.getMoney() + o.dMoney);

        // tell the player what happened
        P.println(o.result, gn);
        P.println("here's how you did on all key metrics:", gn);
        P.println("......climate-friendliness score: " + o.dCli + "/10");
        P.println("......consumer happiness score: " + o.dCon + "/10");
        P.println("......civic engagement score: " + o.dCiv + "/10");
        P.println("and here are your total scores:", gn);
        P.println("......climate-friendliness score: " + Success.getCli());
        P.println("......consumer happiness score: " + Success.getCon());
        P.println("......civic engagement score: " + Success.getCiv());
    }
}
