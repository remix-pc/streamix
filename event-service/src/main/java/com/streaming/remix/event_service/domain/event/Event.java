package com.streaming.remix.event_service.domain.event;

import com.streaming.remix.event_service.domain.enums.ContentType;
import com.streaming.remix.event_service.domain.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Event {

    private String eventId;
    private String userId;
    private String profileId;
    private EventType eventTypeEnum;
    private ContentType contentTypeEnum;
    private long position;
    private Timestamp timestamp;
    private Metadata metadata;

}


