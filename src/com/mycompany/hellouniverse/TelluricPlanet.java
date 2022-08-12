package com.mycompany.hellouniverse;

public class TelluricPlanet extends Planet implements Habitable{
    String material;
    int totalVisitors;
    Vessel vesselIn;
    Vessel[] dockingBay;

    TelluricPlanet(String name){
        super(name);
    }
    TelluricPlanet(String name,int lengthBay){
        super(name);
        this.material="Tellurique";
        this.dockingBay=new Vessel[lengthBay];
    }

    public int freeIndex(){
        int available=0;
        for(int i=0;i<this.dockingBay.length;i++){
            if(this.dockingBay[i]==null){
                available=i;
                break;
            }
        }
        return available;
    }
    public boolean roomLeft(){
        boolean available=false;
        for(int i=0;i<this.dockingBay.length;i++){
            if(this.dockingBay[i]==null){
                available=true;
                break;
            }
        }
        return available;
    }
    @Override
    public Vessel welcomeVessel(Vessel vesselArriving){
        if(vesselArriving instanceof WarVessel){
            ((WarVessel) vesselArriving).deactivateWeapons();
        }

        Vessel vesselOut=this.vesselIn;
        this.vesselIn=vesselArriving;
        this.totalVisitors+=vesselArriving.numberOfPassengers;
        return vesselOut;
    }
    public void welcomeVessels(Vessel... vesselArriving){
        for(int i=0;i<vesselArriving.length;i++){
            this.dockingBay[i]=vesselArriving[i];
            if(vesselArriving[i] instanceof WarVessel){
                ((WarVessel) vesselArriving[i]).deactivateWeapons();
            }
            this.totalVisitors+=vesselArriving[i].numberOfPassengers;
        }
    }
}
