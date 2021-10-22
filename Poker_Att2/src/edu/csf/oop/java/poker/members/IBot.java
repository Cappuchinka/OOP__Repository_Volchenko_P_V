package edu.csf.oop.java.poker.members;

import edu.csf.oop.java.poker.cards.Card;

public interface IBot {
    Card[] discardCards();
    void giveCardsToPlayer(Card[] cards);
    void setNumOfCombination(byte numOfCombination);
    byte getNumOfCombination();
}
