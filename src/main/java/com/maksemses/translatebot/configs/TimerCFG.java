package com.maksemses.translatebot.configs;

import org.springframework.stereotype.Component;

@Component
public class TimerCFG {
    private int messageTimeSeconds = 120;

    public int getMessageTimeSeconds() {
        return this.messageTimeSeconds;
    }

    public void setMessageTimeSeconds(int messageTime) {
        this.messageTimeSeconds = messageTime;
    }
}
