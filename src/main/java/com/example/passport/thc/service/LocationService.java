package com.example.passport.thc.service;

import com.example.passport.thc.model.Locations;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {

    Boolean addLocation(Locations location);

    List<Locations> findAll();

    Locations findOne(Long id);

    Locations findByName(String locationName);

    Locations deleteByName(String locationName);

    Locations updateLocation(Locations location);

    List<Locations> findAllByPageLimit(Integer pageNo, Integer pageSize);

    List<Locations> sortByValues(Integer pageNo, Integer pageSize, String sortBy);
}
