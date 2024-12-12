package com.maksemses.translatebot.Listeners;

import com.maksemses.translatebot.Services.TranslatorDiscord;
import com.maksemses.translatebot.configs.TimerCFG;
import com.maksemses.translatebot.enums.FLAG;
import com.maksemses.translatebot.enums.LANG;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@Component
public class ReactionListener extends ListenerAdapter {
    @Autowired
    TranslatorDiscord translator;
    @Autowired
    TimerCFG timerCFG;
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getUser().isBot()) {
            return;
        }
        Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();
        String reaction = event.getReaction().getReactionEmote().getName();
        String content = message.getContentRaw();

        int messageTimeSeconds = timerCFG.getMessageTimeSeconds();
        if (reaction.equals(FLAG.us_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.us);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.ru_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.ru);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.de_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.de);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.cn_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.cn);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.fr_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.fr);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.vn_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.vn);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
        if (event.getReaction().getReactionEmote().getName().equals(FLAG.es_flag.getFlag())) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);

            // Получаем URL аватара пользователя
            String avatarUrl = event.getUser().getAvatarUrl();
            if (avatarUrl == null) {
                // Если аватар отсутствует, используем стандартный аватар
                avatarUrl = "https://cdn.discordapp.com/embed/avatars/0.png"; // Стандартный аватар
            }

            // Устанавливаем футер с проверенным аватаром
            embed.setFooter("Requested by " + event.getUser().getName(), avatarUrl);

            try {
                // Переводим сообщение, если это необходимо
                content = translator.TranslateMessageTo(content, LANG.es);
            } catch (Exception e) {
                e.printStackTrace();  // Логируем ошибку, если она возникла
                event.getChannel().sendMessage("Ошибка при переводе: " + e.getMessage()).queue(); // Отправим ошибку в чат
                return;
            }

            // Создаем встроенное сообщение с переводом
            embed.setDescription("**" + content + "**");  // Текст перевода

            // Отправляем ответ на сообщение, на которое была добавлена реакция
            message.replyEmbeds(embed.build()).queue(replyMessage -> {
                // Удаляем ответ через 2 минуты
                replyMessage.delete().queueAfter(messageTimeSeconds, TimeUnit.SECONDS);
            });
            event.getReaction().removeReaction(event.getUser()).queue();
        }
    }
}
