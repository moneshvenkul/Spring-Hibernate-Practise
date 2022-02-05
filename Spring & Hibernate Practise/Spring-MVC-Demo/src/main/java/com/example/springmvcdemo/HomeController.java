package com.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/")
    public String showMyPage(){
        return "main-menu";
    }

    @RequestMapping("/monesh")
    public String showMyPageMonesh(){
        return "monesh-home";
    }

}
