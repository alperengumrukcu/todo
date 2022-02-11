package com.bigarson.todo.controllers;


import com.bigarson.todo.repositories.ComponentRepository;
import com.bigarson.todo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends AuthService{
    
    @Autowired
    AuthService authService;
    @Autowired
    ComponentRepository cRepository;
    @GetMapping("/topla")
    public String topla(@RequestParam int sayi1, @RequestParam int sayi2) {
        return String.valueOf(sayi1+sayi2);
    }
    
}
