package com.drzinks.functionalInterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionalDefaultTest {

   static UnaryOperator<Integer> addThree = e -> e + 3;
   static UnaryOperator<Integer> multiplyByTwo = e -> e * 2;

   static Function<Integer, Integer> addAndMultiply = addThree.andThen(multiplyByTwo);
   static Function<Integer, Integer> multiplyAndAdd = addThree.compose(multiplyByTwo);

    public static void main(String[] args) {
        System.out.println(addAndMultiply.apply(7)); //(7+3)*2 = 20
        System.out.println(multiplyAndAdd.apply(7)); //7*2+3 = 17
    }

}
