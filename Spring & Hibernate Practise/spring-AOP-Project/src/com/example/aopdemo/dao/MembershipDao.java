package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public String addSilly(){
        return (getClass()+" This is Membership DAO's add Account");
    }

}
