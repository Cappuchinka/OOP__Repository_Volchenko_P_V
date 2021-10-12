package edu.csf.oop.java.poker.game;

import edu.csf.oop.java.poker.cards.Deck;
import edu.csf.oop.java.poker.members.*;

public class Poker {
    Game game = new Game();
    IBot bot1 = new Bot();
    IBot bot2 = new Bot();
    IPlayer player = new Player();

    IBot[] bots = {bot1, bot2};

    Deck deck = new Deck();
    ICroupier croupier = new Croupier(deck);

    private byte isPlay = 1;

    public Poker() {

    }

    public void play() {
        while (isPlay == 1) {
            game.newGame(bots, player, croupier);
            game.printCardsInMyHand();
            game.changeCards();
            isPlay = game.isPlayGame();
        }
        System.out.println("Thank you for playing!");
    }
}
