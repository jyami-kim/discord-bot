package jyami.com.bot.command;

import jyami.com.bot.database.Reaction;
import jyami.com.bot.database.ReactionMap;
import net.dv8tion.jda.api.entities.Message;

import java.util.Optional;

/**
 * Created by jyami on 21. 2. 23.
 */
public class Search implements Command {

    @Override
    public String executeMessage(Message message) {
        String userName = getUser(message);
        Double average = ReactionMap.getAverage(userName);
        Reaction minimal = ReactionMap.getReactionMinimal(userName);
        String image = Optional.of(minimal.getImage()).orElse("");
        return "\uD83D\uDD25" + minimal.getNickName() + "의 개인 랭크" + "\uD83D\uDD25 \n" +
                "최소시간 : " + minimal.getTime() + "ms\n" +
                "평균시간 : " + average + "ms\n" +
                image;
    }

    private String getUser(Message message) {
        if (!message.getMentionedMembers().isEmpty()) {
            return message.getMentionedMembers().get(0).getUser().getName();
        }
        return message.getAuthor().getName();
    }
}

