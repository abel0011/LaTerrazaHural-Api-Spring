package com.idat.LaTerrazaHuaral.service;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Person;
import com.idat.LaTerrazaHuaral.repository.PersonRepository;
import com.idat.LaTerrazaHuaral.shared.Global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> getAll() {
        return repository.getAll();
    }

    
    public Optional<Person> findById(int idUser) {
        return repository.findById(idUser);
    }


    public Person save(Person user) {
        return repository.save(user);
    }


    public boolean delete(int idPerson) {
        Person findPerson = this.findById(idPerson).map(driver -> {

            return driver;
        }).orElse(null);

        if (findPerson != null) {
            findPerson.setActive(Global.INACTIVE);
            repository.save(findPerson);
            return true;
        }
        return false;
    }

    
}
