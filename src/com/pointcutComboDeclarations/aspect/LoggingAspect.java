package com.pointcutComboDeclarations.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.pointcutComboDeclarations.dao.*.*(..))")
    private void forDaoPackage() {}

//    Match all getter methods
    @Pointcut("execution(* com.pointcutComboDeclarations.dao.*.get*(..))")
    private void getter() {}

//    Match all setter methods
    @Pointcut("execution(* com.pointcutComboDeclarations.dao.*.set*(..))")
    private void setter() {}

//    Match all methods but exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterOrSetter() {}


    @Before("forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("====>>> Executing @Before addAccount");
    }

    @Before("forDaoPackageNoGetterOrSetter()")
    public void performApiAnalytics() {
        System.out.println("====>>> Performing API analytics");
    }
}
