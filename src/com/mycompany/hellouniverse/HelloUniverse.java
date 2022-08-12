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
        TelluricPlanet terre = new TelluricPlanet("Terre",4);
        terre.diameter = 12756;
        TelluricPlanet mars = new TelluricPlanet("Mars",4);
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
        System.out.println("Sa baie accostage a "+mars.dockingBay.length+" places.");
        int nombreDeRevolution=0;
        int nombreDeRotation=0;
        nombreDeRevolution=neptune.revolution(-3542);
        System.out.println(neptune.name+" a effectué "+nombreDeRevolution+" tours complets autour de son étoile.");
        nombreDeRotation=mars.rotation(-684);
        System.out.println(mars.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");

        nombreDeRotation=venus.rotation(1250);
        System.out.println(venus.name+" a effectué "+nombreDeRotation+" tours complets sur elle-même.");


        WarVessel hunter=new WarVessel(TypeVaisseau.HUNTER);
        WarVessel frigate=new WarVessel(TypeVaisseau.FRIGATE);
        WarVessel cruiser=new WarVessel(TypeVaisseau.CRUISER);
        CivilianVessel cargo=new CivilianVessel(TypeVaisseau.CARGO);
        CivilianVessel worldVessel=new CivilianVessel(TypeVaisseau.WORLD_VESSEL);

        String vesselType;
        String planetName;
        int tonnageCargo;
        int numberOfPassengers;
        boolean continuerTraitement=false;
        int refusedQuantity = 0;
        Scanner sc=new Scanner(System.in);
        Vessel choosenVessel = null;
        TelluricPlanet choosenPlanet = null;

        do {
            System.out.println("Quel vaisseau voulez-vous manipuler (HUNTER,FRIGATE,CRUISER,CARGO,WORLD_VESSEL)?");
            vesselType = sc.nextLine();
            System.out.println("Vous voulez manipuler un vaisseau de type " + vesselType + ".");
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(vesselType);
            System.out.println("Vous voulez manipuler un vaisseau de type " + typeVaisseau.name + ".");
            System.out.println("Sur quelle planète tellurique voulez-vous que le vaisseau de type " + vesselType + " se pose?");
            planetName = sc.nextLine();
            System.out.println("Quel tonnage voulez-vous que le vaisseau emporte?");
            tonnageCargo = sc.nextInt();
            System.out.println("Le vaisseau " + typeVaisseau.name + " va embarquer " + tonnageCargo + " tonnes.");


            refusedQuantity = 0;

            switch (typeVaisseau) {
                case HUNTER:
                    choosenVessel = hunter;
                    break;
                case FRIGATE:
                    choosenVessel = frigate;
                    break;
                case CRUISER:
                    choosenVessel = cruiser;
                    break;
                case CARGO:
                    choosenVessel = cargo;
                    break;
                case WORLD_VESSEL:
                    choosenVessel = worldVessel;
                    break;
            }
            if (choosenVessel instanceof WarVessel) {
                System.out.println("Vous avez choisi un vaisseau de guerre.");
                System.out.println("Un vaisseau de guerre doit avoir des passagers pour pouvoir embarquer une cargaison.");
                System.out.println("Combien de passagers voulez-vous?");
                numberOfPassengers = sc.nextInt();
                choosenVessel.numberOfPassengers = numberOfPassengers;

            } else {
                System.out.println("Vous avez choisi un vaisseau civil.");
            }

            switch (planetName) {
                case ("Terre"):
                    choosenPlanet=terre;
                    terre.welcomeVessels(choosenVessel);
                    break;
                case ("Mars"):
                    choosenPlanet=mars;
                    mars.welcomeVessels(choosenVessel);
                    break;
                default:
                    break;
            }
            refusedQuantity = choosenVessel.carryCargo(tonnageCargo);
            System.out.println("Tonnage rejeté lors du chargement  du vaisseau de type " + vesselType + " : " + refusedQuantity + " tonnes.");

            if (choosenPlanet.roomLeft()) {
                //faire accoster le vaisseau
                System.out.println("Le vaisseau a accosté sur "+choosenPlanet.name+" à la place " + choosenPlanet.freeIndex());
                choosenPlanet.dockingBay[choosenPlanet.freeIndex()] = hunter;
            } else {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète "+choosenPlanet.name+" par manque de place dans la baie.");
            }
            sc.nextLine();
            System.out.println("Voulez-vous recommencer (oui/non) ?");
            continuerTraitement = sc.nextLine().equals("oui");
            System.out.println("continuer? " + continuerTraitement);
        }
        while(continuerTraitement);

        System.exit(0);

        Vessel vesselOut=mars.welcomeVessels(hunter);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type.name+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }
        CivilianVessel civilianVessel=new CivilianVessel();
        civilianVessel.type=TypeVaisseau.WORLD_VESSEL;
        hunter.attack(civilianVessel,"lasers photoniques",3);
        vesselOut=mars.welcomeVessels(civilianVessel);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }

        Vessel civilVessel=new CivilianVessel();
        civilVessel.type=TypeVaisseau.WORLD_VESSEL;
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

        WarVessel frigate2=new WarVessel(TypeVaisseau.FRIGATE);
        frigate2.numberOfPassengers=14;
        refusedQuantity=frigate2.carryCargo(30);
        System.out.println("currentTonnage : " +frigate2.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);

        CivilianVessel cv=new CivilianVessel(TypeVaisseau.WORLD_VESSEL);
        refusedQuantity=cv.carryCargo(1560);
        System.out.println("currentTonnage : " +cv.currentTonnage);
        System.out.println("Quantité refusée : "+refusedQuantity);


        System.out.println("Le nombre d'humains ayant déjà séjourné sur "+mars.name+" est actuellement de "+mars.totalVisitors +".");

        Atmosphere uranusAtmosphere=new Atmosphere();
        uranusAtmosphere.heliumRate=15f;
        uranusAtmosphere.hydrogenRate=new Float(83);
        uranusAtmosphere.methaneRate=new Float(2.5);
        uranusAtmosphere.azoteRate=new Float(0);
        uranus.atmosphere=uranusAtmosphere;

        System.out.println("L'atmosphère de la planète "+uranus.name+" est composée : ");
        System.out.println("A "+ uranus.atmosphere.hydrogenRate+ " % d'hydrogène");
        System.out.println("A "+ uranus.atmosphere.heliumRate+ " % d'hélium");
        System.out.println("A "+ uranus.atmosphere.methaneRate+ " % de méthane");
        System.out.println(uranus.atmosphere.azoteRate!=null?"A "+ uranus.atmosphere.azoteRate+ " % d'azote":"Pourcentage d'azote non défini");
        System.out.println(uranus.atmosphere.argonRate!=null?"A "+ uranus.atmosphere.argonRate+ " % d'argon":"Pourcentage d'argon non défini");
        System.out.println("La forme d'une planète est : "+Planet.shape);
        System.out.println("La forme de Mars est : "+mars.shape);

        System.out.println(Planet.expansion(10.5));
        System.out.println(Planet.expansion(14.2));
        System.out.println("Nombre de planètes découvertes : "+Planet.numberOfDiscoveredPlanets);

        WarVessel hunterVessel=new WarVessel(TypeVaisseau.HUNTER,156,2);
        //CivilianVessel worldVessel=new CivilianVessel("VAISSEAU-MONDE",4784,30);
        hunterVessel.activateShield();
        worldVessel.activateShield();
        hunterVessel.attack(worldVessel,"lasers photoniques",3);
        worldVessel.deactivateShield();
        System.out.println("Durée de protection résiduelle du bouclier du vaisseau-Monde : "+worldVessel.shieldDurationCapability);
        System.out.println("Valeur du blindage du bouclier du vaisseau-Monde : "+worldVessel.armourResistanceCapability);


    }
}
