import java.util.List;

public class Scenario {
    public String prompt;
    public int[] months;
    public List<Outcome> responses;

    public class Outcome {
        public int option;
        public String text;
        public int dCli;
        public int dCon;
        public int dCiv;
        public int dMoney;

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