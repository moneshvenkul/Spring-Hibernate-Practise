package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

    private Logger logger = Logger.getLogger(MyApiAnalyticsAspect.class.getName());

    @AfterReturning(pointcut = "execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        System.out.println("inside after return");
        String method = joinPoint.getSignature().toString();

        System.out.println(method);

        System.out.println(result+" from AfterReturning");

        convertAccountNamesToUpperCase(result);

        System.out.println(result + "After manipulating data");
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result){
            String upperName = account.getName().toUpperCase();

            account.setName(upperName);
        }
    }

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("API Analytics");
    }

    @AfterThrowing(pointcut = "execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
        System.out.println(theExc+ "Inside after Throwing");
    }

    @After("execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        System.out.println("@After inside the after aka finally");
    }

    @Around("execution(* com.example.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object afterAroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();

        Object result = null;

        try{
            result = pjp.proceed();

        }
        catch (Exception exc){
            logger.warning("Exception is "+ exc );

            throw exc;

        }

        long end = System.currentTimeMillis();

        long duration = end- begin;

        logger.info("Duration" + duration/1000.0);

        return result;
    }

}
