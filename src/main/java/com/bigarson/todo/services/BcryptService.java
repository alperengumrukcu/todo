package com.bigarson.todo.services;

import com.bigarson.todo.models.User;
import com.bigarson.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptService {

    @Autowired
    UserRepository userRepo;

    PasswordEncoder passEncod = new BCryptPasswordEncoder();

    public String Bcrypt(String password) {
        String encodedPass = passEncod.encode(password);
        return encodedPass;
    }

    public boolean passMatch(User checkPassUser, String password) {
        if (passEncod.matches(password,checkPassUser.getPassword())
                && checkPassUser.getEmailStatus())
            return true;
        else
            return false;
    }
}
