package com.apigateway.apigateway.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoder {
    private static BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public PasswordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2A, 10);
    }
    public static String bcryptPasswordEncode(String plainPassword){
        return bCryptPasswordEncoder.encode(plainPassword);
    }
    public static boolean bcryptPasswordMatch(String plainPassword, String hashedPassword){
        return bCryptPasswordEncoder.matches(plainPassword, hashedPassword);
    }
}
