package com.mycompany.hellouniverse.astroobject;

import java.util.Set;
import java.util.TreeSet;

public class Galaxy {
    String name;
    public Set<Planet> planets;


    public Galaxy(String name){
        this.name=name;
        this.planets=new TreeSet();
    }

    public void addPlanets(Planet... planetToAdd){
        for(int i=0;i<planetToAdd.length;i++){
            System.out.println("Ajout de "+planetToAdd[i].name);
            planets.add(planetToAdd[i]);
        }
    }
}
