package com.example.passport.thc.service;

import com.example.passport.thc.model.Menus;
import com.example.passport.thc.model.Reservations;
import com.example.passport.thc.response.Response;

import java.util.List;

public interface ReservationService {

    Boolean addReservation(Reservations reservation);

    List<Reservations> findAll();

    Response<String> deleteReservation(Long id);

    Reservations updateReservation(Reservations reservation);

    Reservations findById(Long id);
}
