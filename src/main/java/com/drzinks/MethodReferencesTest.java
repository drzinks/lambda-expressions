package com.drzinks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReferencesTest {

    static UnaryOperator<String> unLower = s -> s.toLowerCase();
    static UnaryOperator<String> unLowerMR = String::toLowerCase;

    public static void main(String[] args) {

        String name = "Michal Golebiowski";
        System.out.println(unLower.apply(name));
        System.out.println(unLowerMR.apply(name));

        //Constructor method references
        Function<Integer, List<String>> getList = i -> new ArrayList<>(i);
        Function<Integer, List<String>> getList2 = ArrayList::new;

        List someList = getList2.apply(5);
        someList.forEach(System.out::println);


    }

}
