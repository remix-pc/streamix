package com.streaming.remix.event_service.domain.enums;

public enum ContentType {
    MOVIE("movie"),
    EPISODE("episode"),;

    private final String type;

    ContentType(String type) {
        this.type = type;
    }

}
