public final class Setup {

    protected Setup() {
        getScenarios();
        orderAndSelectScenarios();
    }

    private void getScenarios() {
        Micromanager.scenarios = R.getScenariosJSON();
    }

    private void orderAndSelectScenarios() {
        // out of many possible, pick 12
        // random order, except first and last
    }
}
