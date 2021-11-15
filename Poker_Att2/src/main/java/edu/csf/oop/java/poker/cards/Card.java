package edu.csf.oop.java.poker.cards;

public class Card implements Comparable<Card> {
    private Suit suit;
    private Dignity dignity;

    public Card() {}

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

    @Override
    public int compareTo(Card o)
    {
        return this.dignity.ordinal() - o.dignity.ordinal();
    }

    public boolean equalsSuit(Card o) {
        return this.suit.ordinal() == o.suit.ordinal();
    }

    public boolean equalsDignity(Card o) {
        return this.dignity.ordinal() == o.dignity.ordinal();
    }
}
