package fr.hadrien.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class main {



    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();
        logger.info("Lancement de l'app");
        Interface lancement = new Interface();
        lancement.Menu();
        lancement.menuEnd();
        logger.info("fin de l'application");
    }
}
