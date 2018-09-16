package com.aroundAdviceExceptionHandling.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.aroundAdviceExceptionHandling.dao.*.*(..))")
    public void forDaoPackage() {}

    //    Match all getter methods
    @Pointcut("execution(* com.aroundAdviceExceptionHandling.dao.*.get*(..))")
    public void getter() {}

    //    Match all setter methods
    @Pointcut("execution(* com.aroundAdviceExceptionHandling.dao.*.set*(..))")
    public void setter() {}

    //    Match all methods but exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterOrSetter() {}
}
