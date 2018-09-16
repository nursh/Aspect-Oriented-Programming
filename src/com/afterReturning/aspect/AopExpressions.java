package com.afterReturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.afterReturning.dao.*.*(..))")
    public void forDaoPackage() {}

    //    Match all getter methods
    @Pointcut("execution(* com.afterReturning.dao.*.get*(..))")
    public void getter() {}

    //    Match all setter methods
    @Pointcut("execution(* com.afterReturning.dao.*.set*(..))")
    public void setter() {}

    //    Match all methods but exclude getters and setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterOrSetter() {}
}
