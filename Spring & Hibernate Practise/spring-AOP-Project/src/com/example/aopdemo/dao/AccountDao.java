package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao  {

    private String name;
    private String serviceCode;
    public List<Account> findAccounts(boolean tripWire){

        if(tripWire){
            throw new RuntimeException("Throwing Runtime exception");
        }
        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("Venkul","Level1");
        Account temp2 = new Account("Monesh","Level2");
        Account temp3 = new Account("Vommi","Level3");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

}
