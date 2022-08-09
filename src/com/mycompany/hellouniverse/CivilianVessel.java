package com.mycompany.hellouniverse;

public class CivilianVessel extends Vessel{
    CivilianVessel(){
        super();
    }
    CivilianVessel(String type,int armourResistanceCapability,int shieldDurationCapability){
        super(type,armourResistanceCapability,shieldDurationCapability);
    }
}
