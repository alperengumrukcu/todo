package com.bigarson.todo.services;

import java.util.HashMap;

import com.bigarson.todo.models.User;
import com.bigarson.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    BcryptService bcryptService;
    @Autowired
    JwtService jwtService;

    public String loginUser(String email, String password) {
        try {
            User currentUser = userRepo.findByeMail(email);
        if (currentUser != null &&currentUser.geteMail().equals(email) &&
                bcryptService.passMatch(currentUser, password)) {
                    HashMap<String,Object> claims = new HashMap<>();
                    claims.put("eMail", currentUser.geteMail());
            return jwtService.jwtBuilder(claims, 0, 30);
        } else {
            return "Giriş Başarısız";
        }
        } catch (Exception e) {
            return "Bilinmeyen hata";
        }
    }
}
