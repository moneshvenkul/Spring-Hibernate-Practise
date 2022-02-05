package practise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    @Value("${fortunes}")
    public String[] fortunes;

    @Value("${newFortunes}")
    public String[] newFortunes;

    @Override
    public String getFortune() {
        System.out.println(Arrays.toString(fortunes));
        String random = (fortunes[new Random().nextInt(fortunes.length)]);
        return random;
    }

    //add a Sprig init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(Arrays.toString(newFortunes));
        System.out.println("RandomFortune Service starts");
    }


}
