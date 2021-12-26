package com.idat.LaTerrazaHuaral.service;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.repository.UserRepository;
import com.idat.LaTerrazaHuaral.shared.EncryptPassword;
import com.idat.LaTerrazaHuaral.shared.Global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }
    public List<User> getAllActive(){
        return repository.getAllActive();
    }

    public List<User> getEmployesAll() {
        return repository.getEmployesAll();
    }

    public List<User> findByIdRole(Integer idRole) {
        return repository.findByIdRole(idRole);
    }

    public Optional<User> findById(int idUser) {
        return repository.findById(idUser);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User save(User user) {

        user.setPassword(EncryptPassword.encrypt(user.getPassword()));
        return repository.save(user);
    }


    public boolean delete(int idUser) {
        User findUser = this.findById(idUser).map(driver -> {

            return driver;
        }).orElse(null);

        if (findUser != null) {
            findUser.setActive(Global.INACTIVE);
            repository.save(findUser);
            return true;
        }
        return false;
    }
}
