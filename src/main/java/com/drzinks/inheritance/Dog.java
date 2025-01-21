package com.drzinks.inheritance;

public class Dog extends Mammal{

    public Dog(String name) {
        super(name);
    }

    @Override
    protected void breath() {
        System.out.println("Dog " + name + " breaths.");
    }

    void bark() {
        System.out.println("Dog " + name + " barks");
    }

}
