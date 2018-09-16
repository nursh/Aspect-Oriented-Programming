package com.aroundAdviceExceptionHandling.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLoggingAspect {

    @Before("com.aroundAdviceExceptionHandling.aspect.AopExpressions.forDaoPackageNoGetterOrSetter()")
    public void logToCloud() {
        System.out.println("====>>> Logging to the cloud");
    }
}
