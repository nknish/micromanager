import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class Main {
    // scanner and its most recent input
    private static Scanner k = new Scanner(System.in);
    private static String userInput;

    // what we ask the user and how we respond
    private static String prompt = "";
    private static String response = "";

    // how long does computer delay typing, and how much time between chars (in ms)
    private static int delay = 200;
    private static int charDelay = 15;

    // things the player sets at the beginning
    private static String townName;
    private static String playerName;

    public static void main(String[] args) {
        intro(); // introduces player to the game, does some setup
        mainLoop(); // runs indefinitely, usually (this will get more complicated)
        quit(); // exits kindly and gently

    }

    // find a consistent way to sleep, and to handle Interrupted
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            System.out.println("what the heck");
        }
    }

    // everything that happens at the beginning of a new game
    private static void intro() {
        prompt("hey! welcome to micromanager! what's your name?");
        playerName = userInput;
        prompt("cool. nice to meet you, " + playerName + "! what do you want your town to be called?");
        townName = userInput;
        sPrint("awesome. welcome to " + townName + ", " + playerName + "! you're the new grid manager.\n");
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
                    response = "here's some helpful info (jk no info yet)";
                    break;
                case "statement":
                    response = getStatement();
                    break;
                default:
                    response = "your said: " + userInput;
            }
            sPrint(response + "\n");
        }
    }

    // slow print the prompt, get input on next line
    private static void prompt(String prompt) {
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
    private static void sPrint(String s) {
        sleep(delay);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            System.out.print(c);
            sleep(charDelay);
        }
        sleep(delay);
    }

    // get the statement from .txt file into a string
    private static String getStatement() {
        File statement = new File("txt/statement.txt");
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(statement);
            StringBuilder sb = new StringBuilder();
            while (fileScanner.hasNext()) {
                sb.append(fileScanner.nextLine()).append("\n");
            }
            fileScanner.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "go to https://github.com/nknish/micromanager to find the statement";
        }
    }

    // a nice chill, friendly exit
    private static void quit() {
        sPrint("thanks for playing! bye now\n");
        System.exit(1);
    }

    // non-instantiable
    private Main() {
    }
}
