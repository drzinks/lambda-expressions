package com.drzinks.inheritance;

public class Whale extends Mammal{

    public Whale(String name) {
        super(name);
    }

    @Override
    protected void breath() {
        System.out.println("Whale " + name + " breaths.");
    }

    void swim() {
        System.out.println("Whale " + name + " swims.");
    }
}
