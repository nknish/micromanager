public class Success {
    private static int climateScore = 0;
    private static int consumerScore = 0;
    private static int civicScore = 0;
    private static int money;

    public static int getClimateScore() {
        return climateScore;
    }

    public static void setClimateScore(int climateScore) {
        Success.climateScore = boundAndRound(climateScore);
    }

    public static int getConsumerScore() {
        return consumerScore;
    }

    public static void setConsumerScore(int consumerScore) {
        Success.consumerScore = boundAndRound(consumerScore);
    }

    public static int getCivicScore() {
        return civicScore;
    }

    public static void setCivicScore(int civicScore) {
        Success.civicScore = boundAndRound(civicScore);
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Success.money = money;
    }

    // overload with default bounds: [0, 100]
    private static int boundAndRound(double input) {
        return boundAndRound(input, 0, 100);
    }

    // customizable bounds
    private static int boundAndRound(double input, int lower, int upper) {
        if (input < lower) {
            return 0;
        }
        if (input > upper) {
            return 100;
        }
        return (int) Math.round(input);
    }

}
