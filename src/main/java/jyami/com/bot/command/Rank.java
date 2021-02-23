package jyami.com.bot.command;

import jyami.com.bot.database.Reaction;
import jyami.com.bot.database.ReactionMap;
import net.dv8tion.jda.api.entities.Message;

/**
 * Created by jyami on 21. 2. 23.
 */
public class Rank implements Command {

    @Override
    public String executeMessage(Message message) {
        Reaction reaction = Reaction.builder()
                .image(getFileUrl(message))
                .nickName(getUser(message))
                .time(getTime(message.getContentRaw()))
                .build();

        ReactionMap.add(reaction);
        return "⚡️" + reaction.getNickName() + " : " + reaction.getTime() + "ms " + "기록 등록 완료!! ⚡️";
    }

    private Integer getTime(String msg) {
        String intStr = msg.replaceAll("[^0-9]", "");
        return Integer.parseInt(intStr);
    }

    private String getFileUrl(Message message) {
        if (!message.getAttachments().isEmpty()) {
            return message.getAttachments().get(0).getUrl();
        }
        return null;
    }

    private String getUser(Message message) {
        if (!message.getMentionedMembers().isEmpty()) {
            return message.getMentionedMembers().get(0).getUser().getName();
        }
        return message.getAuthor().getName();
    }

}
