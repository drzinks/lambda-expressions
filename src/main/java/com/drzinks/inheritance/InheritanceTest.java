package com.drzinks.inheritance;

import java.util.List;

public class InheritanceTest {

    public static void main(String[] args) {
        Mammal mammal = new Mammal("Wieslaw");
        Mammal whale = new Whale("Marcin");
        Mammal dog = new Dog("Michal");
        Dog dog2 = new Dog("Jarek");
        Dog dog3 = new Dog("Maciek");


        List<? extends Mammal> mammals = List.of(mammal, whale, dog, dog2);
        mammals.forEach(Mammal::breath);
//      CANNOT ADD (? extends T makes it read only) mammals.add(dog3);

//      CANNOT  dog.bark();
        dog2.bark();

    }

}
