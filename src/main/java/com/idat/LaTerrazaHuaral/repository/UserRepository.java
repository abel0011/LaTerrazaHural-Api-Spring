package com.idat.LaTerrazaHuaral.repository;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.repository.crud.IUserCR;
import com.idat.LaTerrazaHuaral.service.contracts.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository{

    @Autowired
    private IUserCR crud;

    @Override
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    @Override
    public List<User> getEmployesAll() {
        return (List<User>) crud.getEmployesAll();
    }

    @Override
    public List<User> findByIdRole(Integer idRol) {
        return (List<User>) crud.findByIdRol(idRol);
    }

    @Override
    public Optional<User> findById(int idUser) {
        return crud.findById(idUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return crud.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return crud.save(user);
    }

    @Override
    public void delete(int idUser) {
        crud.deleteById(idUser);
    }

    @Override
    public List<User> getAllActive() {
        return (List<User>) crud.getAllActive();
    }
} 

