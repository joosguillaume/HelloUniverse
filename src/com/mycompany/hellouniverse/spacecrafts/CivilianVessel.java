package com.mycompany.hellouniverse.spacecrafts;

public class CivilianVessel extends Vessel{

    public CivilianVessel(TypeVaisseau type){
        super(type);
    }
    public CivilianVessel(TypeVaisseau type,int armourResistanceCapability,int shieldDurationCapability){
        super(type,armourResistanceCapability,shieldDurationCapability);
    }

    @Override
    public int carryCargo(int tonnage) {
        int rejectedTonnage=0;

        if(tonnage<this.maxTonnage-this.currentTonnage){
            this.currentTonnage+=tonnage;
        }else{
            rejectedTonnage=(tonnage-this.maxTonnage+this.currentTonnage);
            this.currentTonnage=this.maxTonnage;
        }
        return rejectedTonnage;
    }
}
