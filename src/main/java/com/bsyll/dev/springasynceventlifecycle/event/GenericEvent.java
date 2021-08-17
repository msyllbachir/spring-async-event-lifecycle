package com.bsyll.dev.springasynceventlifecycle.event;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
public abstract class GenericEvent {
    private final UUID uuid;
    private final String message;
    private final LocalDateTime dateTime;

    public GenericEvent(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.uuid = UUID.randomUUID();
    }

    protected abstract String getFormattedMessage();
}
