//import edu.csf.oop.java.poker.game.Poker;
//import edu.csf.oop.java.poker.service.CombinationDefinition;
//import edu.csf.oop.java.poker.cards.*;
//import edu.csf.oop.java.poker.members.*;
//import edu.csf.oop.java.poker.game.Game;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//class PokerTests {
//    @Test
//    public void testShuffle() {
//        ICroupier croupier;
//        croupier = new Croupier(new Deck());
//        Card cardCheck = new Card(Suit.HEARTS, Dignity.ACE);
//
//        croupier.shuffle();
//
//        Assertions.assertNotEquals(cardCheck, croupier.pullOutTheCard());
//        System.out.println("Shuffle Test Successful.");
//    }
//
//    @Test
//    public void testDiscardCards() {
//        Card card1 = new Card(Suit.HEARTS, Dignity.ACE);
//        Card card2 = new Card(Suit.HEARTS, Dignity.TWO);
//        Card card3 = new Card(Suit.DIAMONDS, Dignity.TWO);
//        Card card4 = new Card(Suit.SPADES, Dignity.FIVE);
//        Card card5 = new Card(Suit.CLUBS, Dignity.KING);
//
//        Bot bot = new Bot();
//
//        Card[] cards = {card1, card2, card3, card4, card5};
//        bot.giveCardsToPlayer(cards);
//        Card[] cardsOfBot = bot.discardCards();
//        Assertions.assertNull(bot.getHand());
//        System.out.println("Player have empty hand");
//        Assertions.assertNotNull(cardsOfBot[0]);
//        System.out.println("First cards was obtained.");
//        Assertions.assertNotNull(cardsOfBot[1]);
//        System.out.println("Second cards was obtained.");
//    }
//
//    @Test
//    public void testCheckDeckSize() {
//        IBot bot1 = new Bot();
//        IBot bot2 = new Bot();
//        IBot bot3 = new Bot();
//
//        IBot[] bots = {bot1, bot2, bot3};
//
//        IPlayer player = new Player();
//
//        Deck deck = new Deck();
//        Croupier croupier = new Croupier(deck);
//
//        Game game = new Game();
//        game.newGame(bots, player, croupier);
//
//        Assertions.assertTrue(croupier.getDeck().getSize() < Deck.COUNT_OF_CARDS);
//        System.out.println("Test was successful. Deck size < 52");
//    }
//
//    @Test
//    public void testCompareCards() {
//        Card c1 = new Card(Suit.HEARTS, Dignity.ACE);
//        Card c2 = new Card(Suit.HEARTS, Dignity.KING);
//
//        int res = c2.compareTo(c1);
//        Assertions.assertEquals(12, res);
//    }
//
//    @Test
//    public void testSortCardsInHand() {
//        Card card1 = new Card(Suit.HEARTS, Dignity.ACE);
//        Card card2 = new Card(Suit.HEARTS, Dignity.TWO);
//        Card card3 = new Card(Suit.DIAMONDS, Dignity.TWO);
//        Card card4 = new Card(Suit.SPADES, Dignity.KING);
//        Card card5 = new Card(Suit.CLUBS, Dignity.JACK);
//
//        Card[] cards = {card1, card2, card3, card4, card5};
//
//
//        Bot bot = new Bot();
//        bot.giveCardsToPlayer(cards);
//
//        Card[] newCards = bot.getHand().getCards();
//        for (Card c : newCards) {
//            System.out.println(c.getSuit().toString() + " " + c.getDignity().toString() + ";");
//        }
//    }
//
//    @Test
//    public void testRoyalFlash() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.HEARTS, Dignity.TEN),
//                new Card(Suit.HEARTS, Dignity.JACK),
//                new Card(Suit.HEARTS, Dignity.QUEEN),
//                new Card(Suit.HEARTS, Dignity.KING)};
//
//        int result = CombinationDefinition.royalFlash(cards);
//
//        Assertions.assertEquals(9, result);
//    }
//
//    @Test
//    public void testStraightFlash() {
//        Card[] cards = {new Card(Suit.HEARTS, Dignity.ACE), new Card(Suit.HEARTS, Dignity.TWO),
//                new Card(Suit.HEARTS, Dignity.THREE), new Card(Suit.HEARTS, Dignity.FOUR),
//                new Card(Suit.HEARTS, Dignity.FIVE)};
//
//        int result = CombinationDefinition.straightFlash(cards);
//
//        Assertions.assertEquals(8, result);
//    }
//
//    @Test
//    public void testNotStraightFlash() {
//        Card[] cards = {new Card(Suit.HEARTS, Dignity.ACE), new Card(Suit.HEARTS, Dignity.TWO),
//                new Card(Suit.HEARTS, Dignity.THREE), new Card(Suit.HEARTS, Dignity.FOUR),
//                new Card(Suit.HEARTS, Dignity.SIX)};
//
//        int result = CombinationDefinition.straightFlash(cards);
//
//        Assertions.assertEquals(-1, result);
//    }
//
//    @Test
//    public void testFourOfAKind() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.HEARTS, Dignity.TWO),
//                new Card(Suit.DIAMONDS, Dignity.TWO),
//                new Card(Suit.SPADES, Dignity.TWO),
//                new Card(Suit.CLUBS, Dignity.TWO) };
//
//        int result = CombinationDefinition.fourOfAKind(cards);
//
//        Assertions.assertEquals(7, result);
//    }
//
//    @Test
//    public void testFullHouse() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.CLUBS, Dignity.ACE),
//                new Card(Suit.DIAMONDS, Dignity.TWO),
//                new Card(Suit.SPADES, Dignity.TWO),
//                new Card(Suit.CLUBS, Dignity.TWO) };
//
//        int result = CombinationDefinition.fullHouse(cards);
//
//        Assertions.assertEquals(6, result);
//    }
//
//    @Test
//    public void testFlash() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.HEARTS, Dignity.THREE),
//                new Card(Suit.HEARTS, Dignity.TWO),
//                new Card(Suit.HEARTS, Dignity.FIVE),
//                new Card(Suit.HEARTS, Dignity.KING) };
//
//        int result = CombinationDefinition.flash(cards);
//
//        Assertions.assertEquals(5, result);
//    }
//
//    @Test
//    public void testStraight() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.CLUBS, Dignity.TWO),
//                new Card(Suit.DIAMONDS, Dignity.THREE),
//                new Card(Suit.SPADES, Dignity.FOUR),
//                new Card(Suit.CLUBS, Dignity.FIVE) };
//
//        int result = CombinationDefinition.straight(cards);
//
//        Assertions.assertEquals(4, result);
//    }
//
//    @Test
//    public void testThreeOfAKind() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.CLUBS, Dignity.TWO),
//                new Card(Suit.DIAMONDS, Dignity.TWO),
//                new Card(Suit.SPADES, Dignity.TWO),
//                new Card(Suit.CLUBS, Dignity.FIVE) };
//
//        int result = CombinationDefinition.threeOfKind(cards);
//
//        Assertions.assertEquals(3, result);
//    }
//
//    @Test
//    public void testTwoPairs() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.CLUBS, Dignity.ACE),
//                new Card(Suit.DIAMONDS, Dignity.THREE),
//                new Card(Suit.SPADES, Dignity.TWO),
//                new Card(Suit.CLUBS, Dignity.TWO) };
//
//        int result = CombinationDefinition.twoPairs(cards);
//
//        Assertions.assertEquals(2, result);
//    }
//
//    @Test
//    public void testOnePair() {
//        Card[] cards = {
//                new Card(Suit.CLUBS, Dignity.FIVE),
//                new Card(Suit.DIAMONDS, Dignity.FIVE),
//                new Card(Suit.DIAMONDS, Dignity.SIX),
//                new Card(Suit.HEARTS, Dignity.NINE),
//                new Card(Suit.SPADES, Dignity.JACK) };
//
//        int result = CombinationDefinition.onePair(cards);
//
//        Assertions.assertEquals(1, result);
//    }
//
//    @Test
//    public void testCheckCombinationsOfMember() {
//        Card[] cards = {
//                new Card(Suit.HEARTS, Dignity.ACE),
//                new Card(Suit.CLUBS, Dignity.TWO),
//                new Card(Suit.DIAMONDS, Dignity.THREE),
//                new Card(Suit.SPADES, Dignity.FOUR),
//                new Card(Suit.CLUBS, Dignity.FIVE) };
//
//        IBot bot1 = new Bot();
//        IBot bot2 = new Bot();
//        IBot bot3 = new Bot();
//
//        IBot[] bots = {bot1, bot2, bot3};
//
//        Player player = new Player();
//
//        Deck deck = new Deck();
//        Croupier croupier = new Croupier(deck);
//
//        Game game = new Game();
//        game.newGame(bots, player, croupier);
//        game.raiseCards();
//        player.giveCardsToPlayer(cards);
//        game.checkCombinationsOfMembers(player);
//        int res = player.getNumOfCombination();
//        Assertions.assertEquals(4, res);
//    }
//}
