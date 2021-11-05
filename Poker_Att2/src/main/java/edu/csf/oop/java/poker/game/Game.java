package edu.csf.oop.java.poker.game;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.members.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static edu.csf.oop.java.poker.service.CombinationDefinition.*;

public class Game {
    private IBot[] bots;
    private IPlayer realPlayer;
    private ICroupier croupier;
    private final Scanner scanner = new Scanner(System.in);

    private byte numOfCombinationsOfWinner = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

    public Game() {}

    public void newGame(IBot[] bots, IPlayer realPlayer, ICroupier croupier) {
        LOGGER.info("The game was started.");
        this.bots = bots;
        this.realPlayer = realPlayer;
        this.croupier = croupier;

        croupier.shuffle();
        for (IBot bot : bots) {
            Card card1 = croupier.pullOutTheCard();
            Card card2 = croupier.pullOutTheCard();
            Card card3 = croupier.pullOutTheCard();
            Card card4 = croupier.pullOutTheCard();
            Card card5 = croupier.pullOutTheCard();

            bot.giveCardsToPlayer(new Card[] {card1, card2, card3, card4, card5});
            bot.sortCardsInHand();
        }
        realPlayer.giveCardsToPlayer(new Card[] {croupier.pullOutTheCard(), croupier.pullOutTheCard(), croupier.pullOutTheCard(),
                croupier.pullOutTheCard(), croupier.pullOutTheCard()});
        realPlayer.sortCardsInHand();
    }

    public void changeCards(byte numOfCards) {
        Card[] cardsOnMyHand = realPlayer.getHand().getCards();

        croupier.returnCardToDeck(cardsOnMyHand[numOfCards]);
        cardsOnMyHand[numOfCards] = croupier.pullOutTheCard();
        realPlayer.giveCardsToPlayer(cardsOnMyHand);
    }

    // Возвращение карт игрока в колоду. Для теста.
    public void raiseCards() {
        Card[] card = realPlayer.discardCards();
        for (int i = 0; i < 5; i++) {
            croupier.returnCardToDeck(card[i]);
        }
        for (int i = 0; i < bots.length; i++) {
            card = bots[i].discardCards();
            for (int j = 0; j < 5; j++) {
                croupier.returnCardToDeck(card[i]);
            }
        }
    }

    public void checkCombinationsOfMembers(IBot memberOfGame) {
        Card[] cards = memberOfGame.discardCards();
        byte[] numCombinations = {
                royalFlash(cards),
                straightFlash(cards),
                fourOfAKind(cards),
                fullHouse(cards),
                flash(cards),
                straight(cards),
                threeOfKind(cards),
                twoPairs(cards),
                onePair(cards) };

        for (byte n : numCombinations) {
            if (n != -1) {
                memberOfGame.setNumOfCombination(n);
                break;
            }
        }

        for (Card card : cards) {
            croupier.returnCardToDeck(card);
        }
    }

    public String determiningOfTheWinner() {
        byte index = determiningIndexOfTheWinner();
        if (index == 0) {
            return "Congratulations! You won! :-D\nWinning combination: " + getNameOfCombinations(numOfCombinationsOfWinner);
        }
        return "You failed! Bot #" + index + " won. :-(\nWinning combination: " + getNameOfCombinations(numOfCombinationsOfWinner);
    }

    private byte determiningIndexOfTheWinner() {
        checkCombinationsOfMembers(realPlayer);
        for (IBot b : bots) {
            checkCombinationsOfMembers(b);
        }

        byte[] comb = new byte[4];
        comb[0] = realPlayer.getNumOfCombination();
        for (byte i = 1; i < bots.length; i++) {
            comb[i] = bots[i - 1].getNumOfCombination();
        }
        return getIndexOfLargest(comb);
    }

    private byte getIndexOfLargest(byte[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        byte largest = 0;
        for (byte i = 1; i < numbers.length; i++) {
            if (numbers[i] >= numbers[largest]) {
                largest = i;
                numOfCombinationsOfWinner = numbers[i];
            }
        }
        return largest;
    }
}
