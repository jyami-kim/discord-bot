package jyami.com.bot.command;

import jyami.com.bot.database.ReactionMap;
import net.dv8tion.jda.api.entities.Message;

/**
 * Created by jyami on 21. 2. 24.
 */
public class Remove implements Command {
    @Override
    public String executeMessage(Message message) {
        String user = getUser(message);
        Integer time = getTime(message.getContentRaw());
        ReactionMap.remove(user, time);
        return "⛔️" + user + " : " + time + " 기록 삭제 완료";
    }

    private String getUser(Message message) {
        if (!message.getMentionedMembers().isEmpty()) {
            return message.getMentionedMembers().get(0).getUser().getName();
        }
        return message.getAuthor().getName();
    }

    private Integer getTime(String msg) {
        String intStr = msg.replaceAll("[^0-9]", "");
        return Integer.parseInt(intStr);
    }
}
