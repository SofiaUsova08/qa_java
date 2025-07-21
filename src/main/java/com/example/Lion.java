package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private Felines felines;
    Feline feline = new Feline();

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public Lion(Felines felines) {
        this.felines = felines;
    }


    public int getKittens() {
        return felines.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }

}

