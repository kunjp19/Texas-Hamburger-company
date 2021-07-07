package com.example.passport.thc.controller;

import com.example.passport.thc.model.Reservations;
import com.example.passport.thc.response.Response;
import com.example.passport.thc.response.ResponseMetadata;
import com.example.passport.thc.response.StatusMessage;
import com.example.passport.thc.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping(produces = "application/json")
    public Response<List<Reservations>> getAllMenus() {
        return Response.<List<Reservations>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((reservationService.findAll()))
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Response<Reservations> findById(@PathVariable("id") Long id) {
        return Response.<Reservations>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((reservationService.findById(id)))
                .build();

    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Response<String> addReservation(@RequestBody Reservations reservation){
        return reservationService.addReservation(reservation) == Boolean.TRUE ? Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(201)
                        .statusMessage(StatusMessage.CREATED.name())
                        .build())
                .data("Reservation added successfully")
                .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder().statusCode(500)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                                .build())
                        .data("Failed to add Reservation")
                        .build();
    }

    @PutMapping(value ="/update",produces = "application/json",consumes = "application/json")
    public Response<Reservations> update(@RequestBody Reservations reservation){
        return Response.<Reservations>builder()
                .meta(ResponseMetadata.builder().statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name())
                        .build())
                .data((reservationService.updateReservation(reservation)))
                .build();
    }

    @DeleteMapping(value = "delete/{id}", produces = "application/json")
    public Response<String> delete(@PathVariable("id")Long id) {
        reservationService.deleteReservation(id);
        return Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(202)
                        .statusMessage(StatusMessage.DELETE.name())
                        .build())
                .data("Reservation Delete successfully")
                .build();
    }
}
