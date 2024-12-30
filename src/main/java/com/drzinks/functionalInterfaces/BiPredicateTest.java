package com.drzinks.functionalInterfaces;

import java.util.function.BiPredicate;


/* takes two arguments, returns boolean, method called 'test'*/
public class BiPredicateTest {

    public static void main(String[] args) {
        BiPredicate<String, Integer> checkLength = (s, len) -> s.length() == len;

        var temp ="Ala ma kota";
        System.out.println(checkLength.test(temp,5));
    }

}
