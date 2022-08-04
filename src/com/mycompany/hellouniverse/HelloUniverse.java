package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        String declaration = "En %d, les planètes du système solaire étaient au nombre de : %d.";
        int nombreDePlanetes=9;
        short annee=2003;

        if (annee>=2006) {
            nombreDePlanetes--;
        }
        System.out.printf(declaration,annee,nombreDePlanetes);
    }
}
