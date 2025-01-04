package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;
    
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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        //We can send the default data as well
        // userForm.setName("Ritesh");
        model.addAttribute("userForm", userForm);

        System.out.println("signup page requested");
        return "signup";
    }

    @RequestMapping(value="/do-register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("registering user");
        // fetch form data
        // UserForm

        System.out.println(userForm);

        // validate form data
        //TODO:

        // save data to database
        // userService

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?t=st=1735979111~exp=1735982711~hmac=00aba90a76542933f1bb1963717fe33e93529bf7675cc08a5bc5e712bbd61fb9&w=1060")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?t=st=1735979111~exp=1735982711~hmac=00aba90a76542933f1bb1963717fe33e93529bf7675cc08a5bc5e712bbd61fb9&w=1060");

        userService.saveUser(user);

        System.out.println("User Saved");

        Message message = Message.builder().content("Registered successfully").type(MessageType.blue).build();
        // message = "User registered successfully"
        session.setAttribute("message", message);

        // redirect to login page
        return "redirect:/signup";
    }


}
