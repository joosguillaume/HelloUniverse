package com.mycompany.hellouniverse;

public class TelluricPlanet extends Planet implements Habitable{
    String material;
    int totalVisitors;
    Vessel vesselIn;
    TelluricPlanet(String name){
        super(name);
        this.material="Tellurique";
    }
    @Override
    public Vessel welcomeVessels(Vessel vesselArriving){
        Vessel vesselOut=this.vesselIn;
        this.vesselIn=vesselArriving;
        this.totalVisitors+=vesselArriving.numberOfPassengers;
        return vesselOut;
    }
}
