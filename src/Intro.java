import java.util.Scanner;

public final class Intro {

    private Scanner k = new Scanner(System.in);
    private String gn = Micromanager.guide;
    private String pn;
    private String tn;
    private String[] acks = { "sounds good", "ok", "gotcha", "makes sense" };
    private String[][] intro = {
            { "before i get started: i'm gonna fill you in on some things, but at the end feel free to ask me to repeat myself!",
                    "huh?", "okey-dokey",
                    "after i explain what's going on, you'll have a chance to start this whole dialogue over! it'll be like we never met." },
            { "so...it sounds like you're the new microgrid manager!",
                    "what's a microgrid?", "sounds good to me!",
                    "a microgrid is a small power grid!" },
            { "we've spent the last few years building this microgrid because it makes our community more resilient.",
                    "why is that?", "that makes sense",
                    "it helps us prevent power outages when nearby towns get hit with storms." },
            { "the microgrid also gives us much more local control over our power.",
                    "what does that mean?", "yup, i can see why",
                    "because we control our own power supply, we aren't subject to the whims of a big power company owned by people we've never met." },
            { "and, one more benefit...the microgrid helps us fight climate change!",
                    "is that so?", "awesome, got it.",
                    "our microgrid has allowed citizens of the town to put up solar panels and contribute to the local power supply. that means less of our power comes from fossil fuel sources like the nearby coal plant." },
    };

    /*
     * - Why do we have a microgrid? here’s why: (local control, resilience to
     * climate change, clean energy)
     * - detour: why do we have to be resilient to climate change?
     * - detour: what’s so good about ‘clean’ energy? (climate change AND air
     * pollution)
     * - detour: what’s so good about local control?
     * - Does our microgrid power everything? Not quite.
     * - detour: why do we need to get away from that coal plant?
     * - So, what’s my job? Making decisions for the upcoming year about the plant
     * - detour: what kind of decisions will i be making?
     * - And what are my goals? That’s up to you to weigh all the interests! (decide
     * soon)
     * - detour: what makes the townspeople happy?
     * - detour: what makes the interest groups happy?
     * - detour: what makes the city council happy?
     * - detour: what makes businesses happy?
     * - To summarize: you have to make everyone happy without running out of money!
     * - detour: can I really make EVERYONE happy? (no)
     * - How do i actually play? (break the fourth wall and explain
     * scenarios/scores)
     * - maybe multiple dialogue boxes, but no real interaction
     * - Alright, ready to go?
     * - not yet, need to review! (back to the beginning)
     * - yeah, ready to go!
     */

    protected Intro() {
        getStatementOrStart();
        getNameAndTown();
        doInfoSession();
        possibleTimeWarp();
    }

    private void getStatementOrStart() {
        U.clear();
        while (true) {
            U.println("press [p] to play, or [s] to read statement, then press [enter]", "system");
            U.print("", "you");
            String s = k.nextLine().toLowerCase().strip();
            if (s.equals("p")) {
                break;
            } else if (s.equals("s")) {
                U.println(R.getStatement());
                U.println();
            }
        }
    }

    private void getNameAndTown() {
        // get player name
        U.println();
        while (true) {
            U.println("hey! welcome to micromanager! what's your name?", gn);
            U.print("", "you");
            pn = k.nextLine().strip().toLowerCase();
            if (!pn.equals("")) {
                Micromanager.playerName = pn;
                break;
            }
        }

        // make sure the names are different
        String namePrompt = "cool. nice to meet you, " + pn + "! what do you want your town to be called?";
        if (pn.equals(gn)) {
            U.println("whoa, hold on there. we have the same name! that might get confusing.", gn);
            U.println("hmm.......what to do, what to do?", gn);
            U.println("...i know! i'll just change my name!", gn);
            Micromanager.guide = "jeremiah";
            gn = Micromanager.guide;
            U.println();
            U.println("...............................................................................");
            U.println();
            U.println("wow, this is much better! i think " + gn + " really suits me!", gn);
            U.print("[press enter to compliment " + gn + " on his new name] ");
            k.nextLine();
            U.println("why, thank you! anyways, back to business.", gn);
            U.println();
            namePrompt = "so, " + pn + ", what do you want your town to be called?";
        }

        // get town name
        while (true) {
            U.println(namePrompt, gn);
            U.print("", pn);
            tn = k.nextLine().strip().toLowerCase();
            if (!tn.equals("")) {
                Micromanager.townName = tn;
                break;
            }
        }

        // wrap up the greeting, get to details
        U.println("awesome. Welcome to " + tn + ", " + pn + "! i'm " + gn + ", your administrative assistant", gn);
        U.print("[press enter to say 'hey " + gn + "!'] ");
        k.nextLine();

    }

    private void doInfoSession() {
        for (String[] line : intro) {
            dialogue(line, k);
        }
    }

    private void possibleTimeWarp() {
        U.println("that's all i've got for now!", gn);
        U.println("   [1]: wait...can we start over?");
        U.println("   [2]: i'm ready to go!");
        if (promptForDetour(k)) {
            U.println("ok, back to the beginning!", gn);
            U.print("[press enter to time warp] ");
            k.nextLine();
            U.clear();
            new Intro();
        } else {
            U.println("welp. intro's over. game time!", gn);
        }
    }

    // [0]prompt, [1]go, [2]stay, [3]detour
    private void dialogue(String[] contents, Scanner k) {
        U.println();
        U.println(contents[0], gn); // prompt
        U.println("   [1]: " + contents[1]);
        U.println("   [2]: " + contents[2]);
        if (promptForDetour(k)) {
            U.println(contents[3], gn);
            U.print("[press enter to say '" + acks[(int) (Math.random() * acks.length)] + "!'] ");
            k.nextLine();
        }
    }

    private boolean promptForDetour(Scanner k) {
        String response;
        while (true) {
            U.print("", pn);
            response = k.nextLine().strip();
            if (response.equals("1") || response.equals("2")) {
                break;
            }
            U.println("try again", gn);
        }
        return response.equals("1");
    }
}
