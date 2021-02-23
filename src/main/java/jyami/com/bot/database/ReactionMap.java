package jyami.com.bot.database;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jyami on 21. 2. 23.
 */
public class ReactionMap {
    private static Set<Reaction> datas = new TreeSet<>(Comparator.comparingInt(Reaction::getTime));

    private ReactionMap() {
    }

    public static void add(Reaction reaction) {
        datas.add(reaction);
    }

    public static void remove(String user, Integer time) {
        datas.stream()
                .filter(x -> x.getNickName().equals(user))
                .filter(x -> x.getTime().equals(time))
                .findFirst()
                .ifPresent(datas::remove);
    }

    public static List<Reaction> getRankList() {
        return datas.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getAverageList() {
        Map<String, List<Reaction>> collect = datas.stream()
                .collect(Collectors.groupingBy(Reaction::getNickName));
        return collect.values().stream()
                .collect(Collectors.toMap(x -> x.get(0).getNickName(),
                        x -> x.stream().map(Reaction::getTime).collect(Collectors.averagingInt(y -> y))
                ));
    }

    public static Reaction getReactionMinimal(String name) {
        return datas.stream()
                .filter(x -> x.getNickName().equals(name))
                .findFirst()
                .orElseGet(Reaction::emptyReaction);
    }

    public static Double getAverage(String name) {
        return datas.stream()
                .filter(x -> x.getNickName().equals(name))
                .collect(Collectors.averagingInt(Reaction::getTime));
    }

}
