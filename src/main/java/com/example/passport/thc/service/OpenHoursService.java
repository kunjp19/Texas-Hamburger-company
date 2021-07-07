package com.example.passport.thc.service;

import com.example.passport.thc.model.OpenHours;
import com.example.passport.thc.response.Response;

import java.util.List;

public interface OpenHoursService {

    List<OpenHours> findAll();

    OpenHours findById(Long id);

    Boolean addOpenHours(OpenHours openHours);

    Response<String> deleteHours(Long id);

    OpenHours updateHours(OpenHours openHours);


}
