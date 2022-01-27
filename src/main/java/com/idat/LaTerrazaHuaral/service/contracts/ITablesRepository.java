package com.idat.LaTerrazaHuaral.service.contracts;

import java.util.List;
import java.util.Optional;
import com.idat.LaTerrazaHuaral.model.Tables;



public interface ITablesRepository {
    List<Tables> getAll();
    List<Tables> findByIdStateTables(String idStateTables);
    Optional<Tables> findById(int idTable);
    Tables save(Tables table);
    void delete(int idTable);
    
}

