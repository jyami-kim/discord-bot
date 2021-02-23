package jyami.com.bot.command;

/**
 * Created by jyami on 21. 2. 23.
 */
public class CommandMapper {

    public static Command getCommand(String command) {
        switch (command) {
            case "list":
                return new List();
            case "ping":
                return new Ping();
            case "rank":
                return new Rank();
            case "search":
                return new Search();
            case "remove":
                return new Remove();
            default:
                return new Help();
        }
    }
}
