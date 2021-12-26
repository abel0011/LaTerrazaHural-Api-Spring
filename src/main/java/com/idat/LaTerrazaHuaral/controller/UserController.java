package com.idat.LaTerrazaHuaral.controller;

import java.util.List;

import com.idat.LaTerrazaHuaral.model.Person;
import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.model.dto.UpdateUserDto;
import com.idat.LaTerrazaHuaral.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation("Get all users")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/allactive")
    @ApiOperation("Get all actives users ")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAllActive() {
        return new ResponseEntity<>(userService.getAllActive(), HttpStatus.OK);
    }


    @GetMapping("/allEmployes")
    @ApiOperation("Get all employes")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAllEmployes() {
        return new ResponseEntity<>(userService.getEmployesAll(), HttpStatus.OK);
    }


    @GetMapping("/findByRole/{id}")
    @ApiOperation("Search a user filter id role")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "User not found")})
    public ResponseEntity<List<User>> getByIdRole(
            @ApiParam(value = "The id role", required = true, example = "2")
            @PathVariable("id") int idRole) {
        return new ResponseEntity<>(userService.findByIdRole(idRole), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a user with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "User not found")})
    public ResponseEntity<User> getById(
            @ApiParam(value = "The id of the user", required = true, example = "5")
            @PathVariable("id") int idCategory) {
        return userService.findById(idCategory).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    @ApiOperation("Update a User")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<User> update(@RequestBody UpdateUserDto user) {

        User findUser = userService.findById(user.getIdUser()).map(user1 -> {
            return user1;
        }).orElse(null);

        findUser.setUsername(user.getUsername());
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());
        findUser.setActive(user.getActive().toUpperCase());

        return new ResponseEntity<>(userService.save(findUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a User by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(
            @ApiParam(value = "The id of the user", required = true, example = "1")
            @PathVariable("id") int idUser) {
        return (userService.delete(idUser)) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

    

