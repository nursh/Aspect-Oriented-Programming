package com.aroundAdviceExceptionHandling.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aroundAdviceExceptionHandling")
public class AOPConfig {
}
