package com.mycompany.hellouniverse;

public class HelloUniverse {
    public static void main(String... args){
        for (int nombreDePlanetes=7;nombreDePlanetes<10;nombreDePlanetes++){
            switch (nombreDePlanetes){
                case 7:
                    System.out.printf("On sait qu'au 16ème siècle, seules %d planètes avaient été découvertes",nombreDePlanetes);
                    break;
                case 8:
                    System.out.printf("On sait que le nombre de planètes est passé de 7 à %d au 17ème siècle, mais il a également été réduit de 9 à %d en 2006",nombreDePlanetes,nombreDePlanetes);
                    break;
                case 9:
                    System.out.printf("On sait que le nombre de planètes est passé de 8 à %d au 18ème siècle et ce jusqu'en 2006, où ce nombre a été réduit à 8",nombreDePlanetes);
                    break;
                default:
                    System.out.printf("Le programme ne peut pas fournir de résultat pour %d",nombreDePlanetes);
            }
            System.out.println("");
        }


    }
}
