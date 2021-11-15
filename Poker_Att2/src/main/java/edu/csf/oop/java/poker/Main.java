package edu.csf.oop.java.poker;

import edu.csf.oop.java.poker.game.Poker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Poker poker = new Poker();

        poker.play();
    }
}
