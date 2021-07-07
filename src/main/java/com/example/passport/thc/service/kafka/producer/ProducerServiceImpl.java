//package com.example.passport.thc.service.kafka.producer;
//
//import com.example.passport.thc.dto.OrdersDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//import java.util.UUID;
//
//@Service
//@Slf4j
//public class ProducerServiceImpl {
//    private final KafkaTemplate<String, OrdersDto> orderDtokafkaTemplate;
//
//    @Value("${kafka.topic.order.name}")
//    private String JSON_TOPIC;
//
//    public ProducerServiceImpl(KafkaTemplate<String, OrdersDto> orderDtokafkaTemplate) {
//        this.orderDtokafkaTemplate = orderDtokafkaTemplate;
//    }
//
//    public void sendOrderData(OrdersDto ordersDto){
//        log.info(String.format("$$$$ => Producing message: %s",ordersDto));
//
//        orderDtokafkaTemplate.executeInTransaction(t ->{
//            ListenableFuture<SendResult<String,OrdersDto>> future =  t .send(JSON_TOPIC,
//                    ordersDto.getOrderId() + UUID.randomUUID().toString(),ordersDto);
//            future.addCallback(new ListenableFutureCallback<SendResult<String, OrdersDto>>() {
//                @Override
//                public void onFailure(Throwable throwable) {
//                    log.info("Unable to produce message [ {} ] due to: {}",ordersDto,throwable.getMessage());
//                }
//
//                @Override
//                public void onSuccess(SendResult<String, OrdersDto> stringOrderDtoSendResult) {
//                    log.info("Sent Message [ {} ] with offset=[ {} ]",ordersDto,
//                            stringOrderDtoSendResult.getRecordMetadata().offset());
//                }
//            });
//            return true;
//        });
//    }
//}
