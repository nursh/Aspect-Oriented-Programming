package com.readJoinPoints.app;


import com.readJoinPoints.dao.AccountDAO;
import com.readJoinPoints.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account("Rocky", "300");
        accountDAO.setName("Balbao");
        accountDAO.setServiceCode("Silver");
        accountDAO.addAccount(account);
        accountDAO.getName();
        accountDAO.getServiceCode();
        membershipDAO.addAccount();
        context.close();
    }
}
