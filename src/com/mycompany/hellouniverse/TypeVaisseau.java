package com.mycompany.hellouniverse;

public enum TypeVaisseau {
    HUNTER("Hunter"),
    FRIGATE("Frigate"),
    CRUISER("Cruiser"),
    CARGO("Cargo"),
    WORLD_VESSEL("World-Vessel");

    public String name;

    private TypeVaisseau(String name){
        this.name=name;
    }
}
