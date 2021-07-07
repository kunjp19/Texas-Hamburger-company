package com.example.passport.thc.service;

import com.example.passport.thc.dto.OrdersDto;
import com.example.passport.thc.model.OpenHours;
import com.example.passport.thc.model.Orders;
import com.example.passport.thc.response.Response;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();

    Orders findById(Long id);

    Boolean addOrder(Orders orders);

    Orders updateOrder(Orders order);

    Response<String> deleteOrder(Long id);

}
