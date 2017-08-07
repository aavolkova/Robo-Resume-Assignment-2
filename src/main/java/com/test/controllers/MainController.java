package com.test.controllers;

import com.test.models.User;

import com.test.repositories.RoboResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Controller
public class MainController {


    @Autowired
    RoboResumeRepository roboResumeRepository;


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

        roboResumeRepository.save(user);
        return "resultuser";
    }


    @GetMapping("/displayallusers")
    public String showAllUsers(Model model)
    {
        Iterable <User> usersList = roboResumeRepository.findAll();
        model.addAttribute("users" , usersList);
        //return usersList.toString();
        return "displayallusers";
    }


//    @GetMapping("/displayallusers")
//    public String list(Model model)
//    {
//       // Iterable <User> usersList = roboResumeRepository.findAll();
//        model.addAttribute("users" , userService.listAllProductd();
//        //return usersList.toString();
//        return "displayallusers";
//    }

}
