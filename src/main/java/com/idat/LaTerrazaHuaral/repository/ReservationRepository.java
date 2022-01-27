package com.idat.LaTerrazaHuaral.repository;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Reservation;
import com.idat.LaTerrazaHuaral.repository.crud.IReservationCR;
import com.idat.LaTerrazaHuaral.service.contracts.IReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository  implements IReservationRepository{

    @Autowired
    private IReservationCR crud;

    @Override
    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }


    @Override
    public Optional<Reservation> findById(int idReservation) {
        return crud.findById(idReservation);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return crud.save(reservation);
    }

    @Override
    public void delete(int idTables) {
        crud.deleteById(idTables);
    }

    
    
    
}

