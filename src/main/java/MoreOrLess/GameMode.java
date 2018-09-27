package main.java.MoreOrLess;
import java.awt.*;
import java.lang.Math;
import java.util.Random;


public class GameMode {

    public static boolean isAnInteger(String code) {
        try {
            code.matches("^\\p{Digit}+$");
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void Challenger(String code) {
        String secret = "2345678";

        boolean testInt;
        testInt = isAnInteger(code);
        int s = code.length();
        int i = 0;
        int nbTry = 10;
        int compteur = 0;
        int secretCode[] = new int[s];
        int codeEntre[] = new int[s];
        String tabNum[] = new String[code.length()];
        Random r = new Random();
        for ( i = 0; i < s; i++) {
            System.out.println(secret);
            codeEntre[i] = code.charAt(i);
            secretCode[i] = code.charAt(i);
        }
        if (testInt == false) {
            System.out.println("La chaine de caractere n'est pas composé de chiffre");
        }else if (s != code.length()) {
            System.out.println("Il n'y a pas " + s + " chiffres");
        } else {
            boolean victoire = false;
            do{
                System.out.println("Essaie " + compteur+1 + "sur " +nbTry);
                for( i=0 ; i<s ; i++)
                    System.out.print(codeEntre[i] + " ");
                System.out.println();
                victoire = true;
                for (i = 0; i<s;i++){
                    if(codeEntre[i] == secretCode[i])
                        tabNum[i] = "=";
                    else if((codeEntre[i] > secretCode[i]))
                        tabNum[i] = "-";
                        else
                        tabNum[i] = "+";
                }
            }while(!victoire && compteur < nbTry);
        }
    }
}


    /* public static void Defense(){
         int [] secret = {1,2,6,5,9,3,4};
         int s = secret.length;
         int[] code = new int[7];
         String[] tabNum = new String[s];
         int i;
         for(i = 0; i < s;i++){
             code[i] = ((int)(Math.random() * (9 +1)));
              if (code[i] == secret[i]) {
                 tabNum[i] = "=";
             } else if (code[i] < secret[i]) {
                 tabNum[i] = "+";
             } else if (code[i] > secret[i])
                 tabNum[i] = "-";
         }
         System.out.println(Arrays.toString(secret));
         System.out.println(Arrays.toString(code));
         System.out.println(Arrays.toString(tabNum));
     }
 }*/

