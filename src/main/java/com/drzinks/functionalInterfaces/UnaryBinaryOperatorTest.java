package com.drzinks.functionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

//like function/bifunction but taking the same types and returning same type as arg
//T apply(T t)
public class UnaryBinaryOperatorTest {

    static UnaryOperator<String> unOp1 = name -> "My name is " + name +".";
    static BinaryOperator<String> binOp2 = (name, surname) -> name.concat(" ").concat(surname);

    public static void main(String[] args) {
        System.out.println(unOp1.apply("Michal"));
        System.out.println(binOp2.apply("Michal","Golebiowski"));
    }

}
