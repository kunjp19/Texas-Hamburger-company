package com.example.passport.thc.repository;


import com.example.passport.thc.model.Reservations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends CrudRepository<Reservations, Long> {

    Reservations findByReservationId(Long menuId);
}
