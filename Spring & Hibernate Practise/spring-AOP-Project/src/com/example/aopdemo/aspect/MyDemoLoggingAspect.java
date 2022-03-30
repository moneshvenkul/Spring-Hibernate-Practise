package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public  void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("Executing before add Account");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object tempArg:args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                System.out.println(account.getName());
                System.out.println(account.getLevel());

            }
        }


    }


}
