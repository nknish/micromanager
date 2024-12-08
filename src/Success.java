public final class Success {
    private static int cli = 0; // climate score
    private static int con = 0; // consumer score
    private static int civ = 0; // civic score
    private static int money = 1000000; // money in the bank!
    private static int month = 0; // month (0 is intro, 13 is the end of the game)

    /*
     * each month, the player gets up to 10 points per category
     * which can total up to 120 at the end (perfect score)
     */
    public static void updateScores(int cli, int con, int civ) {
        if (cli < 0 || cli > 10 || con < 0 || con > 10 || civ < 0 || civ > 10) {
            throw new IndexOutOfBoundsException("score updates must be within range 0-10");
        }
        Success.cli += cli;
        Success.con += con;
        Success.civ += civ;
    }

    //
    public static int getCli() {
        return normalize(cli);
    }

    public static int getCon() {
        return normalize(con);
    }

    public static int getCiv() {
        return normalize(civ);
    }

    // return a normalized version of the score based on the month
    private static int normalize(int score) {
        if (month == 13)
            return score; // for 'month 13', aka end of game
        if (month == 0)
            return 0; // for 'month 0', aka before the start
        return score * 12 / month; // for during the game, calculate predicted total score
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Success.money = money;
    }

    public static int getMonth() {
        return money;
    }

    public static void nextMonth() {
        month++;
        if (month == 13) {
            // TODO: how do we wrap up?
        }
    }
}
