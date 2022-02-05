package com.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/form")
public class FormController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        return "input-form";
    }

    @RequestMapping("/monesh")
    public String showMyPageMonesh(){
        return "monesh-form";
    }

    @RequestMapping("/processForm")
    public  String processForm(){
        return "output-form";
    }

    @RequestMapping("/processFormRequest")
//    public String shoutMyName(HttpServletRequest request, Model model){
    public String shoutMyName(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase();
        String result = "Hey " + theName;
        model.addAttribute("message",result);
        return "processFormRequest";
    }

}
