package com.example.passport.thc.repository;

import com.example.passport.thc.model.OpenHours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenHoursRepository extends CrudRepository<OpenHours, Long> {

    OpenHours findByOpenHoursId(Long id);
}
