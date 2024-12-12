package com.maksemses.translatebot.Bot;

import com.maksemses.translatebot.Listeners.MessageReceived;
import com.maksemses.translatebot.Listeners.ReactionListener;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bot{
    @Value("${myapp.TOKEN}")
    private String TOKEN;
    @Autowired
    public Bot(ReactionListener reactionListener, MessageReceived messageReceived) {
        try {
            JDABuilder.createDefault("APIkey") // Замените на ваш токен
                    .addEventListeners(reactionListener)
                    .addEventListeners(messageReceived)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
