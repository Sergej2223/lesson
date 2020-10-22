package org.maslov.less.controller;

import org.maslov.less.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class HomeController {
    Collection<User> users = new ArrayList<>();
    @GetMapping(value = "/")
    public String hello() {
        return "hello";
    }
    @RequestMapping(value = "/users")
    public String getUsers(Model model)  {
        model.addAttribute( "users", users);;
        return "Users";
    }
    @GetMapping(value = "/addUsers")
    public String getSignUp(Model model)
    {
        model.addAttribute( "user", new User(  ) );
        return "sign_up";
    }
    @PostMapping(value = "/addUsers")
    public String getSignUp(@ModelAttribute @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "sign_up";
        }
        users.add(user);
        return "Users";
    }
}

