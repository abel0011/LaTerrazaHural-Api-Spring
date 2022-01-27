package com.idat.LaTerrazaHuaral.repository;



import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Tables;
import com.idat.LaTerrazaHuaral.repository.crud.ITablesCR;
import com.idat.LaTerrazaHuaral.service.contracts.ITablesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TablesRepository implements ITablesRepository{

  @Autowired
    private ITablesCR crud;

    @Override
    public List<Tables> getAll() {
        return (List<Tables>) crud.findAll();
    }


    @Override
    public Optional<Tables> findById(int idTables) {
        return crud.findById(idTables);
    }

    @Override
    public Tables save(Tables reservation) {
        return crud.save(reservation);
    }

    @Override
    public void delete(int idTables) {
        crud.deleteById(idTables);
    }

    @Override
    public List<Tables> findByIdStateTables(String idStateTables) {
        return crud.findByStatus(idStateTables);
    }
    
    
}
