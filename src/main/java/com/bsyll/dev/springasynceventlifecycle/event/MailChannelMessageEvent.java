package com.bsyll.dev.springasynceventlifecycle.event;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MailChannelMessageEvent extends GenericEvent {

    private final String mail;

    public MailChannelMessageEvent(String message, String mail) {
        super(message);
        this.mail = mail;
    }

    @Override
    protected String getFormattedMessage() {
        return String.format("This is a mail : %s", getMessage());
    }


}
