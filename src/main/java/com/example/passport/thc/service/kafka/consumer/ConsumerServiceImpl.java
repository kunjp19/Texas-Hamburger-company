//package com.example.passport.thc.service.kafka.consumer;
//
//import com.example.passport.thc.dto.OrdersDto;
//import com.example.passport.thc.service.OrderService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Service;
//import org.springframework.kafka.support.*;
//
//@Service
//@Slf4j
//public class ConsumerServiceImpl {
//
//    @Autowired
//    public OrderService ordersService;
//
//    /**
//     * Collects the data from producer to place the order
//     * @param offset - Provides Offset ID
//     * @param partition - Provides Partition ID
//     * @param key
//     * @param orderDto
//     */
//    @KafkaListener(containerFactory = "jsonKafkaListenerContainerFactory",
//            topics = "${kafka.topic.order.name}",
//            groupId = "${kafka.topic.order.groupId}")
//    public void consumeOrderDetails(@Header(KafkaHeaders.OFFSET)Long offset,
//                                    @Header(KafkaHeaders.RECEIVED_PARTITION_ID)Integer partition,
//                                    @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)String key,
//                                    OrdersDto ordersDto){
//        log.info("Consumed order: {} for OrderID: {} from Partition: {} at Offset: {}",key
//                ,ordersDto.getOrderId(),partition,offset);
//        ordersService.addOrder(ordersDto);
//
//
//    }
//}
