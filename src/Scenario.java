import java.util.List;
import java.util.HashMap;

/**
 * This object is used to represent one scenario in the game. Each scenario
 * consists of a prompt and various responses, contained in a map from Strings
 * (response description) to Lists of Outcomes. The player will be prompted with
 * all of the keys and, upon selecting one, an outcome will be chosen from the
 * value's list based on the odds.
 */
public class Scenario {
    public String prompt;
    public HashMap<String, List<Outcome>> responses;
    public String ending;

    /**
     * An outcome, selected from a list, depending on the choice of the player for
     * the scenario. One scenario may have as few as two outcomes (if there are only
     * two possible responses, both with certain outcomes) or far more. An odds
     * booster is one of the three success metrics where, if it is high (so far),
     * its corresponding outcome will be made more likely.
     */
    public class Outcome {
        public String result;
        public double odds;
        public String oddsBooster;
        public int dCli;
        public int dCon;
        public int dCiv;
        public int dMoney;
    }
}
