package com.drzinks.inheritance;

class Mammal {

    protected String name;

    public Mammal(String name) {
        this.name = name;
    }

    protected void breath(){
        System.out.println("Mammal " + name + " breaths.");
    }
}
