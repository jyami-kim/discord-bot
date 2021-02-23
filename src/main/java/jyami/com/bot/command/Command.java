package jyami.com.bot.command;

import net.dv8tion.jda.api.entities.Message;

/**
 * Created by jyami on 21. 2. 23.
 */
public interface Command {

    String executeMessage(Message event);
}
