package com.mycompany.hellouniverse;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Galaxy {
    String name;
    Set<Planet> planets;


    Galaxy(String name){
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
