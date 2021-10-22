import edu.csf.oop.java.poker.CombinationDefinition;
import edu.csf.oop.java.poker.cards.*;
import edu.csf.oop.java.poker.members.*;
import edu.csf.oop.java.poker.game.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokerTests {
    @Test
    public void testShuffle() {
        ICroupier croupier;
        croupier = new Croupier(new Deck());
        Card cardCheck = new Card(Suit.HEARTS, Dignity.ACE);

        croupier.shuffle();

        Assertions.assertNotEquals(cardCheck, croupier.pullOutTheCard());
        System.out.println("Shuffle Test Successful.");
    }

    @Test
    public void testDiscardCards() {
        Card card1 = new Card(Suit.HEARTS, Dignity.ACE);
        Card card2 = new Card(Suit.HEARTS, Dignity.TWO);
        Card card3 = new Card(Suit.DIAMONDS, Dignity.TWO);
        Card card4 = new Card(Suit.SPADES, Dignity.FIVE);
        Card card5 = new Card(Suit.CLUBS, Dignity.KING);

        Bot bot = new Bot();

        Card[] cards = {card1, card2, card3, card4, card5};
        bot.giveCardsToPlayer(cards);
        Card[] cardsOfBot = bot.discardCards();
        Assertions.assertNull(bot.getHand());
        System.out.println("Player have empty hand");
        Assertions.assertNotNull(cardsOfBot[0]);
        System.out.println("First cards was obtained.");
        Assertions.assertNotNull(cardsOfBot[1]);
        System.out.println("Second cards was obtained.");
    }

    @Test
    public void testCheckDeckSize() {
        IBot bot1 = new Bot();
        IBot bot2 = new Bot();
        IBot bot3 = new Bot();

        IBot[] bots = {bot1, bot2, bot3};

        IPlayer player = new Player();

        Deck deck = new Deck();
        Croupier croupier = new Croupier(deck);

        Game game = new Game();
        game.newGame(bots, player, croupier);

        Assertions.assertTrue(croupier.getDeck().getSize() < Deck.COUNT_OF_CARDS);
        System.out.println("Test was successful. Deck size < 52");
    }

    @Test
    public void testPrintCardsInMyHand() {
        IBot bot1 = new Bot();
        IBot bot2 = new Bot();
        IBot bot3 = new Bot();

        IBot[] bots = {bot1, bot2, bot3};

        IPlayer player = new Player();

        Deck deck = new Deck();
        Croupier croupier = new Croupier(deck);

        Game game = new Game();
        game.newGame(bots, player, croupier);
        game.printCardsInMyHand();
    }

    @Test
    public void testRoyalFlash() {
        Card[] cards = {new Card(Suit.HEARTS, Dignity.ACE), new Card(Suit.HEARTS, Dignity.KING),
                new Card(Suit.HEARTS, Dignity.QUEEN), new Card(Suit.HEARTS, Dignity.JACK),
                new Card(Suit.HEARTS, Dignity.TEN)};

        int result = CombinationDefinition.royalFlash(cards);

        Assertions.assertEquals(9, result);
    }
}
