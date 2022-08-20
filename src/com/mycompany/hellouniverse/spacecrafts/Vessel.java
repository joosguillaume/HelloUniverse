package com.mycompany.hellouniverse.spacecrafts;

public abstract class Vessel {
    public final TypeVaisseau type;
    public int numberOfPassengers;

    public int armourResistanceCapability;
    public int shieldDurationCapability;
    int maxTonnage;
    protected int currentTonnage;


    Vessel(TypeVaisseau type){
        System.out.println("Un nouveau vaisseau "+type.name+" est construit.");
        this.type=type;
        switch (type){
            case FRIGATE:
                this.maxTonnage=50;
                break;
            case CRUISER:
                this.maxTonnage=100;
                break;
            case CARGO:
                this.maxTonnage=500;
                break;
            case WORLD_VESSEL:
                this.maxTonnage=2000;
                break;
            default:
                this.maxTonnage=0;
                break;
        }
    }

    Vessel(TypeVaisseau type,int armourResistanceCapability,int shieldDurationCapability) {
        this(type);
        //this.type = type;
        this.armourResistanceCapability = armourResistanceCapability;
        this.shieldDurationCapability = shieldDurationCapability;
    }
    public void activateShield(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type.name);
    }

    public void deactivateShield(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type.name);
    }

    public abstract int carryCargo(int tonnage) throws ExceedTonnageException;
}
