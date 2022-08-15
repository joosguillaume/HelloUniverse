package com.mycompany.hellouniverse;

import java.util.HashSet;
import java.util.Set;

public class Galaxy {
    String name;
    Set<Planet> planets;


    Galaxy(String name){
        this.name=name;
        this.planets=new HashSet();
    }

    public void addPlanets(Planet... planetToAdd){
        for(int i=0;i<planetToAdd.length;i++){
            System.out.println("Ajout de "+planetToAdd[i].name);
            planets.add(planetToAdd[i]);
        }
    }
}
