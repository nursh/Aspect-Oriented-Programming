package com.afterThrowing.app;


import com.afterThrowing.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean causeException = true;
            accountDAO.findAccounts(causeException);
        } catch(Exception e) {
            System.out.println("Exception Caught " + e);
        }

        System.out.println("------ Main Program ------");
        System.out.println(accounts);
        System.out.println("--------------------------");
        context.close();
    }
}
