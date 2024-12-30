package com.drzinks.functionalInterfaces;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

//takes no argument, returns one, method called 'get'
public class SupplierTest {

    static Supplier<String> supTime = () -> LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    static Supplier<Double> supRandom = Math::random;

    public static void main(String[] args) {
        System.out.println(supTime.get());
        System.out.println(supRandom.get());
    }

}
