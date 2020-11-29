package org.maslov.less.controller;

import org.maslov.less.dao.UserDAO;
import org.maslov.less.model.User;
import org.maslov.less.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class HomeController {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/")
    public String hello() {

        return "/Hello";
    }
    @RequestMapping(value = "/users")
    public String getUsers(Model model) throws SQLException {
        model.addAttribute( "users", userDAO.getAll() );
        return "Users";
    }
    @GetMapping(value = "/addUsers")
    public String getSignUp(Model model)
    {
        model.addAttribute( "user", new User(  ) );
        return "/Sign_up";
    }
    @PostMapping(value = "/addUsers")
    public String getSignUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {
        userValidator.validate( user, result);
        if (result.hasErrors()){
            return "/Sign_up";
        }
        userDAO.add(user);
        return "redirect:/users";
    }
}

