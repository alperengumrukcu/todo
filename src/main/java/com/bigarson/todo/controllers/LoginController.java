package com.bigarson.todo.controllers;

import com.bigarson.todo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LoginController extends LoginService{
    
    @Autowired
    LoginService loginService;

    @GetMapping("/logix")
    public ResponseEntity<String> login(@RequestParam String email,@RequestParam String password) {
       return ResponseEntity.ok(loginService.loginUser(email, password));
    }
}
