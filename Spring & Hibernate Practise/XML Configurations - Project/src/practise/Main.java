package practise;

public class Main {
    public static void main(String[] args) {

        FortuneService fortuneService = new HappyFortuneService();

        Coach coach = new TennisCoach(fortuneService);
        //This is hardcoded, so we use spring get this
        // information from config file, so we don't need to change the source file
        Coach coach1 = new BaseballCoach(fortuneService);
        CricketCoach coach2 = new CricketCoach();

        System.out.println(coach.getDailyWorkouts());
        System.out.println(coach1.getDailyWorkouts());
        System.out.println(coach1.getDailyFortune());
        coach2.setDailyFortune(fortuneService);
        System.out.println(coach2.getDailyFortune());

    }
}
