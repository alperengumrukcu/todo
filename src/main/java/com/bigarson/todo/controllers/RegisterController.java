package com.bigarson.todo.controllers;

import java.io.UnsupportedEncodingException;

import com.bigarson.todo.models.User;
import com.bigarson.todo.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController extends RegisterService {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public String saveNewUserSendVerifyEmail(@RequestBody User newUser) throws UnsupportedEncodingException {
        User savedUser = registerService.saveNewUser(newUser);
        if (registerService.sendNewUserMail(savedUser))
            return "Kayıt başarılı";
        else
            return "Kayıt başarız";
    }

    @GetMapping
    public String verifyUser(@RequestParam String token) {
        boolean isVerify = registerService.isJwtVerify(token);
        if (isVerify) {
            registerService.updatedMailStatus(token);
            return "E Mail doğrulandı.";
        } else
            return "E Mail doğrulanamadı!!! \n Lütfen Tekrar Kayıt Olun";
    }
}
