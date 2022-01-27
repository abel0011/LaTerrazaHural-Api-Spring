package com.idat.LaTerrazaHuaral.shared;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
       public static void main(String[] args) {
        var password = "12345678";
        System.out.println("password: " + password);
        System.out.println("password: " + encrypt(password));
    }

    public static String encrypt(String password) {
        // encripta password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}
