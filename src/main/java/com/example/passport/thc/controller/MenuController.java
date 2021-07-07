package com.example.passport.thc.controller;



import com.example.passport.thc.model.Menus;
import com.example.passport.thc.response.Response;
import com.example.passport.thc.response.ResponseMetadata;
import com.example.passport.thc.response.StatusMessage;
import com.example.passport.thc.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@Controller
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping(produces = "application/json")
    public Response<List<Menus>> getAllMenus() {
        return Response.<List<Menus>>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((menuService.findAll()))
                .build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Response<Menus> findById(@PathVariable("id") Long id) {
        return Response.<Menus>builder()
                .meta(ResponseMetadata.builder().statusCode(302)
                        .statusMessage(StatusMessage.FOUND.name())
                        .build()).data((menuService.findById(id)))
                .build();

    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Response<String> addMenu(@RequestBody Menus menus){
        return menuService.addMenu(menus) == Boolean.TRUE ? Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(201)
                        .statusMessage(StatusMessage.CREATED.name())
                        .build())
                .data("Menu added successfully")
                .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetadata.builder().statusCode(500)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                                .build())
                        .data("Failed to add menu")
                        .build();
    }

    @PutMapping(value ="/update",produces = "application/json",consumes = "application/json")
    public Response<Menus> update(@RequestBody Menus menu){
        return Response.<Menus>builder()
                .meta(ResponseMetadata.builder().statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name())
                        .build())
                .data((menuService.updateMenu(menu)))
                .build();
    }

    @DeleteMapping(value = "delete/{id}", produces = "application/json")
    public Response<String> delete(@PathVariable("id")Long id) {
        menuService.deleteMenu(id);
        return Response.<String>builder()
                .meta(ResponseMetadata.builder().statusCode(202)
                        .statusMessage(StatusMessage.DELETE.name())
                        .build())
                .data("Menu Delete successfully")
                .build();

    }
}