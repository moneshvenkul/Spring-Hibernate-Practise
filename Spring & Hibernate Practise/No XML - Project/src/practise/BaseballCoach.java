package practise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    //    @Autowired
    public BaseballCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
        System.out.println("inside baseball constructor");
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
