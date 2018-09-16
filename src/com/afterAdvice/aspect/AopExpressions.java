package com.afterAdvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.afterAdvice.dao.*.*(..))")
    public void forDaoPackage() {}

    //    Match all getter methods
    @Pointcut("execution(* com.afterAdvice.dao.*.get*(..))")
    public void getter() {}

    //    Match all setter methods
    @Pointcut("execution(* com.afterAdvice.dao.*.set*(..))")
    public void setter() {}

    //    Match all methods but exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterOrSetter() {}
}
