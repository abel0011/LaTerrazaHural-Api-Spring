package com.idat.LaTerrazaHuaral.repository;

import java.util.List;
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Person;
import com.idat.LaTerrazaHuaral.repository.crud.IPersonCR;
import com.idat.LaTerrazaHuaral.service.contracts.IPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository implements IPersonRepository{

    @Autowired
    private IPersonCR crud;

    @Override
    public void delete(int idPerson) {
        crud.deleteById(idPerson);
    }

    @Override
    public Optional<Person> findById(int idPerson) {
        return crud.findById(idPerson);
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) crud.findAll();
    }

    @Override
    public Person save(Person person) {
        return crud.save(person);
    }

   
}
