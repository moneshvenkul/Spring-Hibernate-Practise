package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution(* com.example.aopdemo.dao.AccountDao.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter (){}
}
