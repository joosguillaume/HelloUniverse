package com.mycompany.hellouniverse.spacecrafts;

public class WarVessel extends Vessel{
    private boolean deactivatedWeapons;
    public WarVessel(){
        super();
    }
    public WarVessel(TypeVaisseau type){
        super(type);
    }
    public WarVessel(TypeVaisseau type,int armourResistanceCapability,int shieldDurationCapability){
        super(type,armourResistanceCapability,shieldDurationCapability);
    }
    public void attack (Vessel target,String weapon,int duration){
        if (deactivatedWeapons){
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + this.type + " attaque un vaisseau de type " + target.type.name + " en utilisant l'arme " + weapon + " pendant " + duration + " minutes.");
            target.armourResistanceCapability /= 2;
            target.shieldDurationCapability = 0;
        }
    }

    public void deactivateWeapons(){
        deactivatedWeapons=true;
        System.out.println("Désactivation des armes d'un vaisseau de type "+this.type.name);
    }
    public void activateWeapons(){
        deactivatedWeapons=false;
        System.out.println("activation des armes d'un vaisseau de type "+this.type.name);
    }
    public void activateShield(){
        super.activateShield();
        deactivateWeapons();
    }

    @Override
    public int carryCargo(int tonnage) {
        int rejectedTonnage=0;
        int maxAcceptedTonnage=this.numberOfPassengers*2;
        int tonnageToSet=0;
        if(tonnage>0){
            switch (this.type){
                case HUNTER:
                    System.out.println("Un vaisseau de type "+this.type.name+" n'emporte pas de chargement.");
                    rejectedTonnage=tonnage;
                    break;
                default:
                    if(this.numberOfPassengers<12){
                        System.out.println("Il n'y pas assez de passagers pour emporter un chargement");
                        rejectedTonnage=tonnage;
                    }
                    else{
                        if(tonnage<=maxAcceptedTonnage){
                            tonnageToSet=tonnage;
                            rejectedTonnage=0;
                        }else{
                            tonnageToSet=maxAcceptedTonnage;
                            rejectedTonnage=tonnage-maxAcceptedTonnage;
                        }
                    }
                    break;
            }
        }

        if(tonnageToSet<this.maxTonnage-this.currentTonnage){
            this.currentTonnage+=tonnageToSet;
        }else{
            //tonnageToSet=this.maxTonnage-this.currentTonnage;
            rejectedTonnage+=(tonnageToSet-this.maxTonnage+this.currentTonnage);
            this.currentTonnage=this.maxTonnage;
        }
        return rejectedTonnage;
    }
}
