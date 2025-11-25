package com.streaming.remix.event_service.application.mapper;

import com.streaming.remix.event_service.application.dto.EventDTO;
import com.streaming.remix.event_service.application.dto.EventResponseDTO;
import com.streaming.remix.event_service.domain.event.Event;

public class EventMapper {

    public static Event toEntity(EventDTO eventDTO) {
        return new Event(
                eventDTO.eventId(),
                eventDTO.userId(),
                eventDTO.profileId(),
                eventDTO.eventType(),
                eventDTO.contentType(),
                eventDTO.position(),
                eventDTO.timestamp(),
                eventDTO.metadata()
        );
    }

    public static EventResponseDTO toDTO(Event event) {
        return new EventResponseDTO(event);
    }

}
