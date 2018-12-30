package fr.hadrien.mastermind.Mastermind;

import java.util.*;

    public class GameModeM {

        Scanner scanner = new Scanner(System.in);
        private int solutionLength;
        private int maxTry;
        private boolean dev;
        private int numberUse;

        public GameModeM(int solutionLength, int maxTry, boolean dev, int numberUse) {
            this.solutionLength = solutionLength;
            this.maxTry = maxTry;
            this.dev = dev;
            this.numberUse = numberUse;
        }



        String generateIACombinaison(String previousCombinaison, List<Integer> goodMatches, int max, int nbChiffres) {
            Random r = new Random();
            String newCombinaison = "";
            for (int i = 0; i < nbChiffres; i++) {
                if (goodMatches.contains(i)) {
                    newCombinaison += previousCombinaison.charAt(i);
                } else {
                    newCombinaison += r.nextInt(max + 1);
                }
            }
            return newCombinaison;
        }

        public void Mastermind() {

            String code;
            int[] codeEntre = new int[solutionLength];
            int[] solution = new int[solutionLength];
            int count = 0;
            int i;
            Random r = new Random();
            for (i = 0; i < solutionLength; i++) {
                solution[i] = r.nextInt(numberUse + 1);
            }


            if (dev == true)
                System.out.println(Arrays.toString(solution));
            do {
                System.out.println("Le code sera compris de chiffres entre 0 et " + numberUse);
                System.out.println("Veuillez rentrez une combinaison de chiffres");
                code = Integer.toString(scanner.nextInt());

                List<Integer> goodMatches = new ArrayList<>();
                List<Integer> approximativeMatches = new ArrayList<>();
                List<Integer> wrongNumber = new ArrayList<>();
                for (i = 0; i < solutionLength; i++) {

                    codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                    if (codeEntre[i] == solution[i]) {
                        goodMatches.add(i);
                    } else {
                        boolean foundMatch = false;
                        for (int j = 0; j < solutionLength; j++) {
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
                if (goodMatches.size() == solutionLength)
                    System.out.println("Vous avez tout trouvé");
                else {
                    System.out.println("Il y a " + goodMatches.size() + "bons chiffres bien placés et "
                            + approximativeMatches.size() + "bon chiffre mal placés et " + wrongNumber.size()
                            + " mauvais chiffre");
                }
            } while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry);

            if (Arrays.toString(codeEntre).equals(Arrays.toString(solution))) {
                System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            } else {
                System.out.println("vous n'avez  pas trouvé le code");
            }
        }


        public void MastermindDefense() {

            String code = "";
            int MAX = 9;
            int[] codeEntre = new int[solutionLength];
            int[] solution = new int[solutionLength];
            int count = 0;
            int i;

            System.out.println("Veuillez rentrez une combinaison de " + solutionLength + " chiffres que L'IA doit deviner en" +
                    " utilisant des chiffres entre 0 et " + numberUse + "  uniquement ");
            String myCombinaison = scanner.next();

            for (i = 0; i < solutionLength; i++) {
                solution[i] = myCombinaison.charAt(i);
            }
            if (dev == true)
                System.out.println(myCombinaison);
            List<Integer> goodMatches = new ArrayList<>();
            List<Integer> approximativeMatches = new ArrayList<>();
            List<Integer> wrongNumber = new ArrayList<>();

            do {
                System.out.println("L'IA va jouer");
                scanner.nextLine();
                code = generateIACombinaison(code, goodMatches, MAX, solutionLength);
                System.out.println("Combinaison de l'IA " + code);

                goodMatches.clear();
                approximativeMatches.clear();
                wrongNumber.clear();
                for (i = 0; i < solutionLength; i++) {

                    if (code.charAt(i) == solution[i]) {
                        goodMatches.add(i);
                    } else {
                        boolean foundMatch = false;
                        for (int j = 0; j < solutionLength; j++) {
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
                if (goodMatches.size() == solutionLength)
                    System.out.println("Vous avez tout trouvé");
                else {
                    System.out.println("Il y a " + goodMatches.size() + " bons chiffres bien placés et "
                            + approximativeMatches.size() + " bon chiffre mal placés et " + wrongNumber.size()
                            + " mauvais chiffre");
                }
            } while (!Arrays.toString(codeEntre).equals(Arrays.toString(solution)) && count <= maxTry);

            if (Arrays.toString(codeEntre).equals(Arrays.toString(solution))) {
                System.out.println("vous avez trouvé le code en seulement " + count + " essais");
            } else {
                System.out.println("vous n'avez  pas trouvé le code");
            }
        }

        public void MastermindDuel() {

            /**
             * variable pour le joueur
             */
            String code;

            int[] codeEntre = new int[solutionLength];
            int[] solution = new int[solutionLength];
            int count = 0;
            int i;
            Random r = new Random();
            for (i = 0; i < solutionLength; i++) {
                solution[i] = r.nextInt(numberUse + 1);

            }

            if (dev == true)
                System.out.println(Arrays.toString(solution));
            List<Integer> goodMatches = new ArrayList<>();
            List<Integer> approximativeMatches = new ArrayList<>();
            List<Integer> wrongNumber = new ArrayList<>();
            boolean playerWin = false;

            /**
             * variables pour l'ia
             */
            String codeIA = "";
            int MAXIA = 9;
            int[] codeEntreIA = new int[solutionLength];
            int[] solutionIA = new int[solutionLength];
            int countIA = 0;
            boolean IAWin = false;
            System.out.println("Veuillez rentrez une combinaison de " + solutionLength + " chiffres que L'IA doit deviner ");
            System.out.println("Le code sera compris de chiffres entre 0 et " + numberUse);
            String myCombinaisonIA = scanner.next();
            for (i = 0; i < solutionLength; i++) {
                solutionIA[i] = myCombinaisonIA.charAt(i);
            }

            List<Integer> goodMatchesIA = new ArrayList<>();
            List<Integer> approximativeMatchesIA = new ArrayList<>();
            List<Integer> wrongNumberIA = new ArrayList<>();
            do {
                System.out.println("Veuillez rentrez une combinaison de chiffres");
                code = Integer.toString(scanner.nextInt());

                for (i = 0; i < solutionLength; i++) {

                    codeEntre[i] = Integer.parseInt(String.valueOf(code.charAt(i)));
                    if (codeEntre[i] == solution[i]) {
                        goodMatches.add(i);
                    } else {
                        boolean foundMatch = false;
                        for (int j = 0; j < solutionLength; j++) {
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
                if (goodMatches.size() == solutionLength) {
                    System.out.println("Vous avez tout trouvé");
                    playerWin = true;
                } else {
                    System.out.println("Il y a " + goodMatches.size() + "bons chiffres bien placés et "
                            + approximativeMatches.size() + "bon chiffre mal placés et " + wrongNumber.size()
                            + " mauvais chiffre");
                }
                goodMatches.clear();
                approximativeMatches.clear();
                wrongNumber.clear();
                System.out.println("L'IA va jouer");
                scanner.nextLine();
                codeIA = generateIACombinaison(codeIA, goodMatchesIA, MAXIA, solutionLength);
                System.out.println("Combinaison de l'IA " + codeIA);

                goodMatchesIA.clear();
                approximativeMatchesIA.clear();
                wrongNumberIA.clear();
                if (dev == true)
                    System.out.println(myCombinaisonIA);
                for (i = 0; i < solutionLength; i++) {

                    if (codeIA.charAt(i) == solutionIA[i]) {
                        goodMatchesIA.add(i);
                    } else {
                        boolean foundMatchIA = false;
                        for (int j = 0; j < solutionLength; j++) {
                            if (codeEntreIA[i] == solutionIA[j] && i != j && !goodMatchesIA.contains(j)) {
                                approximativeMatchesIA.add(i);
                                foundMatchIA = true;
                                break;
                            }
                        }
                        if (!foundMatchIA) wrongNumberIA.add(i);
                    }
                }
                countIA++;
                if (goodMatchesIA.size() == solutionLength)
                    System.out.println("Vous avez tout trouvé");
                else {
                    System.out.println("Il y a " + goodMatchesIA.size() + "bons chiffres bien placés et "
                            + approximativeMatchesIA.size() + "bon chiffre mal placés et " + wrongNumberIA.size()
                            + " mauvais chiffre");
                }
            } while (playerWin == false && count <= maxTry && IAWin == false && countIA <= maxTry);
            if (!Arrays.toString(codeEntreIA).equals(Arrays.toString(solutionIA))) {
                System.out.println("l'IA n'a  pas trouvé le code");
            }
            if (!Arrays.toString(codeEntre).equals(Arrays.toString(solution))) {
                System.out.println("vous n'avez  pas trouvé le code");
            }
        }
    }







