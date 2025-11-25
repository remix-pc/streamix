package com.streaming.remix.event_service.domain.enums;

public enum EventType {

    PLAY("play"),
    PAUSE("pause"),
    STOP("stop"),
    SEEK("seek"),
    LIKE("like"),
    FAVORITE("favorite"),
    ERROR("error");

    private final String type;

    EventType(String type) {
        this.type = type;
    }

}
