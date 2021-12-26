package com.idat.LaTerrazaHuaral.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CreatePersonDto {

    int idPerson;
    String firstName;
    String middleName;
    String lastName;
    String birthName;
    String phone;
    String dni;
    String active;
    Integer role;
    Date  dateOfBirth;

    
}
