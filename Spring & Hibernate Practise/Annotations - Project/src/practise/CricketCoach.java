package practise;

import org.springframework.stereotype.Component;


public class CricketCoach implements Coach {

    FortuneService fortuneService;
    private String emailAddress;
    private String phoneNumber;

    public void setDailyFortune(FortuneService myFortune) {
        System.out.println("Inside setter");
        this.fortuneService = myFortune;
    }

    @Override
    public String getDailyWorkouts() {
        return "Hit 10 Balls";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Inside setter Email");
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public long getPhoneNumber() {
        return Long.parseLong(phoneNumber);
    }
}
