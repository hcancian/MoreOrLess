package main.java.MasterMind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameModeM {
    public static Scanner scanner = new Scanner(System.in);


    public static void Mastermind() {
        String code;
        int nbChiffres = 7;
        int MAX = 9;
        int maxTry = 20;
        int diff = 0 ;
        int[] codeEntre = new int[nbChiffres];
        int[] solution = new int[nbChiffres];
        int count = 0;
        int i;
        int countgood = 0;
        int countalmost = 0;
        Random r = new Random();
        for (i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }
        System.out.println(Arrays.toString(solution));
        do {
            System.out.println("Veuillez rentrez une combinaison de chiffres");
            code = Integer.toString(scanner.nextInt());
            for (i = 0; i < nbChiffres; i++) {
                try {
                    codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("invalid input");
                }
                for (int j = 0; j < nbChiffres; j++) {
                    if (codeEntre[i] == solution[j] && j == i) {
                        countgood++;
                    }
                    else if(codeEntre[i] == solution[j] && i!=j ){
                        countalmost++;
                    }
                }
            }
                count++;
            if(countgood == nbChiffres)
                System.out.println("Il y a 0 bons chiffres mal placé et " + countgood +
                        "bon chiffre bien placés");
            else {
                diff = nbChiffres - countalmost;
                countalmost = countalmost - diff;
                System.out.println("Il y a " + countalmost + "bons chiffres mal placé et " + countgood +
                        "bon chiffre bien placés");
            }
                countgood = 0;
                countalmost = 0;
            } while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry);
        if (Arrays.toString(codeEntre).equals(Arrays.toString(solution)))
        {   System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            scanner.close();
        }else{
            System.out.println("vous n'avez  pas trouvé le code");
            scanner.close();
        }
    }
    /*public static void MastermindDuel() {
        String code;
        int nbChiffres = 7;
        int MAX = 9;
        int maxTry = 20;
        int[] codeEntre = new int[nbChiffres];
        int[] solution = new int[nbChiffres];
        int count = 0;
        int i;
        int countgood = 0;
        int countalmost = 0;
        Random r = new Random();
        for (i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }
        System.out.println(Arrays.toString(solution));
        do {
            System.out.println("Veuillez rentrez une combinaison de chiffres");
            code = Integer.toString(scanner.nextInt());
            for (i = 0; i < nbChiffres; i++) {
                try {
                    codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("invalid input");
                }
                for (int j = 0; j < nbChiffres; j++) {
                    if (codeEntre[i] == solution[j] && j == i) {
                        countgood++;
                    }
                    else if(codeEntre[i] == solution[j] && j != i){
                        countalmost++;
                    }
                }
            }
            count++;
            System.out.println("Il y a " + countalmost + "bons chiffres mal placé et " + countgood +
                    "bon chiffre bien placés");
            countgood = 0;
            countalmost = 0;
        } while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry);
        if (Arrays.toString(codeEntre).equals(Arrays.toString(solution)))
        {   System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            scanner.close();
        }else{
            System.out.println("vous n'avez  pas trouvé le code");
            scanner.close();
        }
    }*/
}