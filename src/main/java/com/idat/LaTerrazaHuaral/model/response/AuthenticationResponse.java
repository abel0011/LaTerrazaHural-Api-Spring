package com.idat.LaTerrazaHuaral.model.response;

import com.idat.LaTerrazaHuaral.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private User User;
    
}
