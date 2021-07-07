package com.example.passport.thc.repository;

import com.example.passport.thc.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>   {

    Orders findByOrderId(Long id);
}
