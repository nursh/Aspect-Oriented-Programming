package com.pointcutOrderAspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.pointcutOrderAspects.aspect.AopExpressions.forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("====>>> Executing @Before addAccount");
    }




}
