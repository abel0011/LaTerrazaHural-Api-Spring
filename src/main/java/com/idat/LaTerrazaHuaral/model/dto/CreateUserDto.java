package com.idat.LaTerrazaHuaral.model.dto;

import lombok.Data;

@Data
public class CreateUserDto {

    String username;
    String password;
    String email;
    String active;
    Integer idRol;
    Integer idPerson;
}
