package com.idat.LaTerrazaHuaral.repository.crud;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserCR extends CrudRepository<User,Integer>{
    
    Optional<User> findByUsername(String username);
    List<User> findByIdRol(Integer idRol);

    @Query(value = "SELECT * FROM users  WHERE id_rol !=1 AND id_rol != 2 AND active = 'I' ", nativeQuery = true)
    List<User> getEmployesAll();

    @Query(value = "SELECT * FROM users  WHERE active = 'A' ", nativeQuery = true)
    List<User> getAllActive();

    Optional<User> findByEmail(String email);
}
