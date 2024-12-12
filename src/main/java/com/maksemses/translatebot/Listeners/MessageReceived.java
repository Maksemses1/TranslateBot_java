package com.maksemses.translatebot.Listeners;

import com.maksemses.translatebot.configs.TimerCFG;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MessageReceived extends ListenerAdapter {
    @Autowired
    TimerCFG timerCFG;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        List<String> allowedRoleIds = Arrays.asList(
                "1311316499671158897", // ID роли R:-(пример)
                "1311306069959639040",  // ID роли 👑R5(пример)
                "1311316404082835477"
        );
        System.out.println(event.getMember().getRoles());
        Message messageClear = event.getMessage();
        String content = messageClear.getContentRaw();
        // Логируем полученное сообщение
        System.out.println("Received message: " + content);
        TextChannel channel = event.getTextChannel();


        // Проверяем, начинается ли сообщение с "!translate"
        if (content.startsWith("!setMessageTimer ")) {
            boolean hasRequiredRole = event.getMember().getRoles().stream()
                    .anyMatch(role -> allowedRoleIds.contains(role.getId()));
            if (!hasRequiredRole) {
                // Если у пользователя нет нужной роли, отправляем сообщение
                event.getChannel().sendMessage("У вас недостаточно прав для выполнения этой команды.").queue();
                return;
            }
            try {
                // Получаем число (время в секундах) из команды
                String[] commandParts = content.split(" ");
                int timerInSeconds = Integer.parseInt(commandParts[1]);

                // Устанавливаем значение таймера с помощью TimerCFG.SetTimer
                timerCFG.setMessageTimeSeconds(timerInSeconds); // Используем вашу функцию для установки таймера

                // Отправляем сообщение в канал, информируя пользователя
                Message message = channel.sendMessage("Таймер установлен на " + timerInSeconds + " секунд.").complete();

                // Устанавливаем таймер на удаление сообщения через установленное время
                message.delete().queueAfter(timerInSeconds, java.util.concurrent.TimeUnit.SECONDS);

            } catch (NumberFormatException e) {
                // Если введено не число
                channel.sendMessage("Ошибка: укажите число для времени таймера.").queue();
            } catch (ArrayIndexOutOfBoundsException e) {
                // Если команда указана некорректно
                channel.sendMessage("Ошибка: укажите количество секунд после команды. Пример: !setMessageTimer 30").queue();
            }

        }
    }
}
