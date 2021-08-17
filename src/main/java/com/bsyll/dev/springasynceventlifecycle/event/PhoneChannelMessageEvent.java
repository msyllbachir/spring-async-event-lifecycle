package com.bsyll.dev.springasynceventlifecycle.event;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PhoneChannelMessageEvent extends GenericEvent {

    private final String phoneNumber;

    public PhoneChannelMessageEvent(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected String getFormattedMessage() {
        return String.format("This is a phone message : %s", getMessage());
    }

}
