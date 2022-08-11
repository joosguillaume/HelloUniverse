package com.mycompany.hellouniverse;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloUniverse {
    public static void main(String... args){
        System.out.println("Nombre de planètes découvertes : "+Planet.numberOfDiscoveredPlanets);
        TelluricPlanet mercure = new TelluricPlanet("Mercure");
        mercure.diameter = 4880;
        TelluricPlanet venus = new TelluricPlanet("Venus");
        venus.diameter = 12100;
        TelluricPlanet terre = new TelluricPlanet("Terre");
        terre.diameter = 12756;
        TelluricPlanet mars = new TelluricPlanet("Mars");
        mars.diameter = 6792;
        GaseousPlanet jupiter = new GaseousPlanet("Jupiter");
        jupiter.diameter = 142984;
        GaseousPlanet saturne = new GaseousPlanet("Saturne");
        saturne.diameter = 120536;
        GaseousPlanet uranus = new GaseousPlanet("Uranus");
        uranus.diameter = 51118;
        GaseousPlanet neptune = new GaseousPlanet("Neptune");
        neptune.diameter = 49532;

        System.out.println(mars.name+" est une planète "+mars.material+" avec un diamètre de "+mars.diameter+ " kilomètre.");

        int nombreDeRevolution=0;
        int nombreDeRotation=0;
        nombreDeRevolution=neptune.revolution(-3542);
        System.out.println(neptune.name+" a effectué "+nombreDeRevolution+" tours complets autour de son étoile.");
        nombreDeRotation=mars.rotation(-684);
        System.out.println(mars.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        nombreDeRotation=venus.rotation(1250);
        System.out.println(venus.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");


        //CHASSEUR, FREGATE, CROISEUR, CARGO et VAISSEAU-MONDE

        WarVessel hunter=new WarVessel("HUNTER");
        WarVessel frigate=new WarVessel("FRIGATE");
        WarVessel cruiser=new WarVessel("CRUISER");
        CivilianVessel cargo=new CivilianVessel("CARGO");
        CivilianVessel worldVessel=new CivilianVessel("WORLD-VESSEL");

        String vesselType;
        String planetName;
        int tonnageCargo;
        int numberOfPassengers;

        Scanner sc=new Scanner(System.in);
        System.out.println("Quel vaisseau voulez-vous manipuler (HUNTER,FRIGATE,CRUISER,CARGO,WORLD-VESSEL)?");
        vesselType=sc.nextLine();
        System.out.println("Vous voulez manipuler un vaisseau de type "+vesselType+".");
        System.out.println("Sur quelle planète tellurique voulez-vous que le vaisseau de type "+vesselType+" se pose?");
        planetName=sc.nextLine();
        System.out.println("Quel tonnage voulez-vous que le vaisseau emporte?");
        tonnageCargo=sc.nextInt();
        System.out.println("Le vaisseau "+vesselType+" va embarquer "+tonnageCargo+ " tonnes.");
        Vessel choosenVessel=null;
        int refusedQuantity=0;

        switch (vesselType){
            case("HUNTER"):
                choosenVessel=hunter;
                break;
            case("FRIGATE"):
                choosenVessel=frigate;
                break;
            case("CRUISER"):
                choosenVessel=cruiser;
                break;
            case("CARGO"):
                choosenVessel=cargo;
                break;
            case("WORLD-VESSEL"):
                choosenVessel=worldVessel;
                break;
        }
        if(choosenVessel instanceof WarVessel){
            System.out.println("Vous avez choisi un vaisseau de guerre.");
            System.out.println("Un vaisseau de guerre doit avoir des passagers pour pouvoir embarquer une cargaison.");
            System.out.println("Combien de passagers voulez-vous?");
            numberOfPassengers=sc.nextInt();
            choosenVessel.numberOfPassengers=numberOfPassengers;

        }else {
            System.out.println("Vous avez choisi un vaisseau civil.");
        }

        switch (planetName){
            case("Terre"):
                terre.welcomeVessels(choosenVessel);
                break;
            case("Mars"):
                mars.welcomeVessels(choosenVessel);
                break;
            default:
                break;
        }
        refusedQuantity=choosenVessel.carryCargo(tonnageCargo);
        System.out.println("Tonnage rejeté lors du chargement  du vaisseau de type "+vesselType+" : "+refusedQuantity+" tonnes.");


        System.exit(0);
        Vessel civilVessel=new CivilianVessel();
        civilVessel.type="WORLD-VESSEL";
        cruiser.activateShield();
        ((WarVessel) cruiser).attack(civilVessel,"lasers photoniques",3);



        hunter.numberOfPassengers=9;
        refusedQuantity=hunter.carryCargo(20);
        System.out.println("Quantité refusée : "+refusedQuantity);


        frigate.numberOfPassengers=100;
        refusedQuantity=frigate.carryCargo(45);
        System.out.println("currentTonnage : " +frigate.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);
        refusedQuantity=frigate.carryCargo(12);
        System.out.println("currentTonnage : " +frigate.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);

        WarVessel frigate2=new WarVessel("FRIGATE");
        frigate2.numberOfPassengers=14;
        refusedQuantity=frigate2.carryCargo(30);
        System.out.println("currentTonnage : " +frigate2.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);

        CivilianVessel cv=new CivilianVessel("WORLD-VESSEL");
        refusedQuantity=cv.carryCargo(1560);
        System.out.println("currentTonnage : " +cv.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);


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
        //CivilianVessel worldVessel=new CivilianVessel("VAISSEAU-MONDE",4784,30);
        hunterVessel.activateShield();
        worldVessel.activateShield();
        hunterVessel.attack(worldVessel,"lasers photoniques",3);
        worldVessel.deactivateShield();
        System.out.println("Durée de protection résiduelle du bouclier du vaisseau-Monde : "+worldVessel.shieldDurationCapability);
        System.out.println("Valeur du blindage du bouclier du vaisseau-Monde : "+worldVessel.armourResistanceCapability);


    }
}
