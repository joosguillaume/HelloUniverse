package com.mycompany.hellouniverse;

public class TelluricPlanet extends Planet implements Habitable{
    String material;
    int totalVisitors;
    Vessel vesselIn;
    Vessel[][] dockingBay;

    TelluricPlanet(String name,float starDistance){
        super(name,starDistance);
        this.material="Tellurique";
    }
    TelluricPlanet(String name,float starDistance,int lengthBay){
        super(name,starDistance);
        this.material="Tellurique";
        this.dockingBay=new Vessel[2][lengthBay];
    }

    public int freeIndex(int col){
        int available=0;
        for(int i=0;i<this.dockingBay[col].length;i++){
            if(this.dockingBay[col][i]==null){
                available=i;
                break;
            }
        }
        return available;
    }
    public boolean roomLeft(int col){
        boolean available=false;
        for(int i=0;i<this.dockingBay[col].length;i++){
            if(this.dockingBay[col][i]==null){
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
            if(vesselArriving[i] instanceof WarVessel){
                ((WarVessel) vesselArriving[i]).deactivateWeapons();
                this.dockingBay[0][freeIndex(0)]=vesselArriving[i];
            }else{
                this.dockingBay[1][freeIndex(1)]=vesselArriving[i];
            }
            this.totalVisitors+=vesselArriving[i].numberOfPassengers;
        }
    }
}
