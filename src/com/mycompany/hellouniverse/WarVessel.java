package com.mycompany.hellouniverse;

public class WarVessel extends Vessel{
    WarVessel(String type,int armourResistanceCapability,int shieldDurationCapability){
        this.type=type;
        this.armourResistanceCapability=armourResistanceCapability;
        this.shieldDurationCapability=shieldDurationCapability;
    }
    void attack (Vessel target,String weapon,int duration){
        System.out.println("Un vaisseau de type "+this.type+" attaque un vaisseau de type "+target.type+" en utilisant l'arme "+weapon+" pendant "+duration+" minutes.");
        target.armourResistanceCapability/=2;
        target.shieldDurationCapability=0;
    }
}
