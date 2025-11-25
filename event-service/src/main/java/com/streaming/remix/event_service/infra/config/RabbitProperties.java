package com.streaming.remix.event_service.infra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mq")
@Data
public class RabbitProperties {

    private String exchange;
    private String queuesPlayback;
    private String queuesUser;
    private String queuesSystem;
}
