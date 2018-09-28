package main.java.MoreOrLess;



import java.util.Scanner;



public class GameMode {

    Scanner scanner = new Scanner(System.in);

    public boolean isAnInteger( String code )
    {
        try{
            Integer.parseInt(code);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void Challenger() {
        String code = scanner.next();
        String secret = "1265934";
        String verif = "";

        int codeEntre;
        int secretEntre;
        int s = secret.length();
        int i;
        int compteur = 0;
            if (isAnInteger(code) == true) {
                if (s == code.length()) {
                    do {
                        code = Integer.toString(scanner.nextInt());
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
                    } while ((!code.equals(secret)) && compteur <= 10);
                    if (code.equals(secret))
                    {   System.out.println("vous avez trouvé le code");
                        scanner.close();
                    }else{
                        System.out.println("vous n'avez  pas trouvé le code");
                        scanner.close();
                    }
                } else {
                    System.out.println("pas assez de chiffre ou trop de chiffre");
                }
            }else
                System.out.println("La chaine de caractere n'est pas composé de chiffre");
    }
}