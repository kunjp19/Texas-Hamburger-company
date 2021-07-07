package com.example.passport.thc.service;

import com.example.passport.thc.exceptions.MenuServiceException;
import com.example.passport.thc.model.Menus;
import com.example.passport.thc.repository.MenusRepository;
import com.example.passport.thc.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenusRepository menusRepository;

    @Transactional
    public Boolean addMenu(Menus menu) {
        menusRepository.save(menu);
        return true;

    }

    @Override
    public List<Menus> findAll(){
//        return (List<Menus>) menusRepository.findAll();
        return (List<Menus>) Optional.ofNullable(menusRepository.findAll())
                .orElseThrow(() -> new MenuServiceException("No menu found in database"));

    }

    @Override
    public Menus findById(Long id){
//        return menusRepository.findByMenuId(id);
        return Optional.ofNullable(menusRepository.findByMenuId(id))
                .orElseThrow(() -> new MenuServiceException("No Menu found with id"));
    }


    @Override
    @Transactional
    public Menus updateMenu(Menus menus) {
            //return menusRepository.save(menus);
            return Optional.ofNullable(menusRepository.save(menus))
                    .orElseThrow(() -> new MenuServiceException("No menu found in database to update"));
    }

    @Override
    @Transactional
    public Response<String> deleteMenu(Long menuId) {
        menusRepository.deleteById(menuId);
        return null;
    }

}


