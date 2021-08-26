package com.example.testerabbitmq.defaultSenderMq;

import com.example.testerabbitmq.model.ObjetoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueConsumer {

    Logger logger = LoggerFactory.getLogger(OrderQueueConsumer.class);

    @RabbitListener(queues = { "${queue.order.name}" } )
    public void consumer(@Payload ObjetoModel msgRecebida){
        logger.info(  String.format("Message recebida: ID=%d,USER=%s",msgRecebida.getId(),msgRecebida.getUsuario()) ) ;
    }

}
