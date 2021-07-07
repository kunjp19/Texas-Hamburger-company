package com.example.passport.thc.service;

import com.example.passport.thc.model.Menus;
import com.example.passport.thc.response.Response;

import java.util.List;

public interface MenuService {

    Boolean addMenu(Menus menus);

    List<Menus> findAll();

    Response<String> deleteMenu(Long id);

    Menus updateMenu(Menus menu);

    Menus findById(Long id);
}
