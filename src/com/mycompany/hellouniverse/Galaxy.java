package com.mycompany.hellouniverse;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    String name;
    List<Planet> planets;

    Galaxy(String name){
        this.name=name;
        this.planets=new ArrayList();
    }

    public void addPlanets(Planet... planetToAdd){
        for(int i=0;i<planetToAdd.length;i++){
            System.out.println("Ajout de "+planetToAdd[i].name);
            planets.add(planetToAdd[i]);
        }
    }
}
