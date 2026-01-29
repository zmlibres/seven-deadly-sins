package com.seven.deadly.sin.wrath.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping
    public ResponseEntity<?> createAccount(String account) {

        return null;
    }
}
