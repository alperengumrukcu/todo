package com.bigarson.todo.controllers;

import com.bigarson.todo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends LoginService{
    
    @Autowired
    LoginService loginService;

    @PostMapping("/logix")
    public String login(@RequestParam String email,@RequestParam String password) {
       return loginService.loginUser(email, password);
    }
}
