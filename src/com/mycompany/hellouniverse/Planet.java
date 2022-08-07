package com.mycompany.hellouniverse;

public class Planet {
    String name;
    String material;
    long diameter;
    int totalVisitors;
    Atmosphere atmosphere;
    Vessel vesselIn;
    static String shape="spherique";
    static int numberOfDiscoveredPlanets;

    Planet(){
        numberOfDiscoveredPlanets++;
    }
    int revolution(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne autour de mon étoile.");
        return angle/365;
    }
    int rotation(int angle){
        System.out.println("Je suis la planète "+ name +" et je tourne sur moi-même.");
        return angle/365;
    }

    Vessel welcomeVessels(Vessel vesselArriving){
        Vessel vesselOut=this.vesselIn;
        this.vesselIn=vesselArriving;
        this.totalVisitors+=vesselArriving.numberOfPassengers;
        return vesselOut;
    }

    static String expansion(double distance){
        //System.out.println(distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?");
        return distance<14?"Oh la la mais c'est super rapide":"Je rêve ou c'est plus rapide que la lumière?";
    }
}

