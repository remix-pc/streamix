package com.streaming.remix.event_service.domain.service;

import com.streaming.remix.event_service.domain.event.Event;
import org.springframework.stereotype.Component;

@Component
public class RabbitRoutingKeyResolver {

    public String resolve(Event event){
        return String.format(
                "events.playback.%s.%s",
                event.getContentTypeEnum().name().toLowerCase(),
                event.getEventTypeEnum().name().toLowerCase()
        );
    }

}
