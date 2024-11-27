import java.util.ArrayList;
import java.util.Scanner;

public final class Main {
    // scanner and its most recent input
    private static Scanner k = new Scanner(System.in);
    private static String userInput;

    // what we ask the user and how we respond
    private static String prompt = "";
    private static String response = "";

    // things the player sets at the beginning
    private static String townName;
    private static String playerName;

    // scenarios (in order)
    private static ArrayList<Scenario> scenarios;

    public static void main(String[] args) {
        intro(); // introduces player to the game, does some setup
        setup(); // preps scenarios
        mainLoop(); // runs through the whole game
        results(); // the player sees how they did!
        outro(); // gives some closing information, allows them to start over?
        U.quit(); // exits kindly and gently
    }

    // everything that happens at the beginning of a new game
    private static void intro() {
        prompt("hey! welcome to micromanager! what's your name?");
        playerName = userInput;
        prompt("cool. nice to meet you, " + playerName + "! what do you want your town to be called?");
        townName = userInput;
        U.print("awesome. welcome to " + townName + ", " + playerName + "! you're the new grid manager.\n");
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
        boolean valid = false;
        while (!valid) {
            U.print(prompt); // TODO: the user can type and interrupt this. stop that!
            System.out.println();
            userInput = k.nextLine();
            if (userInput.strip() != "") {
                valid = true;
            }
        }
    }

    // non-instantiable
    private Main() {
    }
}
