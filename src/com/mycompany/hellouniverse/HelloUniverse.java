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

        int nombreDeRevolution=0;
        int nombreDeRotation=0;
        nombreDeRevolution=neptune.revolution(-3542);
        System.out.println(neptune.name+" a effectué "+nombreDeRevolution+" tours complets autour de son étoile.");
        nombreDeRotation=mars.rotation(-684);
        System.out.println(mars.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        nombreDeRotation=venus.rotation(1250);
        System.out.println(venus.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        Vessel vesselArriving=new Vessel();
        vesselArriving.type="FRIGATE";
        vesselArriving.numberOfPassengers=9;

        Vessel vesselOut=mars.welcomeVessels(vesselArriving);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }
        vesselArriving.type="CRUISER";
        vesselArriving.numberOfPassengers=42;

        vesselOut=mars.welcomeVessels(vesselArriving);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }

        System.out.println("Le nombre d'humains ayant déjà séjourné sur "+mars.name+" est actuellement de "+mars.totalVisitors +".");

        Atmosphere uranusAtmosphere=new Atmosphere();
        uranusAtmosphere.heliumRate=15;
        uranusAtmosphere.hydrogenRate=83;
        uranusAtmosphere.methaneRate=2.5f;
        uranus.atmosphere=uranusAtmosphere;

        System.out.println("L'atmosphère de la planète "+uranus.name+" est composée : ");
        System.out.println("A "+ uranus.atmosphere.hydrogenRate+ " % d'hydrogène");
        System.out.println("A "+ uranus.atmosphere.heliumRate+ " % d'hélium");
        System.out.println("A "+ uranus.atmosphere.methaneRate+ " % de méthane");

        System.out.println("La forme d'une planète est : "+Planet.shape);
        System.out.println("La forme de Mars est : "+mars.shape);

        System.out.println(Planet.expansion(10.5));
        System.out.println(Planet.expansion(14.2));
    }
}
