import java.util.List;;

public final class Setup {

    protected Setup() {
        getScenarios();
        orderAndSelectScenarios();
        printScenarios();  // comment out later
    }

    private void getScenarios() {
        Micromanager.scenarios = R.getScenariosJSON();
    }

    private void orderAndSelectScenarios() {
        
        // out of many possible, pick 12
        // random order, except first and last
    }

    private void printScenarios() {
        for (Scenario s : Micromanager.scenarios) {
            P.println("scenario prompt: " + s.prompt);
            for (String r : s.responses.keySet()) {
                P.println("response: " + r);
                List<Scenario.Outcome> os = s.responses.get(r);
                P.println("possible outcomes:");
                for (Scenario.Outcome o : os) {
                    P.println("\t** " + o.result + " **");
                    P.println("\todds: " + o.odds + ", plus a bonus for good " + o.oddsBooster);
                    P.println("\tdCiv: " + o.dCiv);
                    P.println("\tdCli: " + o.dCli);
                    P.println("\tdCon: " + o.dCon);
                    P.println("\tdMoney: " + o.dMoney);
                    P.println();
                }
            }
            P.println();
        }
    }
}
