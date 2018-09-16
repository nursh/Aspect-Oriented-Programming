package com.afterThrowing.dao;


import com.afterThrowing.app.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) throw new RuntimeException("Oops!! Error Triggered");

        List<Account> accounts = Arrays.asList(
            new Account("John", "Platinum"),
            new Account("Mack", "Gold"),
            new Account("Rache", "Silver")
        );

        return accounts;
    }

    public void addAccount(Account account) {
        System.out.println(this.getClass() + ": Doing add account work");
    }

    public String getName() {
        System.out.println(this.getClass() + ": Doing getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(this.getClass() + ": Doing setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(this.getClass() + ": Doing getServicecode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(this.getClass() + ": Doing setServicecode");
        this.serviceCode = serviceCode;
    }
}
