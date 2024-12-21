package com.drzinks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

// takes one/two argument(s), returns nothig, method accept
public class ConsumerBiConsumerTest {

    static Consumer<String> printC = System.out::println;
//    static Consumer<String> printC = s -> System.out.println(s);
    static Map<String, String> capitalCities = new HashMap<>();
    static BiConsumer<String, String> biConPutInMap = (country, capital) -> capitalCities.put(country, capital);
    static BiConsumer<String, String> biConPrettyPrintMap = (country, capital) -> System.out.println(capital + " is a capital of "+ country + ".");
    public static void main(String[] args) {
        printC.accept("kij");

        biConPutInMap.accept("Ponad", "Warsaw");
        biConPutInMap.accept("Czechia" ,"Praha");

        capitalCities.forEach(biConPrettyPrintMap);
    }

}
