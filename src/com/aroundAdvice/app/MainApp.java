package com.aroundAdvice.app;


import com.aroundAdvice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainApp {

    private static Logger logger =
        Logger.getLogger(MainApp.class.getName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        TrafficFortuneService fortuneService = context.getBean(
            "trafficFortuneService", TrafficFortuneService.class);
        logger.info("Main Program");
        logger.info("Calling getFortune()");
        String data = fortuneService.getFortune();
        logger.info("My fortune is: " + data);
        logger.info("-------Finished--------");

        context.close();
    }
}
