package com.aspectBeforeAdvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//      Match only AccountDAO's addAccount method
//    @Before("execution(public void com.aspectBeforeAdvice.dao.AccountDAO.addAccount())")

//    Match all classes with an addAccount method
//    @Before("execution(public void addAccount())")

//    Match any method that starts with add
//    @Before("execution(public void add*())")

//    Match any method with any return type that starts with add
//    @Before("execution(* add*())")


//    (..) -> match any number of arguments
//    () -> match no argument
//    (com.aspectBeforeAdvice.app.Account, ..) -> match arguments with first one being account and any
//    ... other number of following arguments
//    Match any method with one argument of Account class
//    @Before("execution(* add*(com.aspectBeforeAdvice.app.Account))")

//    match all the methods in a package
//    @Before("execution(* packageName.*.*(..))")
//    first * -> any return type
//    second * -> all classes
//    third * -> all methods

    @Before("execution(* add*(com.aspectBeforeAdvice.app.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("======>>> Executing @Before addAccount");
    }
}
