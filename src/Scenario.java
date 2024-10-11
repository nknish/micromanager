public class Scenario {
    private StringBuilder prompt; // build a string for the prompt using JSON text and success metrics
    private boolean[] months; // in what months could the scenario occur?
    private String[] responses; // each possible response is a string, user chooses based on index
    private Outcome[] outcomes; // each response corresponds with an outcome at the same index

    private class Outcome {
        private StringBuilder text;
        private int dCli;
        private int dCon;
        private int dCiv;
        private int dMoney;

    }
}

/*
 * question—how complex should i make scenario class? should scenarios be
 * inter-dependent?
 * 
 * for example, if one scenario is about repairing the grid, and a later one
 * deals with a storm, the grid repair should impact the likelihood and severity
 * of blackouts.
 * 
 * however, it's hard to implement, because scenarios need to have outcomes
 * based on both the choice (1, 2, 3, etc.) and previous factors (like
 * infrastructure), and those previous factors can't just be cli, con, civ
 */