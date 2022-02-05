package practise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");*/

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

      /* Coach prototypeCoach = context1.getBean("myCoach", Coach.class);
       Coach prototypeAlphaCoach = context1.getBean("myCoach", Coach.class);*/

        /*System.out.println("Singleton Scope " + (coach == alphaCoach));
        System.out.println(coach+" "+alphaCoach);
        System.out.println("Prototype Scope " + (prototypeCoach == prototypeAlphaCoach));
        System.out.println(prototypeCoach+" "+prototypeAlphaCoach);

//      CricketCoach coach1 = context.getBean("cricketCoach",CricketCoach.class);
        System.out.println(coach.getDailyWorkouts());
        System.out.println(coach.getDailyFortune());
//        System.out.println(coach1.getDailyFortune());
//        System.out.println(coach1.getEmailAddress());
//        System.out.println(coach1.getPhoneNumber());
*/
        context.close();
//            context1.close();
    }
}
