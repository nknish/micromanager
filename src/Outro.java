import java.util.Scanner;

public final class Outro {
    private Scanner k = new Scanner(System.in);

    protected Outro() {
        P.clear();

        P.println("thanks for playing micromanager!!! hopefully you enjoyed it and learned a lot.", "system");
        P.print("[press enter to say 'i had a great time!'] ");
        k.nextLine();

        P.println();
        P.println("the game is over, but read on to take a deeper dive into microgrids...", "system");
        P.print("[press enter to continue] ");
        k.nextLine();
        P.clear();

        P.println(R.getStatement());

    }
}