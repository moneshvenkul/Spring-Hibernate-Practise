package practise;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkouts() {
        return "Do 100 Push-pups";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
