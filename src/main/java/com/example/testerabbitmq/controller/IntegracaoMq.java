package com.example.testerabbitmq.controller;

import com.example.testerabbitmq.defaultSenderMq.OrderQueueSender;
import com.example.testerabbitmq.directSenderMq.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegracaoMq {

    @Autowired
    OrderQueueSender orderQueueSender ;

    @Autowired
    DirectSender directSender ;

    @PostMapping(value = "/default/mq")
    public void enviarMensagemMQ(@RequestBody String message){
        orderQueueSender.send(message);
    }


    @PostMapping(value = "/direct/mq")
    public void enviarDirectMensagemMQ(@RequestParam String exchange,
                                       @RequestParam String routingkey,
                                       @RequestParam String mensagem
                                        ){
        directSender.send(exchange , routingkey ,mensagem);
    }


}
