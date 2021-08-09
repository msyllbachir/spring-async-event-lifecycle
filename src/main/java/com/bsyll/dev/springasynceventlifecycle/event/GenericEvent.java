package com.bsyll.dev.springasynceventlifecycle.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@ToString
@Getter
public class GenericEvent {
    private final UUID uuid;
    private final String message;
    private final String type;
    private final LocalDateTime dateTime;

    public GenericEvent(String message, String type) {
        this.message = message;
        this.type = type;
        this.dateTime = LocalDateTime.now();
        this.uuid = UUID.randomUUID();
    }

}
