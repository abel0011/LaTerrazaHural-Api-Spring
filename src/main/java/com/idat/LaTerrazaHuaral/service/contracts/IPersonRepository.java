package com.idat.LaTerrazaHuaral.service.contracts;

import java.util.List;
import java.util.Optional;
import com.idat.LaTerrazaHuaral.model.Person;

public interface IPersonRepository {

    List<Person> getAll();
    Optional<Person> findById(int idPerson);
    Person save(Person person);
    void delete(int idPerson);
    
}
