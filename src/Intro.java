import java.util.Scanner;

public final class Intro {

    private Scanner k = new Scanner(System.in);
    private String gn = Micromanager.guide;
    private String pn;
    private String tn;
    private String[] acks = { "sounds good", "ok", "gotcha", "makes sense", "righty-o", "uh-huh", "yup" };
    private String[][] intro = {
            { "before i get started: i'm gonna fill you in on some things, but at the end feel free to ask me to repeat myself!",
                    "huh?", "okey-dokey",
                    "after i explain what's going on, you'll have a chance to start this whole dialogue over! it'll be like we never met." },
            { "so...it sounds like you're the new microgrid manager!",
                    "what's a microgrid?", "sounds good to me!",
                    "i'm glad you asksed! a microgrid is basically just a small power grid: it does everything an ordinary power grid does, just on a smaller scale. most microgrids are connected to a larger regional power grid, but operate mostly independently." },
            { "we've spent the last few years building this microgrid because it makes our community more resilient.",
                    "why is that?", "that makes sense",
                    "our microgrid has the capacity to power itself for some time. that means, if there's an issue with the nearby coal plant or some major transmission line, we're one of the only towns that can keep the lights on!" },
            { "the microgrid also gives us much more local control over our power.",
                    "what does that mean?", "yup, i can see why",
                    "because we control our own power supply, we aren't subject to the whims of a big company owned by people we've never met. this means we do a much better job of listening to our customers, local organizations, businesses, and the government." },
            { "and, one more benefit...the microgrid helps us fight climate change!",
                    "is that so?", "awesome, got it.",
                    "our microgrid has allowed citizens of the town to put up solar panels and contribute to the local power supply. it has also encouraged a few entrepeneurial townsfolk to start their own small renewable energy projects, like our local wind farm. finally, the closer we are to our power sources, the less energy we lose in transmission, meaning we're more efficient." },
            { "speaking of climate change...i guess i should tell you where we stand. right now, we get around 23% of our town's power from the coal plant a few towns over. that number's a good bit higher in the winter, too, when our solar panels don't have as much sunlight to work with. we're hoping to keep transitioning away from coal so we can do our part to fight climate change and keep our air clean.",
                    "what's so bad about coal?", "cool, good to know.",
                    "coal always used to seem like a solid power source. however, we now know that it puts a bunch of little guys in the air called greenhouse gases. these guys may seem innocent, but since the 1800s, they've been trapping extra heat on earth! that's one reason why we're starting to get hotter summers, longer droughts, and bigger storms." },
            { "i guess i should give you some details on this town...but you don't want me to bore you, do you?",
                    "no, tell me!", "yeah, no details needed",
                    "alright, here's the deal: \nwe've got a town with about 10,000 households. that means we've gotta provide around 50 gigawatt hours of electricity every year! (that's 50000000000 watt hours per year) \n\nour power comes from 3 main sources: wind, solar, and coal. here's the breakdown: ....a 100-acre wind farm owned by a citizen, for about 15% of our power. \n...a 120-acre solar plant owned by an out-of-towner for almost half of our power! ...a 30-acre local solar plant  that gets us another 10%\n...some rooftop solar panels on houses, for about 6% of our demand. \n...and everything else comes from that coal plant across the way." },
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
        P.clear();
        getStatementOrStart();
        getNameAndTown();
        doInfoSession();
        possibleTimeWarp();
    }

    private void getStatementOrStart() {
        while (true) {
            P.println("press [p] to play, or [s] to read statement, then press [enter]", "system");
            P.print("", "you");
            String s = k.nextLine().toLowerCase().strip();
            if (s.equals("p")) {
                break;
            } else if (s.equals("s")) {
                P.println(R.getStatement());
                P.println();
            } else if (s.equals("nk")) {
                pn = "noah";
                Micromanager.playerName = pn;
                tn = "cooltown";
                Micromanager.townName = tn;
                break;
            }
        }
    }

    private void getNameAndTown() {
        if (isAdmin())
            return;

        // get player name
        P.println();
        while (true) {
            P.println("hey! you're the new micromanager--err, microgrid manager! what's your name?", gn);
            P.print("", "you");
            pn = k.nextLine().strip().toLowerCase();
            if (!pn.equals("")) {
                Micromanager.playerName = pn;
                break;
            }
        }

        // make sure the names are different
        if (pn.equals(gn)) {
            P.println("whoa, hold on there. we have the same name! that might get confusing.", gn);
            P.println("hmm.......what to do, what to do?", gn);
            P.println("...i know! i'll just change my name!", gn);
            Micromanager.guide = "dez";
            gn = Micromanager.guide;
            P.println();
            P.println("...............................................................................");
            P.println();
            P.println("wow, this is much better! i think " + gn + " really suits me!", gn);
            P.print("[press enter to compliment " + gn + " on his new name] ");
            k.nextLine();
            P.println("why, thank you! anyways, back to business.", gn);
        } else {
            P.println("cool. nice to meet you, " + pn + "! i'll probably just call you 'boss' though.", gn);
        }
        P.println();

        // get town name
        P.println("...i'm feeling forgetful today. can you remind me the name of this town?", gn);
        while (true) {
            P.print("", pn);
            tn = k.nextLine().strip().toLowerCase();
            if (!tn.equals("")) {
                Micromanager.townName = tn;
                break;
            }
            P.println(
                    "oh...you're not sure either? well in that case, why don't you just pick a new name? go for it, let's hear your best idea!",
                    gn);
        }

        // wrap up the greeting, get to details
        P.println("awesome. welcome to " + tn + ", " + pn + "! i'm " + gn + ", your administrative assistant", gn);
        P.print("[press enter to say 'hey " + gn + "!'] ");
        k.nextLine();

    }

    private void doInfoSession() {
        if (isAdmin())
            return;

        for (String[] line : intro) {
            dialogue(line, k);
        }
    }

    private void possibleTimeWarp() {
        if (isAdmin())
            return;

        P.println();
        P.println("that's all i've got for now! are you ready to run the grid?", gn);
        P.println("......[1]: wait...can we start over?");
        P.println("......[2]: i'm ready to go!");
        if (promptForDetour(k)) {
            P.println("ok, back to the beginning!", gn);
            P.print("[press enter to time warp] ");
            k.nextLine();
            P.clear();
            new Intro();
        } else {
            P.println("welp. intro's over. game time!", gn);
        }
    }

    // [0]prompt, [1]go, [2]stay, [3]detour
    private void dialogue(String[] contents, Scanner k) {
        P.println();
        P.println(contents[0], gn); // prompt
        P.println("......[1]: " + contents[1]);
        P.println("......[2]: " + contents[2]);
        if (promptForDetour(k)) {
            P.println(contents[3], gn);
            P.print("[press enter to say '" + acks[(int) (Math.random() * acks.length)] + "!'] ");
            k.nextLine();
        }
    }

    private boolean promptForDetour(Scanner k) {
        String response;
        while (true) {
            P.print("", pn);
            response = k.nextLine().strip();
            if (response.equals("1") || response.equals("2")) {
                break;
            }
            P.println("try again", gn);
        }
        return response.equals("1");
    }

    private boolean isAdmin() {
        if (pn == null | tn == null)
            return false;
        return pn.equals("noah") && tn.equals("cooltown");
    }
}
