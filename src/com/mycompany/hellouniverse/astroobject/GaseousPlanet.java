package com.mycompany.hellouniverse.astroobject;

public class GaseousPlanet extends Planet {
    public String material;

    public GaseousPlanet(String name, float starDistance){
        super(name,starDistance);
        this.material="Gazeuse";
    }
}
