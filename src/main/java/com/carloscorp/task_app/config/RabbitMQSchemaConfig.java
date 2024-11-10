package com.carloscorp.task_app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class RabbitMQSchemaConfig {

    @Bean
    public Declarables rabbitMQSchema(){
        Map<String,Object> qTaskArguments = Map.of("x-dead-letter-exchange","x.task.dlx",
                "x-message-ttl",5000);

        return new Declarables(
                new FanoutExchange("x.task", true, false),
                new FanoutExchange("x.task.dlx", true, false),
                new Queue("q.task",true,false,false, qTaskArguments),
                new Queue("q.task.dlx"),
                new Binding("q.task", Binding.DestinationType.QUEUE, "x.task", "", null),
                new Binding("q.task.dlx", Binding.DestinationType.QUEUE, "x.task.dlx", "", null)
                );
    }
}
