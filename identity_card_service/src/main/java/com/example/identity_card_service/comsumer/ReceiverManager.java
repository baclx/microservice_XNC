//package com.example.identity_card_service.comsumer;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReceiverManager  implements RabbitListenerConfigurer {
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @RabbitListener(queues = "identity-queue")
//    public void receiveMessage(String message) throws JsonProcessingException {
//        System.out.println("Identity receive message : "+message);
//
////        OrderEvent orderEvent = mapper.readValue(message, OrderEvent.class);
////        System.out.println("update order status, orderEvent :"+ orderEvent.toString());
////        orderService.updateStatusPlaceOrder(orderEvent.getOrderRequest().getOrderId(), orderEvent.getOrderStatus(),orderEvent.getOrderRequest().getPaymentStatus(), orderEvent.getOrderRequest().getInventoryStatus());
//    }
//
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
//
//    }
//}
//
