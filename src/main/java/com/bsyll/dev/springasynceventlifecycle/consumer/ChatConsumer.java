package com.bsyll.dev.springasynceventlifecycle.consumer;

import com.bsyll.dev.springasynceventlifecycle.event.ChatChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.event.MailChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.metadatas.EventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@EventConsumer
@Slf4j
public class ChatConsumer {

    @EventListener(classes = ChatChannelMessageEvent.class)
    public void consume(ChatChannelMessageEvent event) {
        log.debug("Consuming mail event : {}", event);
        log.info("Sending chat message to {} for event id {}", event.getChatId(), event.getUuid());    }

}
