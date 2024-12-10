import java.util.HashSet;

public final class Success {
    private static int cli = 0; // climate score
    private static int con = 0; // consumer score
    private static int civ = 0; // civic score
    private static int month = 0; // month (0 is intro, 13 is the end of the game)
    private static HashSet<String> specials = new HashSet<String>();

    /*
     * each month, the player gets up to 10 points per category
     * which can total up to 120 at the end (perfect score)
     */
    protected static void updateScores(int cli, int con, int civ) {
        if (cli < 0 || cli > 10 || con < 0 || con > 10 || civ < 0 || civ > 10) {
            throw new IndexOutOfBoundsException("score updates must be within range 0-10");
        }
        Success.cli += cli;
        Success.con += con;
        Success.civ += civ;
    }

    //
    protected static int getCli() {
        return normalize(cli);
    }

    protected static int getCon() {
        return normalize(con);
    }

    protected static int getCiv() {
        return normalize(civ);
    }

    // return a normalized version of the score based on the month
    private static int normalize(int score) {
        if (month == 13)
            return (score * 10) / 12; // for 'month 13', aka end of game
        if (month == 0)
            return 0; // for 'month 0', aka before the start
        return (score * 10) / month; // for during the game, calculate predicted total score
    }

    protected static int getMonth() {
        return month;
    }

    protected static void nextMonth() {
        month++;
    }

    protected static void addSpecial(String s) {
        specials.add(s);
    }

    protected static boolean hasSpecial(String s) {
        return specials.contains(s);
    }

    protected static void resetAll() {
        cli = 0;
        con = 0;
        civ = 0;
        month = 0;
        specials = new HashSet<String>();
    }
}
