package com.bsyll.dev.springasynceventlifecycle.event;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChatChannelMessageEvent extends GenericEvent {

    private final String chatId;

    public ChatChannelMessageEvent(String message, String chatId) {
        super(message);
        this.chatId = chatId;
    }

    @Override
    protected String getFormattedMessage() {
        return String.format("This is a chat message : %s", getMessage());
    }


}
