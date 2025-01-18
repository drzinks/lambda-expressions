package com.drzinks.collections;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {
//        listsFactoryMethods();
        linkedListArrayDeque();

    }

    static void linkedListArrayDeque(){

        LinkedList<String> linkedNames = new LinkedList<>();
        linkedNames.add("alpha");
        linkedNames.add("beta");
        linkedNames.add("charlie");

        linkedNames.addLast("Delta");

        linkedNames.getFirst();

        Deque<String> stack = new ArrayDeque<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        stack.pop(); //same as removeFirst()
        stack.peek(); //retrieves but not remove

        stack.forEach(System.out::println);

    }

    static void listsFactoryMethods(){
        String[] array = new String[] {"Alpha", "Beta", "Charlie"};

        //array is modified <=> list is modified
        //cannot add/remove
        List<String> asList = Arrays.asList(array);

        //array does NOT back up List
        //cannot add/remove AND MODIFY
        List<String> of = List.of(array);

        array[0] = "Delta";

        asList.forEach(e -> System.out.print(e + ", ")); //Delta, Beta, Charlie
        of.forEach(e -> System.out.print(e + ", ")); //Alpha, Beta, Charlie

        asList.set(0,"Alpha2"); //Alpha2, Beta, Charlie
        asList.forEach(e -> System.out.print(e + ", "));

//        asList.add("ds"); cannot add/remove
//        of.add("ds"); cannot add/remove
//        of.set(0,"Alpha3"); cannot modify

    }

}
