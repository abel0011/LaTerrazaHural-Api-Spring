package com.idat.LaTerrazaHuaral.repository.crud;

import java.util.List;

import com.idat.LaTerrazaHuaral.model.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface  IReservationCR extends CrudRepository<Reservation,Integer>{

    List<Reservation> findByIdUser(Integer idUser );
}
