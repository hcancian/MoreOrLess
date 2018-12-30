package fr.hadrien.mastermind.MoreOrLess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameMode {
    Scanner scanner = new Scanner(System.in);
    int solutionLength;
    int maxTry;
    boolean dev;
    Logger logger = LogManager.getLogger();

    public GameMode(int solutionLength, int maxTry, boolean dev) {
        this.solutionLength = solutionLength;
        this.maxTry = maxTry;
        this.dev = dev;
    }



    public void Challenger() {
        logger.info("Lancement du mode Challenger du jeu MoreOrLess");
        String code;
        String number = "0123456789";
        String verif = "";
        int length = number.length();
        Random rand = new Random();

        char[] codeEntre = new char[solutionLength];
        char[] secretEntre = new char[solutionLength];
        int i;
        for (i = 0; i < solutionLength; i++) {
            int k = rand.nextInt(length);
            secretEntre[i] = number.charAt(k);
        }
        int compteur = 0;

        if (dev == true) {
            System.out.println(Arrays.toString(secretEntre));
        }
        do {
            System.out.println("Veuillez rentrez une combinaison de "+solutionLength+" chiffres");
            code = scanner.next();
            logger.info("Saisie du code par le joueur");
            try {
                Integer.parseInt(code);
                if (code.length() == solutionLength) {
                    for (i = 0; i < solutionLength; i++) {
                        codeEntre[i] = code.charAt(i);
                        if (codeEntre[i] == secretEntre[i])
                            verif += "=";
                        else if (codeEntre[i] < secretEntre[i])
                            verif += "+";
                        else if (codeEntre[i] > secretEntre[i])
                            verif += "-";
                    }
                    System.out.println("Vous avez tapé : " + code + " Etat : " + verif);
                    verif = "";
                    compteur++;
                } else {
                    System.out.println("pas assez de chiffre ou trop de chiffre");
                }
            } catch (NumberFormatException e) {
                System.out.println("La chaine de caractere n'est pas composé de chiffre");
            }
        } while (!Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre)) && compteur <= maxTry);
        if (Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) {
            System.out.println("vous avez trouvé le code");
        } else {
            System.out.println("vous n'avez  pas trouvé le code");
        }
    }

    public void Defenseur() {
        logger.info("Lancement du mode Defenseur du jeu MoreOrLess");
        Random r = new Random();
        String verif = "";

        int[] codeEntre = new int[solutionLength];
        int[] secretEntre = new int[solutionLength];
        int i;
        int compteur = 0;
        for (i = 0; i < solutionLength; i++) {
            codeEntre[i] = r.nextInt(9 + 1);
            secretEntre[i] = r.nextInt(9 + 1);
        }
        logger.info("Saisie du code par l'IA");

        do {
            if (dev == true)
            System.out.println(Arrays.toString(secretEntre));

            for (i = 0; i < solutionLength; i++) {
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
            System.out.println("Vous avez tapé : " + Arrays.toString(codeEntre) + " Etat : " + verif);
            verif = "";
            compteur++;
        } while ((!Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) && compteur <= maxTry);
        if (Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) {
            System.out.println("vous avez trouvé le code");
        } else {
            System.out.println("vous n'avez  pas trouvé le code");
        }
    }

    public void Duel() {
        logger.info("Lancement du mode Duel du jeu MoreOrLess");
        //Pour l'ia
        Random r = new Random();
        String verifIA = "";
        int[] codeEntreIA = new int[7];
        int[] secretEntreIA = new int[7];

        int i;
        int compteurIA = 0;
        for (i = 0; i < 6; i++) {
            codeEntreIA[i] = r.nextInt(9 + 1);
            secretEntreIA[i] = r.nextInt(9 + 1);
        }

        boolean iaWin = false;
        //Pour le Joueur
        String code;
        String number = "0123456789";
        String verif = "";
        int length = number.length();
        Random rand = new Random();
        char[] codeEntre = new char[solutionLength];
        char[] secretEntre = new char[solutionLength];
        for (i = 0; i < solutionLength; i++) {
            int k = rand.nextInt(length);
            secretEntre[i] = number.charAt(k);
        }
        int compteur = 0;
        if (dev == true) {
            System.out.println(Arrays.toString(secretEntre));
        }
        boolean playerWin = false;
        //Pour les 2
        String winner = "";
        do {
            code = scanner.next();
            logger.info("Saisie du code par le joueur");

            try {
                Integer.parseInt(code);
                if (code.length() == solutionLength) {
                    for (i = 0; i < solutionLength; i++) {
                        codeEntre[i] = code.charAt(i);

                        if (codeEntre[i] == secretEntre[i])
                            verif += "=";
                        else if (codeEntre[i] < secretEntre[i])
                            verif += "+";
                        else if (codeEntre[i] > secretEntre[i])
                            verif += "-";
                    }
                }
                System.out.println("Vous avez tapé : " + code + " Etat : " + verif);
                verif = "";
                if (Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) {
                    System.out.println("vous avez trouvé le code");
                    logger.info("Victoire du joueur");
                    winner = "le Joueur";
                    playerWin = true;
                }
                compteur++;
            } catch (NumberFormatException e) {
                System.out.println("La chaine de caractere n'est pas composé de chiffre");
            }

            for (i = 0; i < 7; i++) {
                if (codeEntreIA[i] == secretEntreIA[i])
                    verifIA += "=";
                else if (codeEntreIA[i] < secretEntreIA[i]) {
                    verifIA += "+";
                    codeEntreIA[i] = codeEntreIA[i] + 1;
                } else if (codeEntreIA[i] > secretEntreIA[i]) {
                    verifIA += "-";
                    codeEntreIA[i] = codeEntreIA[i] - 1;
                }

            }
            logger.info("Saisie du code par l'IA" +Arrays.toString(codeEntreIA));
            System.out.println("L'IA a tapé : " + Arrays.toString(codeEntreIA) + " Etat : " + verifIA);
            verifIA = "";
            if (Arrays.toString(codeEntreIA).equals(Arrays.toString(secretEntreIA))) {
                System.out.println("L'IA a trouvé le code");
                logger.info("Victoire de l'IA");
                winner = "l'IA";
                iaWin = true;
                compteurIA++;
            }
        } while (playerWin == false && compteur <= maxTry && iaWin == false && compteurIA <= maxTry);
        if (!Arrays.toString(codeEntreIA).equals(Arrays.toString(secretEntreIA))) {
            System.out.println("l'IA n'a  pas trouvé le code");
        }
        if (!Arrays.toString(codeEntre).equals(Arrays.toString(secretEntre))) {
            System.out.println("vous n'avez  pas trouvé le code");
        }
        logger.info("Fin du mode de jeu Duel pour le MoreOrLess avec comme gagnant " + winner);
    }
}
