package com.example.passport.thc.service;

import com.example.passport.thc.dto.OrdersDto;
import com.example.passport.thc.exceptions.OrderServiceException;
import com.example.passport.thc.model.Locations;
import com.example.passport.thc.model.Orders;
import com.example.passport.thc.repository.OrdersRepository;
import com.example.passport.thc.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> findAll() {
//        return (List<Orders>) ordersRepository.findAll();
            return (List<Orders>) Optional.ofNullable(ordersRepository.findAll())
                    .orElseThrow(() -> new OrderServiceException("No Order found in databse"));
    }

    @Override
    public Orders findById(Long id) {
//        return ordersRepository.findByOrderId(id);
        return Optional.ofNullable(ordersRepository.findByOrderId(id))
                .orElseThrow(() -> new OrderServiceException("No Order found with id"));

    }

    @Transactional
    @Override
    public Boolean addOrder(Orders orders) {
//        List<Orders> existing = (List<Orders>) ordersRepository.findByOrderId(orders.getOrderId());
//        String itemName = "";
//        String orderStatus = "";
//        Locations loc = new Locations();
//        double pc = 0;
//
//        Orders new_order = null;
//
//        BeanUtils.copyProperties(orders.getItemName(), itemName );
//        BeanUtils.copyProperties(orders.getOrderStatus(), orderStatus);
//        BeanUtils.copyProperties(orders.getLocations(), loc);
//        BeanUtils.copyProperties(orders.getPrice(),pc);
//
//        new_order = new Orders(itemName,pc,orderStatus,loc);
//        ordersRepository.save(new_order);
//
//
//        if (!existing.isEmpty()) {
//            return false;
//        }
        ordersRepository.save(orders);
        return true;
    }

    @Transactional
    @Override
    public Orders updateOrder(Orders order) {
//        return ordersRepository.save(order);
        return Optional.ofNullable(ordersRepository.save(order))
                .orElseThrow(() -> new OrderServiceException("No Order found in database"));
    }

    @Transactional
    @Override
    public Response<String> deleteOrder(Long id) {
        ordersRepository.deleteById(id);
        return null;
    }
}
