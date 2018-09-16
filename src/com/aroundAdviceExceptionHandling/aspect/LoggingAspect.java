package com.aroundAdviceExceptionHandling.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // Could have used logger and logger.warn in the try-catch
    @Around("execution(* com.aroundAdviceExceptionHandling.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Around method: " + method);

        long start = System.currentTimeMillis();
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());

//            Throws the exception
            throw e;
//             This handles the exception without throwing
//            result = "Don't worry, Road will be cleared in few hours";
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Duration of execution: " + duration / 1000.0 + "secs");
        return result;
    }


}
