package com.streaming.remix.analytics_service.infra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${mq.queues.playback}")
    private String playbackQueue;
    @Value("${mq.queues.user}")
    private String userQueue;
    @Value("${mq.queues.system}")
    private String systemQueue;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routing.key.playback}")
    private String routingPlayback;
    @Value("${mq.routing.key.user}")
    private String routingUser;
    @Value("${mq.routing.key.system}")
    private String routingSystem;


    @Bean
    public Queue queuePlayback() {
        return new Queue(playbackQueue, true);
    }

    @Bean
    public Queue queueUser() {
        return new Queue(userQueue, true);
    }

    @Bean
    public Queue queueSystem() {
        return new Queue(systemQueue, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding bindingPlayback(Queue queuePlayback, TopicExchange exchange) {
        return new Binding(queuePlayback.getName(), Binding.DestinationType.QUEUE, exchange.getName(), routingPlayback, null);
    }

    @Bean
    public Binding bindingUser(Queue queueUser, TopicExchange exchange) {
        return new Binding(queueUser.getName(), Binding.DestinationType.QUEUE, exchange.getName(), routingUser, null);
    }

    @Bean
    public Binding bindingSystem(Queue queueSystem, TopicExchange exchange) {
        return new Binding(queueSystem.getName(), Binding.DestinationType.QUEUE, exchange.getName(), routingSystem, null);
    }

}
