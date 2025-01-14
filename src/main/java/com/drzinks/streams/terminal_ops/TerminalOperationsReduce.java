package com.drzinks.streams.terminal_ops;

import java.util.stream.Stream;

public class TerminalOperationsReduce {

    public static void main(String[] args) {

        /*T reduce(T identity, BinaryOperator<T> accumulator)*/
        String name = Stream.of("M","i","c","h","a","l")
                .reduce("", (c1,c2) -> c1 + c2);
        System.out.println(name);
        int result = Stream.of(1,2,3,4)
                .reduce(1, (a,b) -> a*b);
        System.out.println(result);

        /* Optional<T> reduce(BinaryOperator<T> accumulator)*/

        /* <U> U reduce (U identity, BiFunction accumulator, BinaryOperator combiner) */
        //used in parallel stream processing (by many threads)
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        System.out.println(stream.reduce(0,
                (n, str) -> n + str.length(),
                (n1,n2) -> n1 + n2
        ));
    }

}
