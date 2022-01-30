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
import java.util.Optional;

import com.idat.LaTerrazaHuaral.model.Reservation;
import com.idat.LaTerrazaHuaral.model.Tables;
import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.model.dto.CreateReservationDto;
import com.idat.LaTerrazaHuaral.service.ReservationService;
import com.idat.LaTerrazaHuaral.service.TablesService;
import com.idat.LaTerrazaHuaral.service.UserService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TablesService tableService;

    @Autowired
    private UserService userService;



    @GetMapping("/all")
    @ApiOperation("Get all reservation")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Reservation>> getAll() {
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Reservation with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Reservation not found")})
    public ResponseEntity<Reservation> getById(@ApiParam(value = "The id of the Reservation", required = true, example = "5") @PathVariable("id") int id) {
        return reservationService.findById(id)
            .map(p -> 
                new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByIdUserReservation/{idUser}")
    @ApiOperation("Search by idStateReservation")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Reservation not found")})
    public ResponseEntity<List<Reservation>> getByIdUserReservation(@ApiParam(value = "The id of state Reservation", required = true, example = "5") @PathVariable("idUser") Integer idUser) {
        return new ResponseEntity<>(reservationService.findByIdUser(idUser), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Save a Table")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Reservation> save(@RequestBody CreateReservationDto reservation) {

       Reservation newReservation = new Reservation();
       User user =  userService.findById(reservation.getIdUser()).map(user1 -> {
            return user1;
        }).orElse(null);

       newReservation.setStatus("R");
       newReservation.setIdTable(reservation.getIdTable());
       newReservation.setIdUser(reservation.getIdUser());
       newReservation.setReservationDate(reservation.getReservationDate() );
       newReservation.setUser(user);

       Tables table =  tableService.findById(reservation.getIdTable()).map(ta -> {
            return ta;
        }).orElse(null);

        table.setStatus("R");

        return new ResponseEntity<>(reservationService.save(newReservation), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a Reservation")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<Reservation> update(@RequestBody CreateReservationDto reservation) {

        Reservation findReservation = reservationService.findById(reservation.getIdUser()).map(re -> {
            return re;

        }).orElse(null);

        return new ResponseEntity<>(reservationService.save(findReservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Reservation by ID")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<?> delete(@ApiParam(value = "The id of the reservation", required = true, example = "1") @PathVariable("id") int id) {
        return (reservationService.delete(id)) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
}


