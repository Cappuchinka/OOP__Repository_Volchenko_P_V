package edu.csf.oop.java.poker.members;

import edu.csf.oop.java.poker.cards.Card;

public class Bot implements IBot {
    protected Hand hand;
    protected byte numOfCombination = 0;

    public Bot() {
    }

    //Hand = null становится.
    @Override
    public Card[] discardCards() {
        Card[] cards = hand.getCards().clone();
        hand = null;
        return cards;
    }

    /**
     Игрок получает карты от крупье на руки;
     */
    @Override
    public void giveCardsToPlayer(Card[] cards) {
        hand = new Hand(cards);
    }

    @Override
    public void setNumOfCombination(byte numOfCombination) {
        this.numOfCombination = numOfCombination;
    }

    @Override
    public byte getNumOfCombination() {
        return numOfCombination;
    }

    @Override
    public void sortCardsInHand() {
        hand.sort();
    }

    //Для тестов. В игре (Класс Game) будут создаваться экземляры типа IBot, и доступа к руке не будет.
    //Доступ будет осуществляться через те методы, которые объявлены в интерфейсе и реализованы в этом классе.
    public Hand getHand() {
        return hand;
    }
}
