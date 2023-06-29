package com.example.CRUD.controller;
import com.example.CRUD.model.Owner;
import com.example.CRUD.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// cвязывает мою страницу с написанным приложеним
@Controller
public class OwnerController {

    //перейдя на страницу users будет реализовываться функционал
    private final OwnerService ownerService;
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }




    @GetMapping(value = "/owner")
    public String findAll(Model model) {
        List<Owner> owner = ownerService.findAll();
        model.addAttribute("owner", owner);
        return "owner-list";
    }

    @GetMapping(value = "/owner-create")
    public String creatOwnerform(Owner owner) {
        return "owner-create";
    }

    @PostMapping("/owner-create")
    public String createOwner(Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owner";
    }

    @GetMapping(value = "owner-delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id) {
        ownerService.deletedById(id);
        return "redirect:/owner";
    }
    @GetMapping(value = "/owner-update/{id}")
    public String updateOwnerForm(@PathVariable("id") Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "/owner-update";
    }

    @PostMapping(value = "/owner-update")
    public String updateOwner (Owner owner){
        ownerService.saveOwner((owner));
        return "redirect:/owner";

    }
}