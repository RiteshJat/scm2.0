package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home page requested");

        // Sending data to the view
        model.addAttribute("name", "Substring");
        model.addAttribute("youTube", "Hare Krishna");
        model.addAttribute("id", 123);
        model.addAttribute("gitHub_Repo", "https://github.com/substring/substring");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("about page requested");
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        System.out.println("services page requested");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        System.out.println("contact page requested");
        return "contact";
    }   

    @GetMapping("/login")
    public String login() {
        System.out.println("login page requested");
        return "login";
    }   

    @GetMapping("/signup")
    public String register() {
        System.out.println("signup page requested");
        return "signup";
    }

    @RequestMapping(value="/do-register", method = RequestMethod.POST)
    public String registerUser() {
        System.out.println("registering user");
        // fetch form data
        

        // validate form data
        // save data to database
        // message = "User registered successfully"
        // redirect to login page
        return "redirect:/signup";
    }


}
