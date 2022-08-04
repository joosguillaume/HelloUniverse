package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        System.out.println("Hello Universe!");
        int nombreDePlanetes=8;
        int annee=2006;

        if (annee<2006) {
            nombreDePlanetes++;
            System.out.printf("En %d, les planètes du système solaire étaient au nombre de : %d",annee,nombreDePlanetes);
        }

        if (annee>=2006) {
            System.out.printf("En %d, les planètes du système solaire étaient au nombre de : %d",annee,nombreDePlanetes);
        }
    }
}
