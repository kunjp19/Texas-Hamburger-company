package com.example.passport.thc.service;

import com.example.passport.thc.exceptions.ReservationServiceException;
import com.example.passport.thc.model.Reservations;
import com.example.passport.thc.repository.ReservationsRepository;
import com.example.passport.thc.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationsRepository reservationsRepository;

    @Transactional
    public Boolean addReservation(Reservations reservation) {
        reservation.setCreatedAt(new Time(Calendar.getInstance().getTime().getTime()));
        reservationsRepository.save(reservation);
        return true;

    }

    @Override
    public List<Reservations> findAll(){
//        return (List<Reservations>) reservationsRepository.findAll();
        return (List<Reservations>) Optional.ofNullable(reservationsRepository.findAll())
                .orElseThrow(()-> new ReservationServiceException("No Reservation found in database"));
    }

    @Override
    public Reservations findById(Long id){
//        return reservationsRepository.findByReservationId(id);
        return Optional.ofNullable(reservationsRepository.findByReservationId(id))
                .orElseThrow(()-> new ReservationServiceException("No reservation found in database with given id"));
    }


    @Override
    @Transactional
    public Reservations updateReservation(Reservations reservation) {
//        return reservationsRepository.save(reservation);
        return Optional.ofNullable(reservationsRepository.save(reservation))
                .orElseThrow(()-> new ReservationServiceException("No Reservation found in database with given id"));
    }

    @Override
    @Transactional
    public Response<String> deleteReservation(Long menuId) {
        reservationsRepository.deleteById(menuId);
        return null;
//        Reservations res = Optional.ofNullable(reservationsRepository.deleteById(menuId))
//                .orElseThrow(()-> new ReservationServiceException("No reservation found"));
    }

}
