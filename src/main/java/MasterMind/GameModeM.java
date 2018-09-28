package main.java.MasterMind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameModeM {
    public static String good = "bien placés";
    public static String almost = "bon chiffre mais mauvaise place";
    public static Scanner scanner = new Scanner(System.in);


    public static void Mastermind()
    {
        String code;
        int nbChiffres = 7;
        int MAX = 9;
        int ESSAIS_MAX = 20;
        int[] codeEntre = new int[nbChiffres];
        int[] solution = new int[nbChiffres];

        Random r = new Random();
        for (int i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }
        System.out.println(Arrays.toString(solution));
        int count = 0;
        int j;
        int countgood = 0;
        int countalmost = 0;
        do {
            code = Integer.toString(scanner.nextInt());
            for (int i = 0; i < nbChiffres; i++) {

                for (j = 0; j < nbChiffres; j++) {
                    codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                    System.out.println(Arrays.toString(codeEntre));
                    if (codeEntre[i] == solution[j])
                        countalmost++;
                    else if (i == j)
                        countgood++;
                }
            }
            System.out.println("Il y a " +countalmost+ "bons chiffres mal placé et "+ countgood +
                    "bon chiffre bien placés");
            count++;
            scanner.close();
        }while(countgood != nbChiffres &&count <=ESSAIS_MAX);
        System.out.println("En seulement " + count + " coups");
    }
}