package com.mycompany.hellouniverse;

public abstract class Vessel {
    String type;
    int numberOfPassengers;

    int armourResistanceCapability;
    int shieldDurationCapability;
    int maxTonnage;
    int currentTonnage;

    Vessel(){
    }
    Vessel(String type){
        System.out.println("Un nouveau vaisseau est construit.");
        this.type=type;
        switch (type){
            case("FRIGATE"):
                this.maxTonnage=50;
                break;
            case("CRUISER"):
                this.maxTonnage=100;
                break;
            case("CARGO"):
                this.maxTonnage=500;
                break;
            case("WORLD-VESSEL"):
                this.maxTonnage=2000;
                break;
            default:
                this.maxTonnage=0;
                break;
        }
    }

    Vessel(String type,int armourResistanceCapability,int shieldDurationCapability) {
        this();
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

    abstract int carryCargo(int tonnage);
}
