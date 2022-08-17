package com.mycompany.hellouniverse.astroobject;

import com.mycompany.hellouniverse.spacecrafts.Vessel;

public interface Habitable {
    public Vessel welcomeVessel(Vessel vesselArriving);
    public void welcomeVessels(Vessel... vesselArriving);

}
