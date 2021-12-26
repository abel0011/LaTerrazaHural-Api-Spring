package com.idat.LaTerrazaHuaral.security.controller;

import com.idat.LaTerrazaHuaral.model.Person;
import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.model.dto.CreatePersonDto;
import com.idat.LaTerrazaHuaral.model.dto.CreateUserDto;
import com.idat.LaTerrazaHuaral.model.response.AuthenticationRequest;
import com.idat.LaTerrazaHuaral.model.response.AuthenticationResponse;
import com.idat.LaTerrazaHuaral.security.jwt.JWTUtil;
import com.idat.LaTerrazaHuaral.security.jwt.UserDetailsCustomService;
import com.idat.LaTerrazaHuaral.service.PersonService;
import com.idat.LaTerrazaHuaral.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // clase de spring security para saber si estas autenticado
    @Autowired
    private AuthenticationManager authenticationManager;

    // este servicio busca los usuarios registrados sea en memoria o en la bd
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    // componente creado para generarnew AuthenticationResponse(jwt), un jwt
    @Autowired
    private JWTUtil jwtUtil;

    // Servicio de Clientes
    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    // usamos nuestra clases dto AuthenticationResponse AuthenticationRequest

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        try {
            // se autentica con spring
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            // busco al usuario si esta registrado
            UserDetails userDetails = userDetailsCustomService.loadUserByUsername(request.getUsername());

            // genero un jwt
            String jwt = jwtUtil.generaToken(userDetails);

            // getUser for name
            User userFind = userService.findByUsername(jwtUtil.extractUsername(jwt)).map(Client -> {
                return Client;
            }).orElse(null);

            // retorno el jwt si todo sale correcto
            return new ResponseEntity<>(new AuthenticationResponse(jwt, userFind), HttpStatus.OK);

        } catch (BadCredentialsException e) {
            // si ocurre una exception de tipo badcredentials retorna un not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/registerUser")
    @ApiOperation("Register User")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<User> saveUser(@RequestBody CreateUserDto user) {
        User newUser = new User();

        
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setActive("A");
        newUser.setIdRol(user.getIdRol());
        newUser.setIdPerson(user.getIdPerson());
        return new ResponseEntity<>(userService.save(newUser), HttpStatus.OK);
    }


    @PostMapping("/registerPerson")
    @ApiOperation("Register Person")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Person> savePerson(@RequestBody CreatePersonDto person) {
        Person newPerson = new Person();

        newPerson.setFirstName(person.getFirstName()); 
        newPerson.setMiddleName(person.getMiddleName());
        newPerson.setLastName(person.getLastName()); 
        newPerson.setBirthName(person.getBirthName());
        newPerson.setPhone(person.getPhone());
        newPerson.setDni(person.getDni());
        newPerson.setActive("A");
        newPerson.setRole(person.getRole());
        newPerson.setDateOfBirth(person.getDateOfBirth());

        return new ResponseEntity<>(personService.save(newPerson), HttpStatus.OK);
    }

}

