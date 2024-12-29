package com.drzinks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LabdasAssignmentExercise {

    interface Printable<T> {
        void print(T t);
    }
    Consumer<String> pCons2 = System.out::println;

    interface Retrievable<T>{
        T retrieve();
    }

    void consumer(){
        Printable<String> pCons = System.out::println;
        pCons.print("Printable lambda");
        pCons2.accept("Printable lambda");
    }

    Supplier<Integer> intSup2 = () -> 77;

    void supplier() {
        Retrievable<Integer> intSup1 = () -> 77; //{return 77;}
        intSup1.retrieve();
        intSup2.get();
    }

    interface Evaluate<T>{
        boolean isNegative(T t);
    }

    <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
    record Person(String name, int age, double height) {}

    void predicate(){
        Evaluate<Integer> evPredicate1 = number -> number < 0;
        evPredicate1.isNegative(-1);
        evPredicate1.isNegative(1);
        Predicate<Integer> evPredicate2 = number -> number < 0;

        System.out.println(check(4, number -> number %2 ==0));
        System.out.println(check(7, number -> number %2 ==0));

        System.out.println(check("Mr. Joe Bloggs", text -> text.startsWith("Mr.")));
        System.out.println(check("Ms. Ann Bloggs", text -> text.startsWith("Mr.")));

        Person mike = new Person("Mike", 43, 1.8);
        Person ann = new Person("Ann", 13, 1.4);

        System.out.println(check(mike, p-> p.age >= 18));
        System.out.println(check(ann, p-> p.age >= 18));
    }

    interface Functionable<T,R> {
        R applyThis(T t);
    }

    void function(){
        Functionable<Integer, String> func = number -> "Number is: " + number + ".\n";
        System.out.println(func.applyThis(25));
        Function<Integer, String> func2 = number -> "Number is: " + number + ".\n";
        System.out.println(func2.apply(25));

    }

    static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    static void sortName(List<Person> personList){
        personList.sort(Comparator.comparing(person -> person.name));
        personList.forEach(System.out::println);
    }

    static void sortAge(List<Person> personList){
        personList.sort(Comparator.comparing(person -> person.age));
        personList.forEach(System.out::println);
        //descending
//        Comparator<Person> comparator2 = (p1, p2) -> {
//            if(p1.age >= p2.age)
//                return p1.age;
//            else
//                return p2.age;
//        };
//        personList.sort(comparator2);
    }

    static void sortHeight(List<Person> personList){
        personList.sort(Comparator.comparing(p->p.height));
        personList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        LabdasAssignmentExercise app = new LabdasAssignmentExercise();
        app.consumer();
        app.supplier();
        app.predicate();
        app.function();

        List<Person> personList = getPeople();
        System.out.println("Sort by name:");
        sortName(personList);
        System.out.println("=======================");
        System.out.println("Sort by age:");
        sortAge(personList);
        System.out.println("=======================");
        System.out.println("Sort by height:");
        sortHeight(personList);
        System.out.println("=======================");
    }
}
