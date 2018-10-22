package main.java.MasterMind;

import java.util.*;

public class GameModeM {
    public static Scanner scanner = new Scanner(System.in);


    public static void Mastermind() {
        String code;
        int nbChiffres = 7;
        int MAX = 9;
        int maxTry = 20;
        int[] codeEntre = new int[nbChiffres];
        int[] solution = new int[nbChiffres];
        int count = 0;
        int i;
        Random r = new Random();
        for (i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }
        System.out.println(Arrays.toString(solution));
        do {
            System.out.println("Veuillez rentrez une combinaison de chiffres");
            code = Integer.toString(scanner.nextInt());

            List<Integer> goodMatches = new ArrayList<>();
            List<Integer> approximativeMatches = new ArrayList<>();
            List<Integer> wrongNumber = new ArrayList<>();
            for (i = 0; i < nbChiffres; i++) {

                codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                if (codeEntre[i] == solution[i]) {
                    goodMatches.add(i);
                } else {
                    boolean foundMatch = false;
                    for (int j = 0; j < nbChiffres; j++) {
                        if (codeEntre[i] == solution[j] && i != j && !goodMatches.contains(j)) {
                            approximativeMatches.add(i);
                            foundMatch = true;
                            break;
                        }
                    }
                    if (!foundMatch) wrongNumber.add(i);
                }
            }
            count++;
            if (goodMatches.size() == nbChiffres)
                System.out.println("Vous avez tout trouvé");
            else {
                System.out.println("Il y a " + goodMatches.size() + "bons chiffres bien placés et "
                        + approximativeMatches.size() + "bon chiffre mal placés et " + wrongNumber.size()
                        + " mauvais chiffre");
            }
        } while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry);

        if (Arrays.toString(codeEntre).equals(Arrays.toString(solution))) {
            System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            scanner.close();
        } else {
            System.out.println("vous n'avez  pas trouvé le code");
            scanner.close();
        }
    }
    public static void MastermindDefense() {
        int nbChiffres = 7;
        int MAX = 9;
        int maxTry = 20;
        int[] codeEntre = new int[nbChiffres];
        int[] solution = new int[nbChiffres];
        int count = 0;
        int i;
        int h;
        Random r = new Random();
        for (i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }
        System.out.println(Arrays.toString(solution));
        List<Integer> goodMatches = new ArrayList<>();
        List<Integer> approximativeMatches = new ArrayList<>();
        List<Integer> wrongNumber = new ArrayList<>();
        do {
            // verif bien , mal place et non */
          for(h = 0; h < nbChiffres;h++) {
              for (i = 0; i < nbChiffres; i++) {
                  if (codeEntre[i] == solution[i]) {
                      goodMatches.add(i);

                  } else {
                      boolean foundMatch = false;
                      for (int j = 0; j < nbChiffres; j++) {
                          if (codeEntre[i] == solution[j] && i != j && !goodMatches.contains(j)) {
                              approximativeMatches.add(i);
                              foundMatch = true;
                              break;
                          }
                      }
                      if (!foundMatch) wrongNumber.add(i);
                  }
              }
          }
                count++;
                if (goodMatches.size() == nbChiffres)
                    System.out.println("Vous avez tout trouvé");
                else {
                    System.out.println("Il y a " + goodMatches.size() + "bons chiffres bien placés et "
                            + approximativeMatches.size() + "bon chiffre mal placés et " + wrongNumber.size()
                            + " mauvais chiffre");
                }
        }while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry );
        if (Arrays.toString(codeEntre).equals(Arrays.toString(solution))) {
                System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            } else {
                System.out.println("vous n'avez  pas trouvé le code");
            }
        }
    }