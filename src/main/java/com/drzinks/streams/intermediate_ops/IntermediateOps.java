package com.drzinks.streams.intermediate_ops;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void main(String[] args) {
        List<String> names = List.of("Michal", "Michal", "Maciek", "Jaroslaw", "Adrian");
        Map<String, Integer> namesToAge= Map.of(
                "Michal", 43,
                "Jaroslaw", 36,
                "Maciek", 44,
                "Adrian", 25,
                "Janusz", 52
        );

        namesToAge.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 30)
                .map(e -> e.getKey())
                .sorted()
                .toList()
                .forEach(System.out::println);

        names.stream() //not Stream.of(names) bo wtedy zrobi strumień z 1 el - listą a nie strumień elementów listy
                .distinct()
                .forEach(System.out::println);

    }

}
