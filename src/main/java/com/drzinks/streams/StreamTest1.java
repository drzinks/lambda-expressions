package com.drzinks.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest1 {

    static List<Double> temperatures = Arrays.asList(1.3, -2.2, -5.0, 4.4, -0.1, 0.1, 0.0, 9.2);

    public static void main(String[] args) {
        System.out.println("Temperatures observed, that were greater or equal to 0: " +
                temperatures.stream()
//                        .peek(e -> System.out.println("Before filter " +e)) //peek() is for debugging purpose
                            .filter(temp -> temp >= 0).count());

        Map<String, Integer> namesToAge = new HashMap<>();
//        namesToAge.put("Michal", 42); namesToAge.put("Jarek", 35); namesToAge.put("Adrian", 24);
//        namesToAge.entrySet().stream().forEach(System.out::println);
        Stream.iterate(2, n -> n*2)
                .limit(10)
                .forEach(System.out::println); //2,4,8,16,32,64,128,256,512,1024
        
    }

}
