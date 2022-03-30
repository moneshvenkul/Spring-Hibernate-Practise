package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger logger = Logger.getLogger(MainDemoApp.class.getName());


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//        AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

//       List<Account>  accountList =null;
//
       boolean tripWire = true;
//
//       try{
//           accountList = accountDao.findAccounts(tripWire);
//       } catch (Exception e) {
//           e.printStackTrace();
//           System.out.println("Caught Exception");
//       }
//
//
//        System.out.println(accountList);

        logger.info("Calling getFortunes");
        logger.info("Today my Fortune is" + trafficFortuneService.getFortune(tripWire));
        logger.info("Finished");

        context.close();

    }

}
