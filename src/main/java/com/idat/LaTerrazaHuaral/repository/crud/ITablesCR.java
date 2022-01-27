package com.idat.LaTerrazaHuaral.repository.crud;

import java.util.List;
import com.idat.LaTerrazaHuaral.model.Tables;
import org.springframework.data.repository.CrudRepository;

public interface ITablesCR extends CrudRepository<Tables,Integer>{
    List<Tables> findByStatus(String idTable);
}
