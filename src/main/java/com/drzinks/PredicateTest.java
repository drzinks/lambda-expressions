package com.drzinks;

import java.util.function.Predicate;

public class PredicateTest {

    //when want to create generic, create on some specifix type

    interface Evaluate<Integer>{
        boolean isNegative(Integer t);
    }

    public static boolean check(Integer t, Predicate<Integer> lambda){
        return lambda.test(t);
    }

    public static <T> boolean checkGeneric(T t, Predicate<T> lambda){
        return lambda.test(t);
    }

    public static void main(String[] args) {
        Evaluate<Integer> lambda = t -> t < 0; //if t<0 true
        System.out.println(lambda.isNegative(0));
        var a = 6;
        System.out.println("Is "+a+" even? " + checkGeneric(a, x-> x%2 == 0));
        var name = "Michal Golebiowski";
        System.out.println("Does name " + name + " starts with M ?" + checkGeneric(name, text -> text.startsWith("M")));
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City"));
    }

}
