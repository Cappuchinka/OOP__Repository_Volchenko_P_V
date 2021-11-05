package edu.csf.oop.java.poker.members;

public class Player extends Bot implements IPlayer {
    @Override
    public Hand getHand() {
        return hand;
    }
}
