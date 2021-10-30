package edu.csf.oop.java.poker.game;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.cards.Deck;
import edu.csf.oop.java.poker.members.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Poker {
    private static final Logger LOGGER = LoggerFactory.getLogger(Poker.class);
    private static final Scanner scanner = new Scanner(System.in);

    private final Game game = new Game();
    private final IBot bot1 = new Bot();
    private final IBot bot2 = new Bot();
    private final IPlayer player = new Player();

    private final IBot[] bots = {bot1, bot2};

    private final Deck deck = new Deck();
    private final ICroupier croupier = new Croupier(deck);

    private byte isPlay = 1;

    public Poker() {

    }

    public void play() {
        while (isPlay == 1) {
            System.out.println("===========================================================================================================");
            game.newGame(bots, player, croupier);
            printCardsInMyHand();
            changeCards();

            System.out.println();
            System.out.println("===========================================================================================================");
            System.out.println();

            printCardsInMyHand();

            System.out.println();
            System.out.println("===========================================================================================================");
            System.out.println();

            System.out.println(game.determiningOfTheWinner());

            System.out.println();

            isPlay = isPlayGame();
        }
        LOGGER.info("The game was ended.");
        System.out.println("Thank you for playing!");
        System.out.println("===========================================================================================================");
    }

    public void printCardsInMyHand() {
        int numCard = 0;
        for (Card c : player.getHand().getCards()) {
            LOGGER.info(++numCard + " card - " + c.getSuit().toString() + " " + c.getDignity().toString());
            System.out.println(c.getSuit() + " " + c.getDignity());
        }
    }

    public byte isPlayGame() {
        System.out.println("Play again? 1 - Yes, 0 - No. ");
        return scanner.nextByte();
    }

    public void changeCards() {
        for (byte i = 0; i < 5; i++) {
            System.out.printf("Would you change your %d card? 1 - Yes, 0 - No. ", i + 1);
            byte ans = scanner.nextByte();
            if (ans == 1) {
                game.changeCards(i);
                LOGGER.info("Card " + (i + 1) + " was changed.");
            } else {
                LOGGER.info("Card " + (i + 1) + " not changed.");
            }
        }
        player.sortCardsInHand();
    }
}
