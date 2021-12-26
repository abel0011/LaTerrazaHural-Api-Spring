package com.idat.LaTerrazaHuaral.service.contracts;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.User;

public interface IUserRepository {

    List<User> getAll();
    List<User> getAllActive();
    List<User> getEmployesAll();
    List<User> findByIdRole(Integer idRol);
    Optional<User> findById(int idUser);
    Optional<User> findByUsername(String username);
    User save(User user);
    void delete(int idUser);
    
}
