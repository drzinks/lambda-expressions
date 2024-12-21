package com.drzinks;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionBiFunctionTest {

    static Function<String, Integer> funGetLengthOfText = String::length;
    static BiFunction<String, String, Integer> funGetLengthOfTwoWords = (s1,s2) -> s1.length() + s2.length();

    public static void main(String[] args) {
        System.out.println(funGetLengthOfText.apply("Szoadyzor"));

        System.out.println(funGetLengthOfTwoWords.apply("Szpadyzor", " records"));
    }

}
