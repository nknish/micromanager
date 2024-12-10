public final class Micromanager {
    // things the player sets at the beginning
    protected static String townName;
    protected static String playerName = "you";
    protected static String guide = "bub";
    protected static boolean playAgain = false;

    public static void main(String[] args) {
        while (true) {
            new Intro();
            new Gameplay();
            new Result();
            if (!playAgain)
                break;
        }
        new Outro();
    }

    // non-instantiable
    private Micromanager() {
    }
}
