package com.example.passport.thc.repository;

import com.example.passport.thc.model.Menus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusRepository extends CrudRepository<Menus, Long> {

    Menus findByMenuId(Long menuId);

}
