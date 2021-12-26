package com.idat.LaTerrazaHuaral.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import com.idat.LaTerrazaHuaral.model.Person;
import com.idat.LaTerrazaHuaral.model.dto.CreatePersonDto;
import com.idat.LaTerrazaHuaral.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    
    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    @ApiOperation("Get all Person")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a person with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Person not found")})
    public ResponseEntity<Person> getById(
            @ApiParam(value = "The id of the person", required = true, example = "5")
            @PathVariable("id") int idCategory) {
        return personService.findById(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    @ApiOperation("Update a Person")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Person> update(@RequestBody CreatePersonDto personParan) {

        Person findPerson = personService.findById(personParan.getIdPerson()).map(person -> {
            return person;
        }).orElse(null);

    findPerson.setFirstName(personParan.getFirstName());
    // String middleName;
    findPerson.setLastName(personParan.getLastName());
    // String birthName;
    findPerson.setPhone(personParan.getPhone());
    findPerson.setDni(personParan.getDni());
    // findPerson.setActive(Global.ACTIVE)
    findPerson.setDateOfBirth(personParan.getDateOfBirth());

        return new ResponseEntity<>(personService.save(findPerson), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Person by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the person", required = true, example = "1")
            @PathVariable("id") int idUser) {
        return (personService.delete(idUser)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
}
