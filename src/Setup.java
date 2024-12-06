public final class Setup {

    protected Setup() {
        getScenarios();
        orderAndSelectScenarios();
    }

    private void getScenarios() {
        Micromanager.scenarios = R.getScenariosJSON();
    }

    private void orderAndSelectScenarios() {
        for (Scenario s : Micromanager.scenarios) {
            P.println("scenario prompt: " + s.prompt);
            P.print("possible months: [");
            for (int i : s.months) {
                P.print(i + ", ");
            }
            P.println("]");
            for (Scenario.Outcome o : s.responses) {
                P.println("option " + o.option + ": " + o.description);
                P.println("result: " + o.result);
                P.println("dCiv: " + o.dCiv);
                P.println("dCli: " + o.dCli);
                P.println("dCon: " + o.dCon);
                P.println("dMoney: " + o.dMoney);
            }
            P.println();
        }
        // out of many possible, pick 12
        // random order, except first and last
    }
}
