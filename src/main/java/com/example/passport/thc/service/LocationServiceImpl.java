package com.example.passport.thc.service;

import com.example.passport.thc.exceptions.LocationServiceException;
import com.example.passport.thc.model.Locations;
import com.example.passport.thc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepo;

    @Transactional
    public Boolean addLocation(Locations location){
        List<Locations> locations = findAll();
        boolean flag = false;
        for(Locations loc : locations)
        {
            if(loc.getName().equals(location.getName()))
            {
                flag = true;
            }
        }
        if(flag)
        {
            throw new LocationServiceException("Already exists");
        }
        else
        {
            locationRepo.save(location);
            return true;
        }

    }

    @Override
    public List<Locations> findAll() {
//        return (List<Locations>) locationRepo.findAll();
//                .orElseThrow(() -> new OrderServiceException("No orders are present currently"));
        return (List<Locations>) Optional.ofNullable(locationRepo.findAll())
                .orElseThrow(() -> new LocationServiceException("No location found in database"));
    }

    @Override
    public Locations findOne(Long id) {
//        return locationRepo.findByLocationId(id);
        return Optional.ofNullable(locationRepo.findByLocationId(id))
                .orElseThrow(() -> new LocationServiceException("Location not found with same id"));
    }


    @Override
    public Locations findByName(String locationName) {
//        return locationRepo.findByName(locationName);
        return Optional.ofNullable(locationRepo.findByName(locationName))
                .orElseThrow(()-> new LocationServiceException("Location not found with same name in database"));

    }

    @Transactional
    public Locations updateLocation(Locations locations) {
        Optional<Locations> existing = locationRepo.findById(locations.getLocationId());
        if(!existing.isPresent())
            throw new LocationServiceException("Location not present in database");
        return locationRepo.save(locations);
    }

    @Override
    @Transactional
    public Locations deleteByName(String name) {
        Locations existing = locationRepo.findByName(name);
        locationRepo.delete(existing);
        return existing;
//        return Optional.ofNullable(locationRepo.delete(existing))
//                .orElseThrow(()  -> new LocationServiceException("Order not found in database"));
    }

    @Transactional
    public List<Locations> findAllByPageLimit(Integer pageNo, Integer pageSize)
    {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        return Optional.ofNullable(locationRepo.findAll(paging))
                .orElseThrow(() -> new LocationServiceException("No Location Found"))
                .getContent();
        //return  locationRepo.findAll(paging);

    }

    public List<Locations> sortByValues(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return Optional.ofNullable(locationRepo.findAll(paging))
                .orElseThrow(() -> new LocationServiceException("No locations were found based on the sort values"))
                .getContent();

    }

}
