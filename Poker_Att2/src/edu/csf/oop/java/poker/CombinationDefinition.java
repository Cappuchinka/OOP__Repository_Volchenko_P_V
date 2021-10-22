package edu.csf.oop.java.poker;

import edu.csf.oop.java.poker.cards.Card;
import edu.csf.oop.java.poker.cards.Dignity;

// Функции, для сравнения комбинаций карт, которые лежат в руках.

// Пока проверка на одну комбинацию.
// В тестах можно глянуть, что проверка на комбинацию Флеш Рояль проходит успешно.

// Во всех функциях будет возращаться числовое значение, чтобы в дальнейшем каждый бот и игрок запомнили значение
// своей комбинации.
// Потом они сравниваются. У кого больше значение будет - тот и выиграл.

public class CombinationDefinition {
    public static int royalFlash(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (!cards[i].getSuit().equals(cards[i + 1].getSuit())) {
                return -1;
            }
        }
        if ((cards[0].getDignity() == Dignity.TEN && cards[1].getDignity() == Dignity.JACK &&
                cards[2].getDignity() == Dignity.QUEEN && cards[3].getDignity() == Dignity.KING &&
                cards[4].getDignity() == Dignity.ACE) ||
                (cards[0].getDignity() == Dignity.ACE && cards[1].getDignity() == Dignity.KING &&
                        cards[2].getDignity() == Dignity.QUEEN && cards[3].getDignity() == Dignity.JACK &&
                        cards[4].getDignity() == Dignity.TEN)) {
            return 9;
        }
        return -1;
    }
}
