package com.mycompany.hellouniverse;

public class Planet {
    String name;
    String material;
    long diameter;
    int totalVisitors;
    Atmosphere atmosphere;

    int revolution(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne autour de mon étoile.");
        return angle/365;
    }
    int rotation(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne sur moi-même.");
        return angle/365;
    }

    void welcomeVessels(int newHumans){
        totalVisitors +=newHumans;
    }

    void welcomeVessels(String vesselType){
        switch (vesselType){
            case "HUNTEUR":
                totalVisitors +=3;
                break;
            case "FRIGATE":
                totalVisitors +=12;
                break;
            case "CRUISER":
                totalVisitors +=50;
                break;
            default:
        }
    }
}

