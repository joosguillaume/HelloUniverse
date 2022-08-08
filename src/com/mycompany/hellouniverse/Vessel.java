package com.mycompany.hellouniverse;

public class Vessel {
    String type;
    int numberOfPassengers;

    int armourResistanceCapability;
    int shieldDurationCapability;

    void activateShield(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }

    void deactivateShield(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }
}
