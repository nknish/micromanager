import java.util.ArrayList;
import java.util.Scanner;

public final class Main {
    // scanner and its most recent input
    private static Scanner k = new Scanner(System.in);
    private static String userInput = "";

    // what we ask the user and how we respond
    private static String prompt = "";
    private static String response = "";

    // things the player sets at the beginning
    protected static String townName;
    protected static String playerName = "you";
    protected final static String guide = "chuck";

    // scenarios (in order)
    private static ArrayList<Scenario> scenarios;

    public static void main(String[] args) {
        new Intro();
        setup(); // preps scenarios
        mainLoop(); // runs through the whole game
        results(); // the player sees how they did!
        outro(); // gives some closing information, allows them to start over?
        U.quit(); // exits kindly and gently
    }

    private static void setup() {
        scenarios = R.getScenariosJSON();
    }

    // the main loop and switch for input! runs the whole game
    private static void mainLoop() {
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
                    response = R.getHelp();
                    break;
                case "statement":
                    response = R.getStatement();
                    break;
                default:
                    response = "your said: " + userInput;
            }
            U.print(response + "\n");
        }
    }

    // the player sees how they did!
    private static void results() {
        U.print("here's how you did:");
    }

    // a chance for more info on climate change/microgrids
    private static void outro() {
        U.print("thanks for playing!");
    }

    // slow print the prompt, get input on next line
    private static void prompt(String prompt) {
        while (true) {
            U.println(prompt, guide);
            U.print("", playerName);
            userInput = k.nextLine().toLowerCase();
            if (userInput.strip() != "") {
                break;
            }
        }
    }

    // non-instantiable
    private Main() {
    }
}
