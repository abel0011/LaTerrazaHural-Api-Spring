package com.idat.LaTerrazaHuaral.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.idat.LaTerrazaHuaral.model.Tables;
import com.idat.LaTerrazaHuaral.service.TablesService;

@RestController
@RequestMapping("/tables")
public class TablesController {
    @Autowired
    private TablesService tableService;


    @GetMapping("/all")
    @ApiOperation("Get all table")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Tables>> getAll() {
        return new ResponseEntity<>(tableService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Tables with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Table not found")})
    public ResponseEntity<Tables> getById(@ApiParam(value = "The id of the Tables", required = true, example = "5") @PathVariable("id") int id) {
        return tableService.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // FILTRA LAS RESERVAS POR EL idStateReservation
    @GetMapping("/findByIdStateReservation/{idStateReservation}")
    @ApiOperation("Search by idStateTable")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Table not found")})
    public ResponseEntity<List<Tables>> getByIdStateReservation(@ApiParam(value = "The id of state Table", required = true, example = "5") @PathVariable("idStateTable") String id) {
        return new ResponseEntity<>(tableService.findByIdStateTables(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Save a Table")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Tables> save(@RequestBody Tables table) {
        return new ResponseEntity<>(tableService.save(table), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Table")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Tables> update(@RequestBody Tables table) {

        Tables findTables = tableService.findById(table.getIdTable()).map(reservation -> {
            return reservation;
        }).orElse(null);

        findTables.setNumberPerson(table.getNumberPerson());
        findTables.setDescription(table.getDescription());
        return new ResponseEntity<>(tableService.save(findTables), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Table by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(@ApiParam(value = "The id of the table", required = true, example = "1") @PathVariable("id") int id) {
        return (tableService.delete(id)) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
}


