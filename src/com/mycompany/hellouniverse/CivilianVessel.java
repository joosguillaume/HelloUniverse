package com.mycompany.hellouniverse;

public class CivilianVessel extends Vessel{
    CivilianVessel(){
        super();
    }
    CivilianVessel(String type){
        super(type);
    }
    CivilianVessel(String type,int armourResistanceCapability,int shieldDurationCapability){
        super(type,armourResistanceCapability,shieldDurationCapability);
    }

    @Override
    int carryCargo(int tonnage) {
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
