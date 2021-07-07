package com.example.passport.thc.service;

import com.example.passport.thc.exceptions.OpenHoursServiceException;
import com.example.passport.thc.model.OpenHours;

import com.example.passport.thc.repository.OpenHoursRepository;
import com.example.passport.thc.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OpenHoursServiceImpl implements OpenHoursService{

    @Autowired
    OpenHoursRepository openHoursRepository;

    @Override
    public OpenHours findById(Long id) {
//        return openHoursRepository.findByOpenHoursId(id);
        return Optional.ofNullable(openHoursRepository.findByOpenHoursId(id))
                .orElseThrow(() -> new OpenHoursServiceException("No open hours found with specific ID"));

    }

    @Override
    public List<OpenHours> findAll() {

//        return (List<OpenHours>) openHoursRepository.findAll();
        return (List<OpenHours>) Optional.ofNullable(openHoursRepository.findAll())
                .orElseThrow(() -> new OpenHoursServiceException("No data found in database"));
    }

    @Override
    @Transactional
    public Boolean addOpenHours(OpenHours openHours) {
        openHoursRepository.save(openHours);
        return true;
    }

    @Override
    @Transactional
    public OpenHours updateHours(OpenHours openHours) {
//        return openHoursRepository.save(openHours);
        return Optional.ofNullable(openHoursRepository.save(openHours))
                .orElseThrow(() -> new OpenHoursServiceException("No opne hour found in database with given id"));
    }

    @Override
    @Transactional
    public Response<String> deleteHours(Long id) {
        openHoursRepository.deleteById(id);
        return null;
    }

}
