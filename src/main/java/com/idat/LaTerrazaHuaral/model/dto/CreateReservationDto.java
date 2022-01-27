package com.idat.LaTerrazaHuaral.model.dto;
import java.util.Date;

import lombok.Data;

@Data
public class CreateReservationDto {

      Date reservationDate;
      Integer idUser;
      Integer idTable;
    
}




