import java.util.Scanner;

public class App {
    // scanner and its most recent input
    static Scanner k = new Scanner(System.in);
    static String userInput;

    // things the player sets at the beginning
    static String townName;
    static String playerName;

    public static void main(String[] args) {
        prompt("hey! welcome to micromanager! what's your name?");
        playerName = userInput;
        prompt("cool. nice to meet you, " + playerName + "! what do you want your town to be called?");
        townName = userInput;
        prompt("awesome. welcome to " + townName + ", " + playerName + "! you're the new grid manager.");
        while (true) {
            prompt("your latest response: " + userInput);
            if (userInput.equalsIgnoreCase("quit")) {
                sPrint("im gettin out of here!");
                break;
            }
        }
    }

    // slow print the prompt, get input on next line
    public static void prompt(String prompt) {
        sPrint(prompt); // flaw: the user can type and interrupt this
        System.out.println();
        userInput = k.nextLine();
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
