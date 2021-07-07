package com.example.passport.thc.controller;

import com.example.passport.thc.model.Locations;
import com.example.passport.thc.response.Response;
import com.example.passport.thc.response.ResponseMetadata;
import com.example.passport.thc.response.StatusMessage;
import com.example.passport.thc.service.LocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RestController
@RequestMapping(value = "/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Fetches all the locations",
            notes = "Returns all the locations")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<List<Locations>> getAllLocations() {
        return Response.<List<Locations>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((locationService.findAll()))
                .build();
    }
    @GetMapping(value = "/name/{name}", produces = "application/json")
    @ApiOperation(value = "Fetches the location by name",
            notes = "Returns location details")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<Locations> findByItemName(@PathVariable("name")String name) {
        return Response.<Locations>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((locationService.findByName(name)))
                .build();

    }
    @GetMapping(value = "/{id}",produces = "application/json")
    @ApiOperation(value = "Finds the location by Id",
            notes = "Returns location by id.")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<Locations> findById(@PathVariable("id")Long id) {
        return Response.<Locations>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((locationService.findOne(id)))
                .build();
    }
    @PostMapping(value = "/add", consumes = "application/json")
    @ApiOperation(value = "Creates a new location",
            notes = "Refer the Orders class to know the attributes")
    @ApiResponses(value={
            @ApiResponse(code=201,message = "CREATED"),
            @ApiResponse(code=500,message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<String> addLocation(@RequestBody Locations location){
        return locationService.addLocation(location) == Boolean.TRUE ? Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(201)
                        .statusMessage(StatusMessage.CREATED.name())
                        .build())
                .data("Location added successfully")
                .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder().statusCode(500)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                                .build())
                        .data("Failed to add location")
                        .build();
    }

    @PutMapping(value ="/update",produces = "application/json",consumes = "application/json")
    @ApiOperation(value = "Changes the order based on user input",
            notes = "Changes location details by given object")
    @ApiResponses(value={
            @ApiResponse(code=500,message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<Locations> update(@RequestBody Locations location){
        return Response.<Locations>builder()
                .meta(ResponseMetadata.builder().statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name())
                        .build())
                .data((locationService.updateLocation(location)))
                .build();
    }
    @DeleteMapping(value = "delete/{name}", produces = "application/json")
    @ApiOperation(value = "delete the location by name",
            notes = "User can delete the location by passing the location name")
    @ApiResponses(value={
            @ApiResponse(code=500,message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<Locations> delete(@PathVariable("name")String name) {
        return Response.<Locations>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.DELETE.name())
                        .build()).data((locationService.deleteByName(name)))
                .build();

    }

    @GetMapping(produces = "application/json",value = "/pagelimit")
    @ApiOperation(value = "Fetches all the location by limiting 15 location per page by default",
            notes = "Returns 10 location in one page and can be changed to other values as well")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<List<Locations>> getAllOrdersByPageLimit(@RequestParam(defaultValue = "0")Integer pageNo,
                                                          @RequestParam(defaultValue = "10")Integer pageSize){
        return Response.<List<Locations>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((List<Locations>) locationService.findAllByPageLimit(pageNo,pageSize))
                .build();
    }

    @GetMapping(produces = "application/json",value = "/sortby")
    @ApiOperation(value = "Sorts the value according to the value selected by order name",
            notes = "Provide the value which you want to sort")
    @ApiResponses(value={
            @ApiResponse(code=500,message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<List<Locations>> getSortedValues(@RequestParam(defaultValue = "0")Integer pageNo,
                                                  @RequestParam(defaultValue = "15")Integer pageSize,
                                                  @RequestParam(defaultValue = "name")String sortBy){
        return Response.<List<Locations>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((locationService.sortByValues(pageNo,pageSize,sortBy)))
                .build();
    }


}
