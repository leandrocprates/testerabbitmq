package com.example.testerabbitmq.directSenderMq;

import com.example.testerabbitmq.defaultSenderMq.OrderQueueSender;
import com.example.testerabbitmq.model.ObjetoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    Logger logger = LoggerFactory.getLogger(OrderQueueSender.class);

    static int valor=0 ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;


    public void send( String exchange, String routingkey,String mensagem) {
        for (int i=0;i<100;i++ ){
            valor++;
            ObjetoModel objeto = new ObjetoModel(valor , mensagem + valor );
            logger.info(  String.format("Message enviada: ID=%d,USER=%s",objeto.getId(),objeto.getUsuario()) ) ;
            rabbitTemplate.convertAndSend(exchange,routingkey,objeto);
        }
    }

}
