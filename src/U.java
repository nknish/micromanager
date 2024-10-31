// U is for Useful!
public final class U {
    // how long does computer delay typing, and how much time between chars (in ms)
    private static int delay = 200;
    private static int charDelay = 15;

    // find a consistent way to sleep, and to handle Interrupted
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            System.out.println("what the heck");
        }
    }

    protected static void print(String s) {
        sleep(delay);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            System.out.print(c);
            sleep(charDelay);
        }
        sleep(delay);
    }

    // a nice chill, friendly exit
    protected static void quit() {
        print("thanks for playing! bye now\n");
        System.exit(1);
    }

    // non-instantiable
    private U() {
    }
}
