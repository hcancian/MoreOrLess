import main.java.MasterMind.GameModeM;
import main.java.MoreOrLess.GameMode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    public static void Menu() {
        System.out.println("Veuillez choisir un des 2 jeux suivants : \n");
        System.out.println("1 : MoreOrLess \n");
        System.out.println("2 : MasterMind \n");
        System.out.println("3 : Mode dev \n");
        Scanner scanner = new Scanner(System.in);
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
                                GameMode gameMode = new GameMode();
                                gameMode.Challenger();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Vous avex choisi le mode defenseur");
                            try {
                                GameMode gameMode = new GameMode();
                                gameMode.Defenseur();
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }

                    }

               /* case 2:
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
                                GameModeM.Mastermind();

                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Vous avex choisi le mode défenseur");
                            try {
                                GameModeM.MastermindDuel();

                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;

                    }*/
                }
            }catch(Exception e){
            e.printStackTrace();
        }
    }
}



