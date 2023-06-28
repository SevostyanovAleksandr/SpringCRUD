package com.example.CRUD.controller;

import com.example.CRUD.model.User;
import com.example.CRUD.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// cвязывает мою страницу с написанным приложеним
@Controller
public class UserController {
@Autowired
    private UserSevice userService;
    //перейдя на страницу users будет реализовываться функционал
    @GetMapping(value = "/users")

    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
return "user-list";
    }

    @GetMapping (value = "/user-create")
    public  String creatUserform(User user){
        return  "user-create";
    }
    @GetMapping
    public String creatUser (User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
