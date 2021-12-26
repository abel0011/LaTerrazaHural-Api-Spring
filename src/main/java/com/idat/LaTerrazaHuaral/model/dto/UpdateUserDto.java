package com.idat.LaTerrazaHuaral.model.dto;

import lombok.Data;

@Data
public class UpdateUserDto {

    Integer idUser;
    String username;
    String password;
    String email;
    String  active;
    
}
