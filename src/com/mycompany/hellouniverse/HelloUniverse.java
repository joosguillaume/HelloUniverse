package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        System.out.println("Hello Universe!");
        int nombreDePlanetes=8;
        String phraseDescription;
        phraseDescription="Aux dernières nouvelles, le nombre total de planètes dans le système solaire est de : ";
        System.out.println(phraseDescription + nombreDePlanetes);
        nombreDePlanetes++;
        phraseDescription="Il y a quelques années cependant, elles étaient au nombre de : ";
        System.out.println(phraseDescription + nombreDePlanetes);
    }
}
