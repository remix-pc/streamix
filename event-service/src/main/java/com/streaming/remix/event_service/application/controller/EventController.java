package com.streaming.remix.event_service.application.controller;

import com.streaming.remix.event_service.application.dto.EventDTO;
import com.streaming.remix.event_service.application.dto.EventResponseDTO;
import com.streaming.remix.event_service.application.service.IEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final IEventService eventService;

    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping
    public ResponseEntity<EventResponseDTO> publishEvent(@RequestBody EventDTO event){
        EventResponseDTO responseDTO = eventService.execute(event);
        return ResponseEntity.ok(responseDTO);
    }

}
