package practise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {


    //    @Autowired
//    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        System.out.println("Inside Constructor");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkouts() {
        return "Run 5km";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void anyMethodName(FortuneService fortuneService) {
        System.out.println("Inside Tennis Setter");
        this.fortuneService = fortuneService;
    }


    //add a Sprig init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Tennis starts");
    }

    //add a Spring destroy method
    @PreDestroy
    public void doMyDestroyStuff() {
        System.out.println("Tennis destroyed");
    }
}
