package blackjack;
import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class BlackjackDealer implements BlackjackActions {

    private final List<Card> hand;

    public BlackjackDealer() {
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card c : hand) {
            int cardValue = c.getValue();
            value += cardValue;

            if (cardValue == 11) {
                numAces++;
            }

            while (value > 21 && numAces > 0) {
                value -= 10;
                numAces--;
            }
        }
        return value;
    }

    public boolean hasBlackjack() {
        return hand.size() == 2 && getHandValue() == 21;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public void revealFaceUpCard() {
        System.out.println("=====================================");
        System.out.println("The dealer's face up card is " + hand.get(0));
    }

    public void hit(Card c) {
        addCard(c);
    }

    public void stand() {
        System.out.println("The dealer stands.");
    }

    public void showHand() {
        System.out.println("The dealer's hand is:");
        for (Card c : hand) {
            System.out.println(c.toString());
        }
    }
}
