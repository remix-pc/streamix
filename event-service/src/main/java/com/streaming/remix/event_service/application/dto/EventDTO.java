package com.streaming.remix.event_service.application.dto;

import com.streaming.remix.event_service.domain.enums.ContentType;
import com.streaming.remix.event_service.domain.enums.EventType;
import com.streaming.remix.event_service.domain.event.Metadata;

import java.sql.Timestamp;

public record EventDTO(
        String eventId,
        String userId,
        String profileId,
        ContentType contentType,
        EventType eventType,
        long position,
        Timestamp timestamp,
        Metadata metadata
) {
}
