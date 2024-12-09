public final class Micromanager {
    // things the player sets at the beginning
    protected static String townName;
    protected static String playerName = "you";
    protected static String guide = "bub";

    public static void main(String[] args) {
        new Intro();
        new Gameplay();
        // outro
        // results
        // quit
    }

    // non-instantiable
    private Micromanager() {
    }
}
