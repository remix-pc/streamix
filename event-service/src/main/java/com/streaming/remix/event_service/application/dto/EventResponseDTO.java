package com.streaming.remix.event_service.application.dto;

import com.streaming.remix.event_service.domain.event.Event;
import com.streaming.remix.event_service.domain.event.Metadata;

public record EventResponseDTO(
        String eventId,
        String userId,
        String profileId,
        String contentType,
        String eventType,
        long position,
        String timestamp,
        Metadata metadata
) {

    public EventResponseDTO(Event event){
        this(
                event.getEventId(),
                event.getUserId(),
                event.getProfileId(),
                event.getContentTypeEnum().name(),
                event.getEventTypeEnum().name(),
                event.getPosition(),
                event.getTimestamp().toString(),
                event.getMetadata()
        );
    }

}
