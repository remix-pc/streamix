package com.streaming.remix.event_service.domain.repository;

import com.streaming.remix.event_service.domain.event.Event;

public interface IEventPublisher {

    void publish(Event event);
}
