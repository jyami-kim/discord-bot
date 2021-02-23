package jyami.com.bot;

import jyami.com.bot.command.Command;
import jyami.com.bot.command.CommandMapper;
import jyami.com.bot.command.Help;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jyami on 21. 2. 22.
 */
public class ReactBot extends ListenerAdapter {
    public static String START_COMMAND = ".react";
    public static String BOT_NAME = "반속봇";


    public static void main(String[] args) throws Exception {
        String token = new PropertiesReader().getPropertyToken();
        JDA jda = JDABuilder.createDefault(token)
                .build();
        jda.addEventListener(new ReactBot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();

        List<Member> mentionedMembers = event.getMessage().getMentionedMembers();
        String message = event.getMessage().getContentDisplay();
        if (message.startsWith(START_COMMAND)) {
            String[] s = message.split(" ");
            if (s.length > 1) {
                Command command = CommandMapper.getCommand(s[1]);
                String returnMessage = command.executeMessage(event.getMessage());
                System.out.println(LocalDateTime.now() + " : " + message);
                channel.sendMessage(returnMessage).queue();
            }
        } else if (!mentionedMembers.isEmpty() && BOT_NAME.equals(mentionedMembers.get(0).getEffectiveName())) {
            String returnMessage = new Help().executeMessage(event.getMessage());
            System.out.println(LocalDateTime.now() + " : " + message);
            channel.sendMessage(returnMessage).queue();
        }
    }

}

