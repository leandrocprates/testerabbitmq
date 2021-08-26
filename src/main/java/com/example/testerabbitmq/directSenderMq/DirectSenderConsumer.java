package com.example.testerabbitmq.directSenderMq;

import com.example.testerabbitmq.model.ObjetoModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class DirectSenderConsumer {

    @RabbitListener(queues = "admin")
    public void adminConsumer(@Payload ObjetoModel msgRecebida){
        System.out.println("Direct Message [Admin]: " + msgRecebida.getUsuario());
    }

    @RabbitListener(queues = "finance")
    public void financeConsumer(@Payload ObjetoModel msgRecebida){
        System.out.println("Direct Message [Finance]: " + msgRecebida.getUsuario());
    }

    @RabbitListener(queues = "marketing")
    public void marketingConsumer(@Payload ObjetoModel msgRecebida){
        System.out.println("Direct Message [Marketing]: " + msgRecebida.getUsuario());
    }


}
