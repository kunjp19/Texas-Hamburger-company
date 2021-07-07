package com.example.passport.thc.repository;

import com.example.passport.thc.model.Locations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Locations, Long> {

    Locations findByName(String locationName);

    Locations findByLocationId (Long locationId);

    Page<Locations> findAll(Pageable pageable);

}
