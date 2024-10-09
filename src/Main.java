import java.util.Scanner;

public class Main {
    // scanner and its most recent input
    static Scanner k = new Scanner(System.in);
    static String userInput;

    // what we ask the user and how we respond
    static String prompt = "";
    static String response = "";

    // how long does computer delay typing, and how much time between chars (in ms)
    static int delay = 200;
    static int charDelay = 15;

    // things the player sets at the beginning
    static String townName;
    static String playerName;

    public static void main(String[] args) {
        prompt("hey! welcome to micromanager! what's your name?");
        playerName = userInput;
        prompt("cool. nice to meet you, " + playerName + "! what do you want your town to be called?");
        townName = userInput;
        sPrint("awesome. welcome to " + townName + ", " + playerName + "! you're the new grid manager.\n");
        boolean running = true;
        prompt = "say something!";
        while (running) {
            prompt(prompt);
            switch (userInput.toLowerCase()) {
                case "quit":
                    response = "you said: quit";
                    running = false;
                    break;
                case "help":
                    response = "here's some helpful info (jk no info yet)";
                    break;
                default:
                    response = "your said: " + userInput;
            }
            sPrint(response + "\n");
        }
        quit();

    }

    // slow print the prompt, get input on next line
    public static void prompt(String prompt) {
        boolean valid = false;
        while (!valid) {
            sPrint(prompt); // TODO: the user can type and interrupt this. stop that!
            System.out.println();
            userInput = k.nextLine();
            if (userInput.strip() != "") {
                valid = true;
            }
        }
    }

    // slow print. speeds controlled by static ints
    public static void sPrint(String s) {
        sleep(delay);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            System.out.print(c);
            sleep(charDelay);
        }
        sleep(delay);
    }

    // find a consistent way to sleep, and to handle Interrupted
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            System.out.println("what the heck");
        }
    }

    // whatever it does when they hit the quit command
    // should probably have some save-related feature?
    public static void quit() {
        sPrint("thanks for playing! bye now\n");
        System.exit(1);
    }
}
