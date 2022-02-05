package practise;

public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) {
        System.out.println("Inside Constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkouts() {
        return "Run 5km";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //add a Sprig init method
    public void doMyStartupStuff() {
        System.out.println("Tennis starts");
    }

    //add a Spring destroy method
    public void doMyDestroyStuff() {
        System.out.println("Tennis destroyed");
    }
}
