package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){

        Planet mercure = new Planet();
        mercure.name = "Mercure";
        mercure.diameter = 4880;
        mercure.material = "Tellurique";
        Planet venus = new Planet();
        venus.name = "Venus";
        venus.diameter = 12100;
        venus.material = "Tellurique";
        Planet terre = new Planet();
        terre.name = "Terre";
        terre.diameter = 12756;
        terre.material = "Tellurique";
        Planet mars = new Planet();
        mars.name = "Mars";
        mars.diameter = 6792;
        mars.material = "Tellurique";
        Planet jupiter = new Planet();
        jupiter.name = "Jupiter";
        jupiter.diameter = 142984;
        jupiter.material = "Gazeuse";
        Planet saturne = new Planet();
        saturne.name = "Saturne";
        saturne.diameter = 120536;
        saturne.material = "Gazeuse";
        Planet uranus = new Planet();
        uranus.name = "Uranus";
        uranus.diameter = 51118;
        uranus.material = "Gazeuse";
        Planet neptune = new Planet();
        neptune.name = "Neptune";
        neptune.diameter = 49532;
        neptune.material = "Gazeuse";

        System.out.println(jupiter.name+" est une planète "+jupiter.material+" avec un diamètre de "+jupiter.diameter+ " kilomètre.");

        Planet planeteX=new Planet();
        System.out.println(planeteX.name+" est une planète "+planeteX.material+" avec un diamètre de "+planeteX.diameter+ " kilomètres.");

        neptune.revolution();
        mars.rotation();

    }
    }
