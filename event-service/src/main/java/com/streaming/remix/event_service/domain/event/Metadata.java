package com.streaming.remix.event_service.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class Metadata {

    private String device;
    private String ip;
    private Timestamp currentTimestamp;
    private String quality;

}
