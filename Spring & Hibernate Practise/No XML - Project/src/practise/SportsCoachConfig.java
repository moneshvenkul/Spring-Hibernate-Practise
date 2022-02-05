package practise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:lalitha.properties")
public class SportsCoachConfig {


    @Bean
    public FortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    @Bean
    public TennisCoach tennisCoach() {
        return new TennisCoach(happyFortuneService());
    }

    @Bean
    public BaseballCoach baseballCoach() {
        return new BaseballCoach(happyFortuneService());
    }

}
