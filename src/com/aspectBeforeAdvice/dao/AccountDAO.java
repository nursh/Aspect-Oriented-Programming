package com.aspectBeforeAdvice.dao;

import com.aspectBeforeAdvice.app.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account) {
        System.out.println(this.getClass() + ": Doing add account work");
    }
}
