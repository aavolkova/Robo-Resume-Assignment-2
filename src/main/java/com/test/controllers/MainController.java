package com.test.controllers;

import com.test.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Controller
public class MainController {




    @GetMapping("/")
    public String showIndex(Model model)
    {
        String myMessage = "Welcome to the Robo Resume App";
        model.addAttribute("message", myMessage);
        return "index";
    }

    @GetMapping("/enteruser")
    public String addProduct(Model model)
    {
        model.addAttribute("newUser", new User());
        return "enteruser";
    }

    @PostMapping("/enteruser")
    public String postUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult)
    {
        if(user.getStartDate().length() == 0){
            return "enteruser";
        }

        if(user.getEndDate().length() == 0){
            LocalDate today1 = LocalDate.now();
            String endDate1 = today1.toString();
            user.setEndDate(endDate1);
        }


        if(bindingResult.hasErrors()){
            return "enteruser";
        }

        user.setEmployedDays(ChronoUnit.DAYS.between(LocalDate.parse(user.getStartDate()), LocalDate.parse(user.getEndDate())));

     //   roboResumeRepository.save(user);
        return "resultuser";
    }


}
