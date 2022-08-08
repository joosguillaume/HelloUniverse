package com.mycompany.hellouniverse;

public class CivilianVessel extends Vessel{
    CivilianVessel(String type,int armourResistanceCapability,int shieldDurationCapability){
        this.type=type;
        this.armourResistanceCapability=armourResistanceCapability;
        this.shieldDurationCapability=shieldDurationCapability;
    }
}
