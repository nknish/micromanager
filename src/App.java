import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);
        String latestResponse;
        latestResponse = promptAndGet("hello! this is a test. i hope this works as it would be pretty darn cool.", k);
        while (true) {
            latestResponse = promptAndGet("your latest response: " + latestResponse, k);
        }
    }

    // slow print the prompt, get input on next line
    public static String promptAndGet(String prompt, Scanner k) {
        sPrint(prompt); // flaw: the user can type and interrupt this
        System.out.println();
        return k.nextLine();
    }

    // slow print. maybe add a param for speed?
    public static void sPrint(String s) {
        sleep(400);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            System.out.print(c);
            sleep(40);
        }
        sleep(400);
    }

    // find a consistent way to sleep, and to handle Interrupted
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            System.out.println("what the heck");
        }
    }
}
