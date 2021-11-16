package edu.csf.oop.java.poker.game;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.cards.Deck;
import edu.csf.oop.java.poker.members.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Poker {
    private static final Logger LOGGER = LoggerFactory.getLogger(Poker.class);
    private static final Scanner scanner = new Scanner(System.in);

    private Game game = new Game();
    private Bot bot1 = new Bot();
    private Bot bot2 = new Bot();
    private Player player = new Player();

    private final Deck deck = new Deck();
    private Croupier croupier = new Croupier(deck);

    private byte isPlay = 1;

    public Poker() {

    }

    public void play() throws IOException {
        System.out.println("===========================================================================================================");
        byte isRestore = isPlayGame("Would you restore game? 1 - Yes, 0 - No. ");
        byte isSave = 0;
        if (isRestore == 1) {
            restore();
            game.restoreGame(bot1, bot2, player, croupier);
            printCardsInMyHand();
            gameProcess();
        }
        while (isPlay == 1) {
            System.out.println("===========================================================================================================");
            game.newGame(bot1, bot2, player, croupier);
            printCardsInMyHand();
            isSave = isPlayGame("Would you save game? 1 - Yes, 0 - No. ");
            if (isSave == 1)
                save();
            else
                LOGGER.info("Game don't save.");
            gameProcess();
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

    public byte isPlayGame(String msg) {
        System.out.print(msg);
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

    public void gameProcess() {
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

        isPlay = isPlayGame("Play again? 1 - Yes, 0 - No. ");
    }

    public void save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(Paths.get("save.json").toFile(), game);
        LOGGER.info("The cards issued at the beginning of the game are saved.");
    }

    public void restore() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json = readFileAsString();
        game = mapper.readValue(json, Game.class);
        deserialization();
        LOGGER.info("The save has been loaded.");
    }

    private static String readFileAsString() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("save.json"));
            return new String(bytes);
        } catch (IOException ex) {
            System.err.println("isn't founded. Please, start program again and start new game!\n");
            System.out.println(ex.getMessage());
        }
        return "";
    }

    private void deserialization() {
        player = game.getRealPlayer();
        bot1 = game.getBot1();
        bot2 = game.getBot2();
        croupier = game.getCroupier();
        game = new Game();
    }
}
