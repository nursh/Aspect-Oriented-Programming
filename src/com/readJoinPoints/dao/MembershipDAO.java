package com.readJoinPoints.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(this.getClass() + ": Doing Membership addAccount");
    }
}
