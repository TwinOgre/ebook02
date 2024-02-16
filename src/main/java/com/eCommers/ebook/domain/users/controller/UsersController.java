package com.eCommers.ebook.domain.users.controller;

import com.eCommers.ebook.domain.users.UsersForm;
import com.eCommers.ebook.domain.users.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/register")
    public String register(UsersForm usersForm){

        return "/users/registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid UsersForm usersForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/users/registerForm";
        }
        if(!usersForm.getPassword1().equals(usersForm.getPassword2()) ){
            return "/users/registerForm";
        }

        this.usersService.register(usersForm);

        return "redirect:/";
    }
}
