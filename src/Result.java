import java.util.Scanner;

public final class Result {
    private Scanner k = new Scanner(System.in);

    private final String gn = Micromanager.guide;
    private final String pn = Micromanager.playerName;
    private final String tn = Micromanager.townName;

    private final int cli = Success.getCli();
    private final int con = Success.getCon();
    private final int civ = Success.getCiv();

    private final boolean rehired = civ + con + cli > 190 || Math.max(Math.max(cli + con, cli + civ), con + civ) > 155;
    private final String best = cli > con && cli > civ ? "cli" : (civ > con ? "civ" : "con");

    protected Result() {
        finishLastScenario();
        printResults();
        promptForPlayAgain();
    }

    private void finishLastScenario() {
        P.print("well, this is it...i'll be back with news tomorrow.", gn);
        P.println();
        P.print("[press enter to proceed to your last day] ");
        k.nextLine();

        P.clear();
        String line = "*******************************************************************************";
        String s1 = "******************************                  *******************************";
        String s2 = "******************************   the last day   *******************************";
        System.out.println(line);
        System.out.println(line);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1);
        System.out.println(line);
        System.out.println(line);
        P.println();
        P.println("\t...in the wonderful little town of " + tn);
        P.println();
    }

    private void printResults() {
        if (rehired) {
            printRehiredResults();
        } else {
            printNotRehiredResults();
        }

        P.print("[press enter to wave goodbye to " + gn + "] ");
        k.nextLine();

        P.clear();
        P.println();
        P.println("here are your final scores:", "system");
        P.println("......climate-friendliness score: " + Success.getCli() + "/100");
        P.println("........consumer happiness score: " + Success.getCon() + "/100");
        P.println("..........civic engagement score: " + Success.getCiv() + "/100");
    }

    private void printRehiredResults() {
        P.println("boss...or maybe i should call you by your real name! it's " + pn
                + ", right? anyways, i have outstanding news...you've been hired for the long-term gig!", gn);
        P.println();

        String bestDialogue = "";
        if (best.equals("cli")) {
            bestDialogue = "meeting our town's climate goals. adapting to the threat of climate change and combatting it";
        } else if (best.equals("civ")) {
            bestDialogue = "keeping our town's organizations, businesses, and elected officials involved in our grid. civic engagement and good government practices";
        } else {
            bestDialogue = "making the people in this town feel like the microgrid works for them. reliable, affordable energy and a grid we can trust";
        }

        P.println(
                "everyone says congrats! they thought you did a great job overall, but that you especially shone when it came to "
                        + bestDialogue + " are very important here in " + tn
                        + ", and you've truly shown that you're the right person to prioritize those things.",
                gn);

        P.println();
        P.println("alright, " + pn + ", i'm heading out. see you tomorrow? ", gn);

    }

    private void printNotRehiredResults() {
        P.println(
                "unfortunately, boss, i've got some bad news. i just spoke to the mayor's office, and they've decided to go in a different direction in the future.",
                gn);
        P.println();

        String bestDialogue = "";
        String worstDialogue = "";
        if (best.equals("cli")) {
            bestDialogue = "meeting our town's climate goals";
            worstDialogue = "keeping our town's organizations, businesses, and elected officials involved in our grid and making the people in this town feel like the microgrid works for them.";
        } else if (best.equals("civ")) {
            bestDialogue = "keeping our town's organizations, businesses, and elected officials involved in our grid";
            worstDialogue = "meeting our town's climate goals and making the citizens feel like the microgrid works for them.";
        } else {
            bestDialogue = "making the people in this town feel like the microgrid works for them";
            worstDialogue = "meeting our town's climate goals and keeping our local organizations, businesses, and elected officials involved in our grid.";
        }

        P.println("they were pretty darn happy with the work you did toward " + bestDialogue
                + "; unfortunately, it wasn't enough to allay their concerns. they didn't think you did quite enough to prioritize "
                + worstDialogue, gn);

        P.println();
        P.println("there'll always be a place for you in " + tn
                + ", though. if you're looking for a fresh start, i hear time travel is a good option?", gn);
        P.println();
        P.println("alright, " + pn + ", i'm heading out. hope i'll see you around? ", gn);

    }

    private void promptForPlayAgain() {
        P.println();
        P.print("[press enter to continue] ");
        k.nextLine();

        P.clear();
        P.println(
                "you now face an important choice: would you like to travel back in time and play again, or proceed to the end and learn more about microgrids?",
                "system");

        P.println("......[1]: play again");
        P.println("......[2]: proceed to end");
        while (true) {
            P.print("", pn);
            String userInput = k.nextLine().strip();
            if (userInput.equals("1")) {
                Micromanager.playAgain = true;
                P.println("alright, let's time warp back to the beginning...", "system");
                P.print("[press enter to time travel] ");
                k.nextLine();
                return;
            } else if (userInput.equals("2")) {
                P.println("alright, let's wrap this up...", "system");
                P.print("[press enter to end game] ");
                k.nextLine();
                return;
            } else {
                P.println("please try again. enter [1] or [2]", "system");
            }
        }

    }
}