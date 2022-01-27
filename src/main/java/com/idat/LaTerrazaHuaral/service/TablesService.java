package com.idat.LaTerrazaHuaral.service;

import java.util.List;
import java.util.Optional;
import com.idat.LaTerrazaHuaral.model.Tables;
import com.idat.LaTerrazaHuaral.repository.TablesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesService {

    @Autowired
    private TablesRepository repository;

    public List<Tables> getAll() {
        return repository.getAll();
    }

    public Optional<Tables> findById(int idTables) {
        return repository.findById(idTables);
    }

    public Tables save(Tables reservation) {
        return repository.save(reservation);
    }

    public List<Tables> findByIdStateTables(String idStateTables) {
        return repository.findByIdStateTables(idStateTables);
    }


    public boolean delete(int idTables) {
        return this.findById(idTables).map(driver -> {
            repository.delete(idTables);
            return true;
        }).orElse(false);
    }
    
}


