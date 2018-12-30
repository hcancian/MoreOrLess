package fr.hadrien.mastermind;

import fr.hadrien.mastermind.Mastermind.GameModeM;
import fr.hadrien.mastermind.MoreOrLess.GameMode;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Interface {

    Scanner scanner = new Scanner(System.in);
    Properties properties = new Properties();

    GameMode gameMode = new GameMode(Integer.parseInt(getPropValues(1)),
            Integer.parseInt(getPropValues(2)),Boolean.parseBoolean(getPropValues(3)));
    GameModeM gameModeM = new GameModeM(Integer.parseInt(getPropValues(1)),
            Integer.parseInt(getPropValues(2)),Boolean.parseBoolean(getPropValues(3))
            ,Integer.parseInt(getPropValues(4)));

    public  String getPropValues(int nb) {
        /**
         * Charge la liste des propriétés contenu dans le fichier spécifié
         *
         * @param filename le fichier contenant les propriétés
         * @return un objet Properties contenant les propriétés du fichier
         */
        String configPath = "src/main/resources/config.properties";
        try {
            FileInputStream in = new FileInputStream(configPath);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
        String solutionLenght = properties.getProperty("solutionLenght");
        String maxTry = properties.getProperty("maxTry");
        String dev = properties.getProperty("dev");
        String numberUse = properties.getProperty("numberUse");

        String[] valeurs = {solutionLenght, maxTry, dev,numberUse};
        if (nb == 1)
            return valeurs[0];
        else if (nb == 2)
            return valeurs[1];
        else if(nb == 3)
            return valeurs[2];
        else
            return valeurs[3];
    }


    public void menuEnd() {
        System.out.println("Option 1 : quitter le jeu ");
        System.out.println("Option 2 : lancer le MoreOrLess en mode challenger");
        System.out.println("Option 3 :lancer le MoreOrLess en  le mode defenseur");
        System.out.println("Option 4 : lancer le MoreOrLess en  le mode duel");
        System.out.println("Option 5 : lancer le Mastermind en challenger");
        System.out.println("Option 6 : lancer le Mastermind en defenseur");
        System.out.println("Option 7 : lancer le Mastermind en duel");
        int options = scanner.nextInt();
        switch (options){
            case 1:
                break;
            case 2 :
                gameMode.Challenger();
                break;
            case 3:
                gameMode.Defenseur();
                break;
            case 4:
                gameMode.Duel();
                break;
            case 5:
                gameModeM.Mastermind();
                break;
            case 6:
                gameModeM.MastermindDefense();
                break;
            case 7:
                gameModeM.MastermindDuel();
                break;
        }
    }

    public  void Menu() {

        System.out.println("Veuillez entrez dans le jeu de votre choix : \n");
        System.out.println("1 : MoreOrLess \n");
        System.out.println("2 : MasterMind \n");
        try {
            int Game = scanner.nextInt();
            switch (Game) {
                case 1:
                    System.out.println("- Vous avez choisis le MoreOrLess");
                    System.out.println("Veuillez choisir le mode auquel vous souhaitez jouer :");
                    System.out.println("1 : Mode Challenger");
                    System.out.println("2 : Mode Defenseur ");
                    System.out.println("3 : Mode Duel");

                    int Mode = scanner.nextInt();
                    switch (Mode) {
                        case 1:
                            System.out.println("Vous avex choisi le mode challenger");
                            try {
                                gameMode.Challenger();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Vous avex choisi le mode defenseur");
                            try {
                                gameMode.Defenseur();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("Vous avex choisi le mode Duel");
                            try {
                                gameMode.Duel();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                    }
                    break;
                case 2:
                    System.out.println("- Vous avez choisis le MasterMind");
                    System.out.println("Veuillez choisir le mode auquel vous souhaitez jouer :  ");
                    System.out.println("1 : Mode Challenger");
                    System.out.println("2 : Mode Defenseur");
                    System.out.println("3 : Mode Duel");
                    Mode = scanner.nextInt();
                    switch (Mode) {
                        case 1:
                            System.out.println("Vous avex choisi le mode challenger");
                            try {
                                gameModeM.Mastermind();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Vous avex choisi le mode défenseur");
                            try {
                                gameModeM.MastermindDefense();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("Vous avex choisi le mode Duel");
                            try {
                                gameModeM.MastermindDuel();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                    }
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

