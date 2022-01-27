package com.idat.LaTerrazaHuaral.service.contracts;


import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Reservation;

public interface IReservationRepository {

    List<Reservation> getAll();
    Optional<Reservation> findById(int idTable);
    Reservation save(Reservation reservation);
    void delete(int idReservation);
    
}
