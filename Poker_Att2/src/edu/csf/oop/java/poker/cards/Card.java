package edu.csf.oop.java.poker.cards;

public class Card /*implements Comparable<Card>*/ {
    private Suit suit;
    private Dignity dignity;

    /**
     Создаёт карту;
     */
    public Card(Suit suit, Dignity dignity) {
        this.suit = suit;
        this.dignity = dignity;
    }

    /**
     Возращает масть карты;
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     Возращает достоинство карты;
     */
    public Dignity getDignity() {
        return dignity;
    }

//    @Override
//    public int compareTo(Card o)
//    {
//        if ((this.dignity).ordinal() == (o.dignity.ordinal()))
//            return 0;
//        else if ((this.dignity.ordinal()) > (o.dignity.ordinal()))
//            return 1;
//        else
//            return -1;
//    }
}
