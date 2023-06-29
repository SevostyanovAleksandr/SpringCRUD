package com.example.CRUD.controller;

import com.example.CRUD.model.User;
import com.example.CRUD.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.List;

// cвязывает мою страницу с написанным приложеним
@Controller
public class UserController {

    private final UserSevice userService;

    @Autowired
    public UserController(UserSevice userService) {
        this.userService = userService;
    }

    //перейдя на страницу users будет реализовываться функционал
    @GetMapping(value = "/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping(value = "/user-create")
    public String creatUserform(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deletedById(id);
        return "redirect:/users";
    }
@GetMapping(value = "/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping(value = "/user-update")
    public String updateUser (User user){
        userService.saveUser(user);
        return "redirect:/users";

    }
}