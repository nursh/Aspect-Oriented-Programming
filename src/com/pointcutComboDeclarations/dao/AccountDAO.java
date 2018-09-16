package com.pointcutComboDeclarations.dao;


import com.pointcutComboDeclarations.app.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
