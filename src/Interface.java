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
            int Game1 = scanner.nextInt();
            switch (Game1) {
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
                                String code = Integer.toString(scanner.nextInt());
                                GameMode.Challenger(code);
                            } catch (InputMismatchException e) {
                                System.out.print(e.getMessage());
                            }
                            break;
                    }
                    switch (Game1) {
                        case 2:
                            System.out.println("- Vous avez choisis le MasterMind");
                            System.out.println("Veuillez choisir le mode auquel vous souhaitez jouer :  ");
                            System.out.println("1 : Mode Challenger");
                            System.out.println("2 : Mode Duel");
                            System.out.println("3 : Mode Defenseur");
                            int Mode2 = scanner.nextInt();
                            switch (Mode2) {
                                case 1:
                                    System.out.println("Vous avex choisi le mode challenger");
                                    System.out.println("Veuillez rentrez une combinaison de chiffres");
                                    try {
                                        String code = Integer.toString(scanner.nextInt());
                                        GameModeM.Mastermind();
                                    } catch (InputMismatchException e) {
                                        System.out.print(e.getMessage());
                                    }
                            }

                    }
                    break;
                }
        } catch (Exception e) {
                    e.printStackTrace();
        }

    }
}