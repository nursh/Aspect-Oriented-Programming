package com.aroundAdviceExceptionHandling.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Expect Heavy traffic this morning!!!";
    }

    public String getFortune(boolean throwException) {
        if (throwException) {
            throw new RuntimeException("Bad weather!!! Snow day fiasco!!!");
        }

        return getFortune();
    }
}
