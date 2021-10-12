package edu.csf.oop.java.poker.members;

import edu.csf.oop.java.poker.cards.Card;

public interface ICroupier {
    void shuffle();
    Card pullOutTheCard();
    void returnCardToDeck(Card card);
}
