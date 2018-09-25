import main.java.MoreOrLess.GameMode;

import java.awt.*;
import java.awt.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public  class main extends GameMode {

    public static void main  (String[] args) {


            {//String string = "1";
                System.out.println("Veuillez choisir un des 2 jeux suivants : \n");
                System.out.println("1 : MoreOrLess \n");
                System.out.println("2 : MasterMind \n");
                Scanner scanner = new Scanner(System.in);
                try {
                    int value = scanner.nextInt();
                    switch (value) {
                        case 1:
                            System.out.println("- Vous avez choisis le MoreOrLess");
                            System.out.println("Veuillez choisir le mode auquel vous souhaitez jouer :");
                            System.out.println("1 : Mode Challenger");
                            System.out.println("2 : Mode Duel");
                            System.out.println("3 : Mode Defenseur");
                            int Mode = scanner.nextInt();
                            switch (Mode) {
                                case 1:
                                    System.out.println("Vous avex choisi le mode challenger");
                                    System.out.println("Veuillez rentrez une combinaison de chiffres");
                                    try {
                                       while String code = Integer.toString(scanner.nextInt());
                                        Challenger(code);
                                    } catch (InputMismatchException e) {
                                        System.out.print(e.getMessage());
                                    }

                                    break;
                       /* case 2:
                            Mode duel;
                            break;
                        case 3:
                            Mode défenseur;
                            break;*/
                                default:
                                    System.out.println("Vous n'avez choisi aucun mode de jeu dans la liste");
                            }
                            break;
                        case 2:
                            System.out.println("- Vous avez choisis le MasterMind");
                            System.out.println("Veuillez choisir le mode auquel vous souhaitez jouer :  %n");
                    /*switch(mode){
                        case 1:
                            Mode challenger;
                            break;
                        case 2:
                            Mode duel;
                            break;
                        case 3:
                            Mode défenseur;
                            break;
                        default :
                            System.out.println("Vous n'avez choisi aucun mode de jeu dans la liste")
                    }*/
                            break;
                        default:
                            System.out.println("Vous n'avez pas choisi de jeu");
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

}