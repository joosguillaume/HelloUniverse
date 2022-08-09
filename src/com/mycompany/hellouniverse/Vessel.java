package com.mycompany.hellouniverse;

public class Vessel {
    String type;
    int numberOfPassengers;

    int armourResistanceCapability;
    int shieldDurationCapability;

    Vessel(){
        System.out.println("Un nouveau vaisseau est construit.");
    }

    Vessel(String type,int armourResistanceCapability,int shieldDurationCapability) {
        this.type = type;
        this.armourResistanceCapability = armourResistanceCapability;
        this.shieldDurationCapability = shieldDurationCapability;
    }
    void activateShield(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }

    void deactivateShield(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }
}
