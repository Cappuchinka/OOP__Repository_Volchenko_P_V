package edu.csf.oop.java.poker.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    public static final int COUNT_OF_CARDS = 52;
    private final List<Card> cards = new ArrayList<Card>(COUNT_OF_CARDS);

    /**
     Создаёт колоду;
     */
    public Deck() { }

    public void makeNewDeck() {
        makeDeck();
    }

    /**
     Возращаеет количество карт в колоде;
     */
    public int getSize() {
        return cards.size();
    }

    /**
     Меняет карты местами;
     */
    public void replace(int index, Card card) {
        cards.set(index, card);
    }

    /**
     Удаляет одну карту из колоды;
     */
    public Card removeFromFront() {
        if (this.getSize() > 0) {
            return cards.remove(0);
        } else return null;
    }

    /**
     Возращает карту в колоду;
     */
    public void returnCardToDeck(Card card) {
        if (this.getSize() < COUNT_OF_CARDS) cards.add(card);
    }

    /**
     Получение карты по индексу;
     */
    public Card getCard(int index) {
        if (index < COUNT_OF_CARDS) {
            return cards.get(index);
        } else return null;
    }

    public List<Card> getDeck() {
        return cards;
    }

    /* Private methods */
    private void makeDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < COUNT_OF_CARDS / 4; j++) {
                cards.add(new Card(Suit.values()[i], Dignity.values()[j]));
            }
        }
    }
}
