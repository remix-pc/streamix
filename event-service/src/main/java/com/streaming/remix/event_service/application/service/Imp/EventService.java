package com.streaming.remix.event_service.application.service.Imp;

import com.streaming.remix.event_service.application.dto.EventDTO;
import com.streaming.remix.event_service.application.dto.EventResponseDTO;
import com.streaming.remix.event_service.application.mapper.EventMapper;
import com.streaming.remix.event_service.application.service.IEventService;
import com.streaming.remix.event_service.domain.event.Event;
import com.streaming.remix.event_service.domain.repository.IEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {

    private final IEventPublisher eventPublisher;

    public EventService(IEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public EventResponseDTO execute(EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        eventPublisher.publish(event);
        return new EventResponseDTO(event);
    }
}
