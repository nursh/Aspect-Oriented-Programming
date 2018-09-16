package com.pointcutComboDeclarations.app;


import com.pointcutComboDeclarations.dao.AccountDAO;
import com.pointcutComboDeclarations.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        accountDAO.addAccount(account);
        accountDAO.setName("Balbao");
        accountDAO.setServiceCode("Silver");
        accountDAO.getName();
        accountDAO.getServiceCode();
        membershipDAO.addAccount();
        context.close();
    }
}
