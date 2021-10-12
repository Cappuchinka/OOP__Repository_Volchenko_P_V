package edu.csf.oop.java.poker.members;

import edu.csf.oop.java.poker.cards.Card;

public class Hand {
    Card[] cards;

    public Hand(Card[] cards) {
        this.cards = cards.clone();
    }

    public Card[] getCards() {
        return cards;
    }
}
