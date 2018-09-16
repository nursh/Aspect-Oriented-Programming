package com.afterReturning.app;


import com.afterReturning.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("------ Main Program ------");
        System.out.println(accounts);
        System.out.println("--------------------------");
        context.close();
    }
}
