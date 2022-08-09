package com.mycompany.hellouniverse;

public class WarVessel extends Vessel{
    boolean deactivatedWeapons;
    WarVessel(){
        super();
    }
    WarVessel(String type,int armourResistanceCapability,int shieldDurationCapability){
        super(type,armourResistanceCapability,shieldDurationCapability);
    }
    void attack (Vessel target,String weapon,int duration){
        if (deactivatedWeapons){
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + this.type + " attaque un vaisseau de type " + target.type + " en utilisant l'arme " + weapon + " pendant " + duration + " minutes.");
            target.armourResistanceCapability /= 2;
            target.shieldDurationCapability = 0;
        }
    }

    void deactivateWeapons(){
        deactivatedWeapons=true;
        System.out.println("Désactivation des armes d'un vaisseau de type "+this.type);
    }
}
