package jyami.com.bot;

import jyami.com.bot.command.Command;
import jyami.com.bot.command.CommandMapper;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDateTime;

/**
 * Created by jyami on 21. 2. 22.
 */
public class ReactBot extends ListenerAdapter {
    public static String START_COMMAND = ".react";


    public static void main(String[] args) throws Exception {
        String token = new PropertiesReader().getPropertyToken();
        JDA jda = JDABuilder.createDefault(token)
                .build();
        jda.addEventListener(new ReactBot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();

        String message = event.getMessage().getContentRaw();
        if (message.startsWith(START_COMMAND)) {
            String[] s = message.split(" ");
            if (s.length > 1) {
                Command command = CommandMapper.getCommand(s[1]);
                String returnMessage = command.executeMessage(event.getMessage());
                System.out.println(LocalDateTime.now() + " : " + message);
                channel.sendMessage(returnMessage).queue();
            }
        }
    }

}

