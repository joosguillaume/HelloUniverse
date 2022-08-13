package com.mycompany.hellouniverse;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloUniverse {
    public static void main(String... args){
        System.out.println("Nombre de planètes découvertes : "+Planet.numberOfDiscoveredPlanets);
        TelluricPlanet mercure = new TelluricPlanet("Mercure",2);
        mercure.diameter = 4880;
        TelluricPlanet venus = new TelluricPlanet("Venus",2);
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

        Galaxy solarSystem = new Galaxy("Système Solaire");
        Planet myPlanet = null;
        solarSystem.addPlanets(mercure,venus,terre,mars,jupiter,saturne,uranus,neptune);

        for (int i=0;i<8;i++){
            myPlanet=solarSystem.planets.get(i);
            if(myPlanet instanceof TelluricPlanet){
                System.out.println("Tellurique");
                System.out.println("planète à l'index "+i+" : "+myPlanet.name+" de type "+((TelluricPlanet) myPlanet).material);
            }else{
                System.out.println("Gazeuse");
                System.out.println("planète à l'index "+i+" : "+myPlanet.name+" de type "+((GaseousPlanet) myPlanet).material);
            }
        }

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

        WarVessel hunter1=new WarVessel(TypeVaisseau.HUNTER);
        WarVessel hunter2=new WarVessel(TypeVaisseau.HUNTER);
        CivilianVessel cargo1=new CivilianVessel(TypeVaisseau.CARGO);

        terre.welcomeVessels(hunter1,hunter2,cargo1);

        String vesselType;
        //String planetName;
        int tonnageCargo;
        int numberOfPassengers;
        boolean continuerTraitement=false;
        int refusedQuantity = 0;
        Scanner sc=new Scanner(System.in);
        Vessel choosenVessel = null;
        TelluricPlanet choosenPlanet = null;
        int indexChoosenPlanet = 0;
        do {
            System.out.println("Quel vaisseau voulez-vous manipuler (HUNTER,FRIGATE,CRUISER,CARGO,WORLD_VESSEL)?");
            vesselType = sc.nextLine();
            System.out.println("Vous voulez manipuler un vaisseau de type " + vesselType + ".");
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(vesselType);
            System.out.println("Vous voulez manipuler un vaisseau de type " + typeVaisseau.name + ".");
            //System.out.println("Sur quelle planète tellurique voulez-vous que le vaisseau de type " + vesselType + " se pose?");
            //planetName = sc.nextLine();

            do {
                continuerTraitement=true;
                System.out.println("Quel est l'index de la planète (0 à 7)?");
                indexChoosenPlanet = sc.nextInt();
                sc.nextLine();

                myPlanet = solarSystem.planets.get(indexChoosenPlanet);
                if (myPlanet instanceof GaseousPlanet) {
                    System.out.println("Veuillez choisir une planète tellurique.");
                    continuerTraitement = false;
                }
            }while(!continuerTraitement);

            System.out.println("Vous avez choisi la planète "+((TelluricPlanet) myPlanet).name);
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
            int indexOfTypeCol=0;
            if (choosenVessel instanceof WarVessel) {
                System.out.println("Vous avez choisi un vaisseau de guerre.");
                System.out.println("Un vaisseau de guerre doit avoir des passagers pour pouvoir embarquer une cargaison.");
                System.out.println("Combien de passagers voulez-vous?");
                numberOfPassengers = sc.nextInt();
                choosenVessel.numberOfPassengers = numberOfPassengers;

            } else {
                indexOfTypeCol=1;
                System.out.println("Vous avez choisi un vaisseau civil.");
            }
/*
            switch (myPlanet) {
                case ("Terre"):
                    choosenPlanet=terre;
                    terre.welcomeVessel(choosenVessel);
                    break;
                case ("Mars"):
                    choosenPlanet=mars;
                    mars.welcomeVessel(choosenVessel);
                    break;
                default:
                    break;
            }
 */
            choosenPlanet=((TelluricPlanet) myPlanet);
            choosenPlanet.welcomeVessel(choosenVessel);
            refusedQuantity = choosenVessel.carryCargo(tonnageCargo);
            System.out.println("Tonnage rejeté lors du chargement  du vaisseau de type " + vesselType + " : " + refusedQuantity + " tonnes.");

            if (choosenPlanet.roomLeft(indexOfTypeCol)) {
                //faire accoster le vaisseau
                System.out.println("Le vaisseau a accosté sur "+choosenPlanet.name+" à la place "+indexOfTypeCol+"/"+ choosenPlanet.freeIndex(indexOfTypeCol));
                choosenPlanet.dockingBay[indexOfTypeCol][choosenPlanet.freeIndex(indexOfTypeCol)] = hunter;
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

        Vessel vesselOut=mars.welcomeVessel(hunter);
        if(vesselOut!=null){
            System.out.println("Un vaisseau de type "+vesselOut.type.name+" doit s'en aller.");
        }else{
            System.out.println("Auncun vaisseau ne s'en va.");
        }
        CivilianVessel civilianVessel=new CivilianVessel();
        civilianVessel.type=TypeVaisseau.WORLD_VESSEL;
        hunter.attack(civilianVessel,"lasers photoniques",3);
        vesselOut=mars.welcomeVessel(civilianVessel);
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
