package edu.csf.oop.java.poker.game;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.members.IBot;
import edu.csf.oop.java.poker.members.ICroupier;
import edu.csf.oop.java.poker.members.IPlayer;
import edu.csf.oop.java.poker.service.Log;

import java.util.Scanner;

public class Game {
    private IBot[] bots;
    private IPlayer realPlayer;
    private ICroupier croupier;
    private Scanner scanner = new Scanner(System.in);

    public Game() {}

    public void newGame(IBot[] bots, IPlayer realPlayer, ICroupier croupier) {
        Log.gameStart();
        this.bots = bots;
        this.realPlayer = realPlayer;
        this.croupier = croupier;

        Card card1, card2, card3, card4, card5;
        croupier.shuffle();
        for (IBot bot : bots) {
            card1 = croupier.pullOutTheCard();
            card2 = croupier.pullOutTheCard();
            card3 = croupier.pullOutTheCard();
            card4 = croupier.pullOutTheCard();
            card5 = croupier.pullOutTheCard();

            bot.giveCardsToPlayer(new Card[] {card1, card2, card3, card4, card5});
        }
        realPlayer.giveCardsToPlayer(new Card[] {croupier.pullOutTheCard(), croupier.pullOutTheCard(), croupier.pullOutTheCard(),
                croupier.pullOutTheCard(), croupier.pullOutTheCard()});
    }

    public void printCardsInMyHand() {
        Log.printCardsInPlayersHand(realPlayer.getHand().getCards());
        for (Card c : realPlayer.getHand().getCards()) {
            System.out.println(c.getSuit() + " " + c.getDignity());
        }
    }

    public void changeCards() {
        Card[] cardsOnMyHand = realPlayer.getHand().getCards();
        for (byte i = 0; i < 5; i++) {
            System.out.printf("Would you change your %d card? 1 - Yes, 0 - No. ", i + 1);
            byte ans = scanner.nextByte();
            if (ans == 1) {
                croupier.returnCardToDeck(cardsOnMyHand[i]);
                cardsOnMyHand[i] = croupier.pullOutTheCard();
            }
            Log.infoAboutOfChangesCards(ans, i);
        }
        realPlayer.giveCardsToPlayer(cardsOnMyHand);
        printCardsInMyHand();
    }

    public byte isPlayGame() {
        System.out.println("Play again? 1 - Yes, 0 - No. ");
        return scanner.nextByte();
    }

    public void equalsCard() {

    }

}
