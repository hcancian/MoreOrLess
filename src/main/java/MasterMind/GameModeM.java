package main.java.MasterMind;

import java.util.Random;
import java.util.Scanner;

public class GameModeM {
    private static final char OK = 'o';
    private static final char FAUX = 'x';

    public static void Mastermind(){
     {
            Scanner sc = new Scanner (System.in);
            int NB_CHIFFRES = 7; // on pourrait aussi demander à l'utilisateur
            int MAX = 7; // de saisir ces valeurs
            int ESSAIS_MAX = 10;

            int[] solution = new int[NB_CHIFFRES];

            Random r = new Random();
            for(int i=0 ; i<NB_CHIFFRES ; i++) {
                solution[i] = r.nextInt(MAX+1);
            }

            int count = 0;

            System.out.println("Mastermind, trouve la combinaison des " + NB_CHIFFRES + " chiffres entre 0 et " + MAX + ".");
            System.out.println( OK + " siginife que c'est le bon chiffre à la bonne place et " + FAUX + "signifie que c'est le mauvais chiffre.");
            System.out.println("Attention, vous avez droit a " + ESSAIS_MAX + " essais");
            System.out.println("----------------------------");


            int[] chiffres = new int[NB_CHIFFRES];
            boolean victoire = false;
            do {
                System.out.println("\nEssai n° " + (count+1) + "/" + ESSAIS_MAX + " :");
                int nombreSaisi = sc.nextInt();
                // ça parâit très compliqué mais en fait
                // ce calcul se contente "juste" de récupérer le chiffre à la position
                // i dans nombreSaisi
                for(int i=0 ; i<NB_CHIFFRES ; i++)
                    chiffres[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES-i-1)) ))%10;

                // On écrit la proposition du joueur
                for(int i=0 ; i<NB_CHIFFRES ; i++)
                    System.out.print(chiffres[i] + " ");
                System.out.println();// on passe à la ligne


                victoire = true; // on met à vrai pour l'instant
                for(int i=0 ; i<NB_CHIFFRES ; i++) {
                    boolean bonChiffre = chiffres[i] == solution[i];
                    System.out.print( (bonChiffre ? OK : FAUX) + " "); // instruction ternaire
                /* La ligne au dessus équivaut à tout le bloc if else dessous
                if(bonChiffre)
                    System.out.println(ok + " ");
                else System.out.println(faux + " ");
                */

                    victoire = victoire && bonChiffre; // victoire sera vrai UNIQUEMENT si bonChiffre vaut vrai a CHAQUE tour de boucle
                }
                System.out.println(); // on passe à la ligne

                count++;

                if(count == ESSAIS_MAX)
                    System.out.println("He non, vous avez epuisé vos " + ESSAIS_MAX + " essais, c'est perdu pour vous...");

            }while(!victoire && count < ESSAIS_MAX);
            System.out.println("En seulement "+count+ " coups");
            sc.close();
        }
    }
}
