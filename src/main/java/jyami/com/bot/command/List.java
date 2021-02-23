package jyami.com.bot.command;

import jyami.com.bot.database.Reaction;
import jyami.com.bot.database.ReactionMap;
import net.dv8tion.jda.api.entities.Message;

import java.util.Map;

/**
 * Created by jyami on 21. 2. 23.
 */
public class List implements Command {

    @Override
    public String executeMessage(Message event) {

        StringBuilder sb = new StringBuilder("====놀이터 반속대결 랭커====\n");
        java.util.List<Reaction> reaction = ReactionMap.getRankList();
        for (int i = 0; i < reaction.size(); i++) {
            sb.append("- ");
            if (i == 0) {
                sb.append("\uD83E\uDD47");
            } else if (i == 1) {
                sb.append("\uD83E\uDD48");
            } else if (i == 2) {
                sb.append("\uD83E\uDD49");
            }
            sb.append((i + 1) + "등 : " + reaction.get(i).getNickName() + " - " + reaction.get(i).getTime() + "ms\n");
        }

        sb.append("\n ==== 평균시간 집계 ====\n");
        Map<String, Double> average = ReactionMap.getAverageList();
        for (Map.Entry<String, Double> map : average.entrySet()) {
            sb.append("- " + map.getKey() + " : " + map.getValue() + "ms\n");
        }

        return sb.toString();
    }
}
