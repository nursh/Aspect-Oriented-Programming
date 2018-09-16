package com.afterReturning.aspect;

import com.afterReturning.app.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @AfterReturning(
        pointcut = "execution(* com.afterReturning.dao.AccountDAO.findAccounts(..))",
        returning = "results"
    )
    public void afterReturningFromFindAccountsAdvice(JoinPoint joinPoint,
                                                     List<Account> results) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println(method);

        System.out.println("\n The result is:  \n" + results);

        // Mutating return values

        convertAccountNamesToUpperCase(results);
        System.out.println("\n After mutating values \n" + results);
    }

    private void convertAccountNamesToUpperCase(List<Account> accounts) {
        for(Account c : accounts) {
            String name = c.getName().toUpperCase();
            c.setName(name);
        }
    }

    @Before("com.afterReturning.aspect.AopExpressions.forDaoPackageNoGetterOrSetter()")
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
