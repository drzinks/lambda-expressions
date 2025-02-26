package com.drzinks.recruitment_tasks.visit_count_per_user;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VisitCounter {

    public static void main(String[] args) {

        System.out.println(count(null).size()); //0
        Optional<Long> tempEmpty = Optional.empty();
        Optional<Long> temp0 = Optional.of(0L);
        Optional<Long> temp1 = Optional.of(1L);
        Map<String, UserStats> test12one = Map.of("12", new UserStats(temp1));
        Map<String, UserStats> test10one = Map.of("10", new UserStats(temp1));
        Map<String, UserStats> test10zero = Map.of("10", new UserStats(temp0));
        Map<String, UserStats> test10empty = Map.of("10", new UserStats(tempEmpty));
        Map<String, UserStats> test12empty = Map.of("12", new UserStats(tempEmpty));
        Map<String, UserStats> test12zero = Map.of("12", new UserStats(temp0));

        Map<String, UserStats> [] visits = new Map[] {
                test10one, test10one, test10one,
                test12one, test12one,
                test10zero, test10empty,
                test12zero, test12empty, test12empty,
                test12one,test12one,test12one,test12one,
                test10one,test10one
        };

        Stream.of(count(visits))
                .map(Map::entrySet)
                .forEach(System.out::println);
            ;

    }

    public static Map<Long, Long> count(Map<String, UserStats>... visits) {

        //fail fast
        //reject null or empty array of maps
        if (visits == null || visits.length == 0) {
            return Collections.emptyMap();
        }

        return Arrays.stream(visits)
                //map1, map2, ..
                //reject null maps
                .filter(Objects::nonNull)
                // map1, map2.. -> entry1, entry2
                .flatMap(map -> map.entrySet().stream())
                //reject null keys
                .filter(entry -> entry.getKey() != null)
                //reject keys that cannot be parsed to Long
                .filter(entry -> {
                    try {
                        Long.parseLong(entry.getKey());
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                //reject null UserStats values and empty visits
                .filter(entry -> entry.getValue() != null && entry.getValue().getVisitCount().isPresent())
                //terminal operation: convert to map, accumulate visits by summing
                .collect(Collectors.toMap(
                        entry -> Long.parseLong(entry.getKey()),
                        entry -> entry.getValue().getVisitCount().get(),
                        Long::sum
                ));
    }

}
