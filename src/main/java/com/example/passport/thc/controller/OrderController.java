package com.example.passport.thc.controller;

import com.example.passport.thc.dto.OrdersDto;
import com.example.passport.thc.model.OpenHours;
import com.example.passport.thc.model.Orders;
import com.example.passport.thc.response.Response;
import com.example.passport.thc.response.ResponseMetadata;
import com.example.passport.thc.response.StatusMessage;
import com.example.passport.thc.service.OpenHoursService;
import com.example.passport.thc.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Fetches all the orders",
            notes = "Returns all the orders")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public Response<List<Orders>> getAllOrders() {
        return Response.<List<Orders>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((orderService.findAll()))
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Response<Orders> findById(@PathVariable("id") Long id) {
        return Response.<Orders>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((orderService.findById(id)))
                .build();

    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Response<String> addOrder(@RequestBody Orders order) {
        return orderService.addOrder(order) == Boolean.TRUE ? Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(201)
                        .statusMessage(StatusMessage.CREATED.name())
                        .build())
                .data("Order added successfully")
                .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder().statusCode(500)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                                .build())
                        .data("Failed to add Order")
                        .build();
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public Response<Orders> update(@RequestBody Orders order) {
        return Response.<Orders>builder()
                .meta(ResponseMetadata.builder().statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name())
                        .build())
                .data((orderService.updateOrder(order)))
                .build();
    }

    @DeleteMapping(value = "delete/{id}", produces = "application/json")
    public Response<String> delete(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(202)
                        .statusMessage(StatusMessage.DELETE.name())
                        .build())
                .data("Order Delete successfully")
                .build();

    }
}

