package jyami.com.bot.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * Created by jyami on 21. 2. 23.
 */
@Getter
@AllArgsConstructor
@Builder
public class Reaction {
    private String nickName;
    private String image;
    private Integer time;
    private final LocalDate date = LocalDate.now();

    public static Reaction emptyReaction() {
        return new Reaction("","",0);
    }
}
