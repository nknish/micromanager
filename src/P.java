// P is for Print!
public final class P {
    // how long does computer delay typing, and how much time between chars (in ms)
    private static int delay = 200;
    private static int charDelay = 15;

    // find a consistent way to sleep, and to handle Interrupted
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            println("what the heck");
        }
    }

    protected static void print(String s) {
        sleep(delay);
        String[] words = s.split(" ");
        int x = 0;
        for (String w : words) {
            char[] arr = w.toCharArray();
            if (x + arr.length > 95) {
                println();
                x = 0;
            }
            for (char c : arr) {
                System.out.print(c);
                if (c == '\n') {
                    x = 0;
                } else {
                    x++;
                }
                sleep(charDelay);
            }
            System.out.print(" ");
            x++;
        }
        sleep(delay);
    }

    protected static void print(String s, String voice) {
        print("[" + voice + "] - ");
        print(s);
    }

    protected static void println() {
        System.out.println();
    }

    protected static void println(String s) {
        print(s);
        System.out.println();
    }

    protected static void println(String s, String voice) {
        print(s, voice);
        System.out.println();
    }

    protected static void clear() {
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    // a nice chill, friendly exit
    protected static void quit() {
        println("thanks for playing! bye now");
        System.exit(1);
    }

    // non-instantiable
    private P() {
    }
}
