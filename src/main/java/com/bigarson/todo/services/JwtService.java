package com.bigarson.todo.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
    private String secretKey = "6KXNtd2PQx6cE8r4q4fUBPyx";

    public String jwtBuilder(Map<String, Object> claims, int expTimeMinute, int expTimeDay)
            throws UnsupportedEncodingException {
        Date currentTime = new Date(System.currentTimeMillis());
        Date expirationTime = new Date(
                System.currentTimeMillis() + (60 * 1000 * expTimeMinute) + (expTimeDay * 60 * 60 * 24 * 1000));
        String jws = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentTime)
                .setExpiration(expirationTime)
                .signWith(
                        SignatureAlgorithm.HS256,
                        secretKey.getBytes("UTF-8"))
                .compact();
        return jws;
    }

    public boolean isJwtVerify(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey.getBytes("UTF-8")).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Object getTokenKey(String token, String key) {
        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey(secretKey.getBytes("UTF-8")).parseClaimsJws(token);
            return jws.getBody().get(key);
        } catch (Exception e) {
            return null;
        }
    }
}
