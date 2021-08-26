package com.example.testerabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    public Queue queueAdmin(){
        return new Queue("admin",true);
    }

    @Bean
    public Queue queueFinance(){
        return new Queue("finance",true);
    }

    @Bean
    public Queue queueMarketing(){
        return new Queue("marketing",true);
    }

    @Bean
    public DirectExchange getDirect(){
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Binding adminBinding(Queue queueAdmin , DirectExchange directExchange  ) {
        return BindingBuilder.bind(queueAdmin).to(directExchange).with("admin");
    }

    @Bean
    public Binding financeBinding(Queue queueFinance , DirectExchange directExchange  ) {
        return BindingBuilder.bind(queueFinance).to(directExchange).with("finance");
    }

    @Bean
    public Binding marketingBinding(Queue queueMarketing , DirectExchange directExchange  ) {
        return BindingBuilder.bind(queueMarketing).to(directExchange).with("marketing");
    }


}
