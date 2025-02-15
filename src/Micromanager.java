public final class Micromanager {
    protected static String townName;
    protected static String playerName;
    protected static String guide;
    protected static boolean playAgain;

    public static void main(String[] args) {
        playAgain = true;
        while (playAgain) {
            initializeData();
            new Intro();
            new Game();
            new Result();
        }
        new Outro();
    }

    private static void initializeData() {
        townName = null;
        playerName = "you";
        guide = "bub";
        playAgain = false;
        Success.resetAll();
    }

    // non-instantiable
    private Micromanager() {
    }
}
