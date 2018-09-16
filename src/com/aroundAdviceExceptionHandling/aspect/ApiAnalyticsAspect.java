package com.aroundAdviceExceptionHandling.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.aroundAdviceExceptionHandling.aspect.AopExpressions.forDaoPackageNoGetterOrSetter()")
    public void performApiAnalytics() {
        System.out.println("====>>> Performing API analytics");
    }
}