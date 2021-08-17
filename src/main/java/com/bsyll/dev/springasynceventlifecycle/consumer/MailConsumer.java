package com.bsyll.dev.springasynceventlifecycle.consumer;

import com.bsyll.dev.springasynceventlifecycle.event.MailChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.metadatas.EventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@EventConsumer
@Slf4j
public class MailConsumer {

    @EventListener(classes = MailChannelMessageEvent.class)
    public void consume(MailChannelMessageEvent event) {
        log.debug("Consuming mail event : {}", event);
        log.info("Sending mail to {} for event id {}", event.getMail(), event.getUuid());    }

}
