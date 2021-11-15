package edu.csf.oop.java.poker.members;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.cards.Deck;

public class Croupier implements ICroupier {
    private Deck deck;

    public Croupier() {}

    /**
     Создаёт крупье с колодой;
     */
    public Croupier(Deck deck) {
        deck.makeNewDeck();
        this.deck = deck;
    }

    /**
     Перемешивает колоду;
     */
    @Override
    public void shuffle() {
        int countCards = deck.getSize();
        int rIndex;
        for (int i = 0; i < countCards; i++) {
            rIndex = (int)(Math.random() * countCards);
            Card card1 = deck.getCard(i);
            Card card2 = deck.getCard(rIndex);
            deck.replace(i, card2);
            deck.replace(rIndex, card1);
        }
    }

    /**
     Вытаскивает одну карту из колоды;
     */
    @Override
    public Card pullOutTheCard() {
        return deck.removeFromFront();
    }

    /**
     Возвращает карту в колоду;
     */
    @Override
    public void returnCardToDeck(Card card) {
        deck.returnCardToDeck(card);
    }

    //Для тестов. Так как будет создаваться не экземпляр типа Croupier, а типа ICroupier,
    // то доступа к этому геттеру не будет.
    public Deck getDeck() {
        return deck;
    }
}
