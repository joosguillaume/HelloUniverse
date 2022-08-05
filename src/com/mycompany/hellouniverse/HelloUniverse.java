package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        String declaration = "En %d, les planètes du système solaire étaient au nombre de : %d.";
        int nombreDePlanetes=0;
        short annee=2021;

        if (annee<1600 || annee>2020) {
            System.out.printf("Le programme ne peut pas fournir de résultat pour l'année %d.",annee);
        } else {
            if (annee<1700) {
                nombreDePlanetes=7;
            } else if (annee<1800 || annee>=2006) {
                    nombreDePlanetes=8;
                } else {
                        nombreDePlanetes=9;
            }
            System.out.printf(declaration,annee,nombreDePlanetes);
        }
    }
}
