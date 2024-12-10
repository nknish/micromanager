import java.util.Scanner;

public final class Intro {

    private Scanner k = new Scanner(System.in);
    private String gn = Micromanager.guide;
    private String pn;
    private String tn;
    private String[] acks = { "sounds good", "ok", "gotcha", "makes sense", "uh-huh", "yup", "righty-o" };
    private String[][] intro = {
            { "before i get started: i'm gonna fill you in on some things, but at the end feel free to ask me to repeat myself!",
                    "huh?", "okey-dokey",
                    "after i explain what's going on, you'll have a chance to start this whole dialogue over! it'll be like we never met." },
            { "so...it sounds like you're the new microgrid manager!",
                    "what's a microgrid?", "sounds good to me!",
                    "i'm glad you asksed! a microgrid is basically just a small power grid: it does everything an ordinary power grid does, just on a smaller scale. most microgrids are connected to a larger regional power grid, but operate mostly independently." },
            { "we've spent the last few years building this microgrid because it makes our community more resilient. isn't that great, boss?",
                    "how does that work?", "yeah, sounds awesome!",
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
            { "i guess i should give you some details on this town, boss...but you don't want me to bore you, do you?",
                    "no, tell me!", "yeah, no details needed",
                    "alright, here's the deal: \n\nwe've got a town with about 10,000 households. that means we've gotta provide around 50 gigawatt hours of electricity every year! (that's 50000000000 watt hours per year!) \n\nour power comes from 3 main sources: wind, solar, and coal. here's the breakdown: ...a 100-acre wind farm owned by a citizen, for about 15% of our power. \n...a 120-acre solar plant owned by an out-of-towner for almost half of our power! ...a 30-acre local solar plant  that gets us another 10%\n...some rooftop solar panels on houses, for about 6% of our demand. \n...and everything else comes from that coal plant across the way." },
            { "so, let's talk about your goals: you've got three main goals for your first year on the job. they are: climate-friendliness, consumer happiness, and civic engagement.",
                    "my first year??? i thought i had a 5 year contract!", "sounds good.",
                    "yeah, around here we like to start people off with a 1-year gig. at the end of the year, if you've done a good job, they'll hire you for the long run. it means you've got one year to prove yourself..." },
            { "our climate goals are pretty simple: we've committed to going fully renewable in 13 years. your job is to keep us moving in the right direction, and fast!",
                    "how do i do that?", "got it.",
                    "you've got a few key ways to do this. the main way is to promote more renewable energy sources like solar and wind - and to help out those who are already producing it. the other major area is energy efficiency, because for us, using less power means burning less coal!" },
            { "consumer happiness is a bit tougher. you've got to keep a town of 10,000 households happy, which is no easy task.",
                    "what do the townsfolk want?", "understood.",
                    "they mostly want one thing: cheap energy. if the price goes down, we're heroes, and if it goes up, they might riot! they also despise power outages and disruptions, so anything we can do to be reliable will make them happy." },
            { "the most complex goal is civic engagement. you'll frequently have to coordinate with our town council, the mayor, local environmental advocates, and the small business community. whew, that's a lot of groups!",
                    "how do i keep them all happy!?!?", "sounds tough, but i got it.",
                    "that's the tough part, you can't! you just have to do your best to juggle various interests. sometimes, you'll have to pick one group over the other. you should always be on the lookout for ways to build relationships, though, so you can earn everyone's trust." },
            { "alright, boss, i think you're almost ready to go. just one last thing: there's a lot of details that i don't want to bother you with, so i'll just handle most tasks around here. your job is to make the hardest, most important decisions, which usually come up once a month.",
                    "what do you mean?", "cool, i can do that!",
                    "here's the deal: you'll be faced with 1 scenario per month. each scenario will test your microgrid mettle, and you'll have to make tough decisions. there are (usually) no right answers, which means there are really multiple right answers. at the end of a scenario, you'll see what happened and get your scores back. all of your scores are averaged to calculate your final score at the end. oh, and if you make good decisions early on, you might save yourself some trouble later!" },

    };

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
            P.print("[press enter to say '" + acks[(int) (Math.random() * acks.length - 0.1)] + "!'] ");
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
