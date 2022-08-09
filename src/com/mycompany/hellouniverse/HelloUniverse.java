package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        System.out.println("Nombre de planètes découvertes : "+Planet.numberOfDiscoveredPlanets);
        TelluricPlanet mercure = new TelluricPlanet("Mercure");
        mercure.diameter = 4880;
        TelluricPlanet venus = new TelluricPlanet("Venus");
        venus.diameter = 12100;
        TelluricPlanet terre = new TelluricPlanet("Terre");
        terre.diameter = 12756;

        GaseousPlanet saturne = new GaseousPlanet("Saturne");
        saturne.diameter = 120536;
        GaseousPlanet uranus = new GaseousPlanet("Uranus");
        uranus.diameter = 51118;
        GaseousPlanet neptune = new GaseousPlanet("Neptune");
        neptune.diameter = 49532;

        TelluricPlanet mars = new TelluricPlanet("Mars");
        mars.diameter = 6792;
        System.out.println(mars.name+" est une planète "+mars.material+" avec un diamètre de "+mars.diameter+ " kilomètre.");

        GaseousPlanet jupiter = new GaseousPlanet("Jupiter");
        jupiter.diameter = 142984;
        System.out.println(jupiter.name+" est une planète "+jupiter.material+" avec un diamètre de "+jupiter.diameter+ " kilomètre.");

        int nombreDeRevolution=0;
        int nombreDeRotation=0;
        nombreDeRevolution=neptune.revolution(-3542);
        System.out.println(neptune.name+" a effectué "+nombreDeRevolution+" tours complets autour de son étoile.");
        nombreDeRotation=mars.rotation(-684);
        System.out.println(mars.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        nombreDeRotation=venus.rotation(1250);
        System.out.println(venus.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        WarVessel hunter=new WarVessel();
        hunter.type="HUNTER";
        hunter.numberOfPassengers=9;
        Vessel vesselOut=mars.welcomeVessels(hunter);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }
        CivilianVessel civilianVessel=new CivilianVessel();
        civilianVessel.type="WORLD-VESSEL";
        hunter.attack(civilianVessel,"lasers photoniques",3);
        vesselOut=mars.welcomeVessels(civilianVessel);
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
        System.out.println("Nombre de planètes découvertes : "+Planet.numberOfDiscoveredPlanets);

        WarVessel hunterVessel=new WarVessel("HUNTER",156,2);
        CivilianVessel worldVessel=new CivilianVessel("VAISSEAU-MONDE",4784,30);
        hunterVessel.activateShield();
        worldVessel.activateShield();
        hunterVessel.attack(worldVessel,"lasers photoniques",3);
        worldVessel.deactivateShield();
        System.out.println("Durée de protection résiduelle du bouclier du vaisseau-Monde : "+worldVessel.shieldDurationCapability);
        System.out.println("Valeur du blindage du bouclier du vaisseau-Monde : "+worldVessel.armourResistanceCapability);

    }
}
