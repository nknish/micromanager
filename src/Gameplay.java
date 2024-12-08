import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public final class Gameplay {
    protected Gameplay() {
        for (Scenario s : Micromanager.scenarios) {
            runScenario(s);
        }
    }

    private void runScenario(Scenario s) {
        String[] responsesWithIndices = printScenarioAndReturnPossibleResponses(s);
        List<Scenario.Outcome> outcomes = getResponseAndItsPossibleOutcomes(responsesWithIndices);
        String outcomeKey = rollDice(outcomes);
        calculateOutcome(outcomeKey);
        printOutcome(outcomeKey);
    }

    private String[] printScenarioAndReturnPossibleResponses(Scenario s) {
        // prompt
        P.println(s.prompt, Micromanager.guide);
        if (s.responses.size() == 2) {
            P.println("you only have two choices:", Micromanager.guide);
        } else {
            P.println("you've got a handful of options:", Micromanager.guide);
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
                P.println("\t" + responseString);
        }

        P.println("so. what's your choice?", Micromanager.guide);
        P.println();

        return responsesWithIndices;
    }

    private List<Scenario.Outcome> getResponseAndItsPossibleOutcomes(String[] responses) {
        return null;
    }

    private String rollDice(List<Scenario.Outcome> os) {
        return null;
    }

    private void calculateOutcome(String outcomeKey) {

    }

    private void printOutcome(String outcomeKey) {

    }
}
