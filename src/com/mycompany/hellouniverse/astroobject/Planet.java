package com.mycompany.hellouniverse.astroobject;

public abstract class Planet implements Comparable{
    public static String shape="spherique";
    public static int numberOfDiscoveredPlanets;
    public String name;
    public long diameter;
    public Atmosphere atmosphere;
    public float starDistance;

    Planet(String name,float starDistance){
        this.name=name;
        this.starDistance=starDistance;
        numberOfDiscoveredPlanets++;
    }
    public static String expansion(double distance){
        //System.out.println(distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?");
        return distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?";
    }
    public int revolution(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne autour de mon étoile.");
        return angle/365;
    }
    public int rotation(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne sur moi-même.");
        return angle/365;
    }

    @Override
    public int compareTo(Object o) {
        Planet otherPlanet=(Planet)o;
        //if (this.starDistance==otherPlanet.starDistance) return 0;
        //if (this.starDistance>otherPlanet.starDistance) return 1;
        //return -1;
        return ((Float)starDistance).compareTo((Float) otherPlanet.starDistance);
    }
}

