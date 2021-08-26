package com.example.testerabbitmq.defaultSenderMq;

import com.example.testerabbitmq.model.ObjetoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    Logger logger = LoggerFactory.getLogger(OrderQueueSender.class);

    static int valor=0 ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    private Queue queue ;

    public void send(String order){
        for ( int i =0 ; i<100 ; i++) {
            valor++;
            ObjetoModel objeto = new ObjetoModel(valor , order + valor );
            logger.info(  String.format("Message enviada: ID=%d,USER=%s",objeto.getId(),objeto.getUsuario()) ) ;
            rabbitTemplate.convertAndSend(queue.getName(), objeto );
        }
    }

}
