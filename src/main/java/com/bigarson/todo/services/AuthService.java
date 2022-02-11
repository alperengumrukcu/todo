package com.bigarson.todo.services;

import com.bigarson.todo.base.BaseService;

import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService {

    public String sayilariTopla(int sayi1, int sayi2) {
        int toplam = sayi1 + sayi2;
        return String.valueOf(toplam);
    }

}