// P is for Print!
public final class P {
    // how long does computer delay typing, and how much time between chars (in ms)
    private static int delay = 20;
    private static int charDelay = 2;

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
                sleep(charDelay * ((c == '.' || c == '?' || c == '!') ? 5 : 1)); // pause for sentences
            }
            if (w.length() >= 1 && (!w.equals(words[words.length - 1]) || s.charAt(s.length() - 1) == ' ')) {
                System.out.print(" ");  // add back spaces lost to .split(" ")
                x++;
            }
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
        println();
    }

    protected static void println(String s, String voice) {
        print(s, voice);
        println();
    }

    protected static void clear() {
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
