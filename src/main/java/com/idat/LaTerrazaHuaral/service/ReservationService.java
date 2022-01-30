package com.idat.LaTerrazaHuaral.service;




import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Reservation;
import com.idat.LaTerrazaHuaral.repository.ReservationRepository;
import com.idat.LaTerrazaHuaral.repository.TablesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.getAll();
    }

    public Optional<Reservation> findById(int idReservation) {
        return repository.findById(idReservation);
    }

    public List<Reservation> findByIdUser(Integer idUser) {
        return repository.findByIdUser(idUser);
    }

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public boolean delete(int idReservation) {
        return this.findById(idReservation).map(driver -> {
            repository.delete(idReservation);
            return true;
        }).orElse(false);
    }
    
}



