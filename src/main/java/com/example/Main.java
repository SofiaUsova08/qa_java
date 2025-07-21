package com.example;

public class Main {
    public static void main(String[] args) throws Exception{


        Felines felines = new Feline();
        Lion lion = new Lion(felines);
        System.out.println(lion.getKittens());


    }
}