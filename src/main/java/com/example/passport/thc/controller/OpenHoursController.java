package com.example.passport.thc.controller;

import com.example.passport.thc.model.OpenHours;
import com.example.passport.thc.response.Response;
import com.example.passport.thc.response.ResponseMetadata;
import com.example.passport.thc.response.StatusMessage;
import com.example.passport.thc.service.OpenHoursService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/openhours")
public class OpenHoursController {

    @Autowired
    OpenHoursService openHoursService;

    @GetMapping(produces = "application/json")
    public Response<List<OpenHours>> getAllHours() {
        return Response.<List<OpenHours>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((openHoursService.findAll()))
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Response<OpenHours> findById(@PathVariable("id") Long id) {
        return Response.<OpenHours>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((openHoursService.findById(id)))
                .build();

    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Response<String> addOpenHours(@RequestBody OpenHours openHours) {
        return openHoursService.addOpenHours(openHours) == Boolean.TRUE ? Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(201)
                        .statusMessage(StatusMessage.CREATED.name())
                        .build())
                .data("Hours added successfully")
                .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder().statusCode(500)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                                .build())
                        .data("Failed to add Hours")
                        .build();
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public Response<OpenHours> update(@RequestBody OpenHours openHours) {
        return Response.<OpenHours>builder()
                .meta(ResponseMetadata.builder().statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name())
                        .build())
                .data((openHoursService.updateHours(openHours)))
                .build();
    }

    @DeleteMapping(value = "delete/{id}", produces = "application/json")
    public Response<String> delete(@PathVariable("id") Long id) {
        openHoursService.deleteHours(id);
        return Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(202)
                        .statusMessage(StatusMessage.DELETE.name())
                        .build())
                .data("Hours Delete successfully")
                .build();

    }
}
