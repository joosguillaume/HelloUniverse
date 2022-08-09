package com.mycompany.hellouniverse;

public class Planet {
    static String shape="spherique";
    static int numberOfDiscoveredPlanets;
    String name;
    long diameter;
    Atmosphere atmosphere;

    Planet(String name){
        this.name=name;
        numberOfDiscoveredPlanets++;
    }
    static String expansion(double distance){
        //System.out.println(distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?");
        return distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?";
    }
    int revolution(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne autour de mon étoile.");
        return angle/365;
    }
    int rotation(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne sur moi-même.");
        return angle/365;
    }
}

