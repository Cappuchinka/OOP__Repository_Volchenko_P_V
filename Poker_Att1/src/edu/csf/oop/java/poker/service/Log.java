package edu.csf.oop.java.poker.service;

import edu.csf.oop.java.poker.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    private Log() {}

    // По мере написания будет добавлено больше функций.
    // Но само логирование в консоль и файл работает.
    public static void gameStart() {
        logger.info("The game was started.");
    }

    public static void printCardsInPlayersHand(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            logger.info(i + 1 + " card - " + cards[i].getSuit().toString() + " " + cards[i].getDignity().toString());
        }
    }

    public static void infoAboutOfChangesCards(byte ans, byte n) {
        if (ans == 1) {
            logger.info("Card " + (n + 1) + " was changed.");
        } else if (ans == 0) {
            logger.info("Card " + (n + 1) + " not changed.");
        }
    }

    public static void gameEnd() {
        logger.info("The game was ended.");
    }

}
