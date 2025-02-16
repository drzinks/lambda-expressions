package com.drzinks.pattern_matching;

import java.util.List;
import java.util.stream.Stream;

public class TestPatterns {

    public static void main(String[] args) {
        Person michal = new Person("Michal", 42);
        Person jarek = new Person("Jarek", 36);
        Person maciek = new Person("Maciek", 43);
        String wcForMan = "WC meskie";

        Programmer michalP = new Programmer(michal, ProgrammingSkills.SENIOR);
        Programmer jarekP = new Programmer(jarek, ProgrammingSkills.TECH_LEAD);
        Programmer maciekP = new Programmer(maciek, ProgrammingSkills.ARCHITECT);

        Stream.of(michalP, wcForMan, null, jarekP, maciekP)
                .forEach(e->System.out.println(testPatternMatching(e)));;

    }

    //pattern matching for switch
    public static String testPatternMatching(Object o){
        return switch (o) {
            case Programmer p when p.skills == ProgrammingSkills.TECH_LEAD ||  p.skills == ProgrammingSkills. ARCHITECT
                    -> p.person.name + " is a gruby wior.";
            case Programmer p when p.skills.ordinal() <= ProgrammingSkills.SENIOR.ordinal()
                -> p.person.name + " is a regular wior.";
            case null -> "Not known what it is.";
            case String text -> "Some text: " + text;
            default -> "Not a valid type";
        };

    }

    //record patterrns
    public static void testRecordPatterns(){
        Person michal = new Person("Michal", 42);
        Person jarek = new Person("Jarek", 36);
        Person maciek = new Person("Maciek", 43);

        Programmer michalP = new Programmer(michal, ProgrammingSkills.SENIOR);
        Programmer jarekP = new Programmer(jarek, ProgrammingSkills.TECH_LEAD);
        Programmer maciekP = new Programmer(maciek, ProgrammingSkills.ARCHITECT);

        recordPatterns(List.of(michalP,maciekP,jarekP));
        recordPatterns(List.of(new Doubles(michalP,maciekP), new Doubles(michalP,jarekP)));
    }

    public static void recordPatterns(List<Object> objects){
        for (Object object : objects) {
            if(object instanceof Programmer programmer){
                System.out.println("Programmer: ");
                System.out.println(programmer);
            }else if(object instanceof Doubles doubleP) {
                System.out.println("Doubles:");
                System.out.println(doubleP.p1.person.name + " " + doubleP.p2.person.name);
            }

        }

    }

    record Person(String name, Integer age) {}
    enum ProgrammingSkills{JUNIOR, MEDIUM_REGULAR, SENIOR, TECH_LEAD, ARCHITECT}
    record Programmer(Person person, ProgrammingSkills skills) {}
    record Doubles(Programmer p1, Programmer p2) {}

}
