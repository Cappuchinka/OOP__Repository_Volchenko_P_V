package edu.csf.oop.java.poker.service;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.cards.Dignity;

// Функции, для сравнения комбинаций карт, которые лежат в руках.

public class CombinationDefinition {
    public static byte royalFlash(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (!cards[i].getSuit().equals(cards[i + 1].getSuit())) {
                return -1;
            }
        }
        if
        (
            cards[0].getDignity() == Dignity.ACE && cards[1].getDignity() == Dignity.TEN &&
            cards[2].getDignity() == Dignity.JACK && cards[3].getDignity() == Dignity.QUEEN &&
            cards[4].getDignity() == Dignity.KING
        )
        {
            return 9;
        }
        return -1;
    }

    public static byte straightFlash(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (!cards[i].getSuit().equals(cards[i + 1].getSuit())) {
                return -1;
            }
        }

        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].compareTo(cards[i + 1]) != -1) {
                return -1;
            }
        }
        return 8;
    }

    public static byte fourOfAKind(Card[] cards) {
        int start = 0;
        int finish = cards.length;

        if (cards[0].compareTo(cards[1]) == 0) {
            finish--;
        } else {
            start++;
        }

        for (int i = start; i < finish - 1; i++) {
            if (cards[i].equalsSuit(cards[i + 1]) ||
                    cards[i].compareTo(cards[i + 1]) != 0) {
                return -1;
            }
        }
        return 7;
    }

    public static byte fullHouse(Card[] cards) {
        if
        ( (!cards[0].equalsSuit(cards[1]) && cards[0].equalsDignity(cards[1])) &&
            (!cards[2].equalsSuit(cards[3]) && !cards[2].equalsSuit(cards[4]) && !cards[3].equalsSuit(cards[4]) &&
                cards[2].equalsDignity(cards[3]) && cards[3].equalsDignity(cards[4]))
        )
        {
            return 6;
        }
        return -1;
    }

    public static byte flash(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (!cards[i].getSuit().equals(cards[i + 1].getSuit())) {
                return -1;
            }
        }
        return 5;
    }

    public static byte straight(Card[] cards) {
        if
        (       cards[0].getDignity() == Dignity.ACE &&
                cards[1].getDignity() == Dignity.TEN &&
                cards[2].getDignity() == Dignity.JACK &&
                cards[3].getDignity() == Dignity.QUEEN &&
                cards[4].getDignity() == Dignity.KING
        )
        {
            return 4;
        }
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].compareTo(cards[i + 1]) != -1) {
                return -1;
            }
        }
        return 4;
    }

    public static byte threeOfKind(Card[] cards) {
        if
        (
            cards[0].equalsDignity(cards[1]) && cards[1].equalsDignity(cards[2]) ||
            cards[1].equalsDignity(cards[2]) && cards[2].equalsDignity(cards[3]) ||
            cards[2].equalsDignity(cards[3]) && cards[3].equalsDignity(cards[4])
        )
        {
            return 3;
        }
        return -1;
    }

    public static byte twoPairs(Card[] cards) {
        if
        (
            cards[0].equalsDignity(cards[1]) && cards[2].equalsDignity(cards[3]) ||
            cards[0].equalsDignity(cards[1]) && cards[3].equalsDignity(cards[4]) ||
            cards[1].equalsDignity(cards[2]) && cards[3].equalsDignity(cards[4])
        )
        {
            return 2;
        }
        return -1;
    }

    public static byte onePair(Card[] cards) {
        if
        (
            cards[0].equalsDignity(cards[1]) || cards[1].equalsDignity(cards[2]) ||
            cards[2].equalsDignity(cards[3]) || cards[3].equalsDignity(cards[4])
        )
        {
            return 1;
        }
        return -1;
    }

    public static String getNameOfCombinations(byte num) {
        return Combinations.values()[num].toString();
    }
}
