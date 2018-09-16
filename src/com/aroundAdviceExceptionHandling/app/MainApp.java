package com.aroundAdviceExceptionHandling.app;


import com.aroundAdviceExceptionHandling.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        TrafficFortuneService fortuneService = context.getBean(
            "trafficFortuneService", TrafficFortuneService.class);
        System.out.println("Main Program");
        System.out.println("Calling getFortune()");
        boolean throwException = true;
        String data = fortuneService.getFortune(throwException);
        System.out.println("My fortune is: " + data);
        System.out.println("-------Finished--------");

        context.close();
    }
}
