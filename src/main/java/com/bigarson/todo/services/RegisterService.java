package com.bigarson.todo.services;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Optional;
import com.bigarson.todo.models.User;
import com.bigarson.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService extends AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSender;
    @Autowired
    JwtService jwtService;
    @Autowired
    BcryptService bcryptService;

    public User saveNewUser(User newUser) {
       String bcrypPass= bcryptService.Bcrypt(newUser.getPassword());
        newUser.setPassword(bcrypPass);
        return userRepository.save(newUser);
    }

    public boolean sendNewUserMail(User savedUser)
            throws UnsupportedEncodingException {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", savedUser.getId());
        String jwt = jwtService.jwtBuilder(claims, 3, 0);
        return mailSender.sendEmail(savedUser.geteMail(), "Doğrulama Maili", "http://192.168.1.64:8080?token=" + jwt);
    }

    public boolean isJwtVerify(String token) {
        return jwtService.isJwtVerify(token);
    }
    public void updatedMailStatus(String token) {
        int id = (int) jwtService.getTokenKey(token, "id");
        Optional<User> updatedUser = userRepository.findById(id);
        updatedUser.get().setEmailStatus(true);
        userRepository.save(updatedUser.get());
    }
}
