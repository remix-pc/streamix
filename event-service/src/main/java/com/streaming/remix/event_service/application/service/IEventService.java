package com.streaming.remix.event_service.application.service;

import com.streaming.remix.event_service.application.dto.EventDTO;
import com.streaming.remix.event_service.application.dto.EventResponseDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface IEventService {
    EventResponseDTO execute(EventDTO eventDTO);
}
