package com.bsyll.dev.springasynceventlifecycle.consumer;

import com.bsyll.dev.springasynceventlifecycle.event.PhoneChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.metadatas.EventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@EventConsumer
@Slf4j
public class PhoneMessageConsumer {

        @EventListener(classes = PhoneChannelMessageEvent.class)
    public void consume(PhoneChannelMessageEvent event) {
        log.debug("Consuming phone message event : {}", event);
        log.info("Sending message to phone number {} for event id {}", event.getPhoneNumber(), event.getUuid());
    }

}
