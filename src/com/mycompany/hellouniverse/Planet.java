package com.mycompany.hellouniverse;

public class Planet {
    String name;
    String material;
    long diameter;

    void revolution(){
        System.out.println("Je suis la planète "+ name +" et je tourne autour de mon étoile.");
    }
    void rotation(){
        System.out.println("Je suis la planète "+ name +" et je tourne sur moi-même.");
    }
}

