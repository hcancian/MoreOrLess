package main.java.MoreOrLess;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class GameMode {

    Scanner scanner = new Scanner(System.in);

    public boolean isAnInteger(String code) {
        try {
            Integer.parseInt(code);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean stringLenght(String code, String s2) {
        int codeLenght = code.length();
        int s2Lenght = s2.length();
        try {
            s2Lenght = codeLenght;
            return true;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    public void Challenger() {
        String code;
        String secret = "1265934";
        String verif = "";

        int codeEntre;
        int secretEntre;
        int s = secret.length();
        int i;
        int compteur = 0;
        do {
            System.out.println("Veuillez rentrez une combinaison de chiffres");
            code = Integer.toString(scanner.nextInt());
            if (isAnInteger(code) == true) {
                if (stringLenght(code, secret) == true) {
                    for (i = 0; i < s; i++) {
                        codeEntre = Integer.parseInt(String.valueOf(code.charAt(i)));
                        secretEntre = Integer.parseInt(String.valueOf(secret.charAt(i)));

                        if (codeEntre == secretEntre)
                            verif += "=";
                        else if (codeEntre < secretEntre)
                            verif += "+";
                        else if (codeEntre > secretEntre)
                            verif += "-";
                    }
                    System.out.println("Vous avez tapé : " + code + " Etat : " + verif);
                    verif = "";
                    compteur++;
                } else {
                    System.out.println("pas assez de chiffre ou trop de chiffre");
                }
            } else
                System.out.println("La chaine de caractere n'est pas composé de chiffre");

        } while ((!code.equals(secret)) && compteur <= 10);
        if (code.equals(secret)) {
            System.out.println("vous avez trouvé le code");
            scanner.close();
        } else {
            System.out.println("vous n'avez  pas trouvé le code");
            scanner.close();
        }
    }
    public void Defenseur() {
        Random r = new Random();
        String verif = "";
        String code = "";
        String secret;
        int[] codeEntre = new int[4];
        int[] secretEntre = new int[4];

        int i;
        int compteur = 0;
        for (i = 0; i < 3; i++) {
            codeEntre[i] = r.nextInt(9 + 1);
            secretEntre[i] = r.nextInt(9 + 1);
        }
        do {
            System.out.println(Arrays.toString(secretEntre));

                    for (i = 0; i <4 ; i++) {
                        if (codeEntre[i] == secretEntre[i])
                            verif += "=";
                        else if (codeEntre[i] < secretEntre[i]) {
                            verif += "+";
                            codeEntre[i] = codeEntre[i] + 1;
                        } else if (codeEntre[i] > secretEntre[i]) {
                            verif += "-";
                            codeEntre[i] = codeEntre[i] - 1;
                        }
                    }
                    System.out.println("Vous avez tapé : " + Arrays.toString(codeEntre)+ " Etat : " + verif);
                    verif = "";
                    compteur++;
        } while ((!Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) && compteur <= 10);
        if (Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))){
            System.out.println("vous avez trouvé le code");
        } else {
            System.out.println("vous n'avez  pas trouvé le code");

        }
    }
}