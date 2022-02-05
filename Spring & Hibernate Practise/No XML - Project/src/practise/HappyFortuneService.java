package practise;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {


    @Override
    public String getFortune() {
//        String[] fortunes = {"Today is your lucky day 1", "You're Awesome 2", "You will win Lottery 3"};
//        String random = (fortunes[new Random().nextInt(fortunes.length)]);
        return "You will be Happy Today";
    }


}
