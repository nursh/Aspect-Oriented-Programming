package com.readJoinPoints.aspect;

import com.readJoinPoints.app.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.readJoinPoints.aspect.AopExpressions.forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("====>>> Executing @Before addAccount");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }

            System.out.println(arg);
        }
    }
    
}
