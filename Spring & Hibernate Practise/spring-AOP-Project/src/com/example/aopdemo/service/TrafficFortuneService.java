package com.example.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {


    public String getFortune(boolean tripWire){

        if (tripWire){
            throw new RuntimeException("Throwing Exception Monesh");
        }

        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Substitute for exception";

    }
}
