package com.drzinks.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(), //supplier - StringBuilder::new
                        (sb, str) -> sb.append(str),
                        (sb1,sb2) -> sb1.append(sb2)
                        );


        List<String> shoppingList = Stream.of("cheese", "bacon", "eggs", "tortillas","onion").collect(Collectors.toList());
        String shopping = shoppingList.stream().collect(Collectors.joining(","));
        Double avg = shoppingList.stream().collect(Collectors.averagingInt(text -> text.length()));
        Map<Integer, String> map = shoppingList.stream().collect(
            Collectors.toMap(s -> s.length(), //how to obtain key
                    s -> s, //how to obtain value
                    (s1,s2) -> s1 + "," + s2, //optional: what if duplicate keys
                    () -> new TreeMap<>() //result must be a TreeMap
                ));
        map.entrySet().forEach(System.out::println);


        List<String> names =  Stream.of("Michal", "Maciek", "Jarek", "Michal", "Jacek").toList();

        Map<Integer, Set<String>> lengthToName = names.stream().collect(Collectors.groupingBy(
            name -> name.length(),
            TreeMap::new,
            Collectors.toSet()
        ));
        System.out.println(lengthToName); //{5=[Jarek, Jacek], 6=[Michal, Maciek]}
    }

}
