package main.java.MoreOrLess;



import java.util.Arrays;

public class GameMode {

    public static boolean isAnInteger(String code){
        try{
            code.matches("^\\p{Digit}+$");
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void Challenger(String code ) {
        String secret = "1265934";
        boolean testInt;
        testInt = isAnInteger(code);
        int s = secret.length();
        int c = code.length();
        int i = 0;
        int secretCode[] = new int[s];
        int codeEntre[] = new int[c];
        String tabNum[] = new String[secret.length()];
            if (testInt = true) {
                if (secret.length() != code.length()) {
                    System.out.println("Il n'y a pas " + secret.length() + " chiffres");
                } else {
                    for (i = 0; i < s && i < c; i++) {
                        secretCode[i] = secret.charAt(i);
                        codeEntre[i] = code.charAt(i);
                        if (codeEntre[i] == secretCode[i]) {
                            tabNum[i] = "=";
                        } else if (codeEntre[i] < secretCode[i]) {
                            tabNum[i] = "+";
                        } else if (codeEntre[i] > secretCode[i])
                            tabNum[i] = "-";
                    }
                    System.out.println("Vous avez tapé : " + code + " Etat : " + Arrays.toString(tabNum));
                    System.out.println(code);
                    System.out.println(secret);

                    }
                } else
                System.out.println("La chaine de caractere n'est pas composé de chiffre");
        }
}