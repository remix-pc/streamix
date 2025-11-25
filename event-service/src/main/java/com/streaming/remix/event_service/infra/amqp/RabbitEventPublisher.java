package com.streaming.remix.event_service.infra.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.streaming.remix.event_service.domain.event.Event;
import com.streaming.remix.event_service.domain.repository.IEventPublisher;
import com.streaming.remix.event_service.domain.service.RabbitRoutingKeyResolver;
import com.streaming.remix.event_service.infra.config.RabbitProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitEventPublisher implements IEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitRoutingKeyResolver routingKeyResolver;
    private final RabbitProperties rabbitProperties;

    @Override
    public void publish(Event event) {

        try{

            String routingKey = routingKeyResolver.resolve(event);
            var json = convertIntoJson(event);

            rabbitTemplate.convertAndSend(
                    rabbitProperties.getExchange(),
                    routingKey,
                    json
            );

            log.info(
                    "Published event to exchange '{}' with routing key '{}'",
                    rabbitProperties.getExchange(),
                    routingKey
            );
        }catch (Exception e){
            log.error(
                    "Failed to publish event to exchange '{}' - Error: {}",
                    rabbitProperties.getExchange(),
                    e.getMessage()
            );
        }

    }


    private String convertIntoJson(Event event) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json =  mapper.writeValueAsString(event);
        return json;
    }



}
