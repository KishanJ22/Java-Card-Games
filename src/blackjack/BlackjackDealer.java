package blackjack;

import java.util.ArrayList;
import cards.Card;

public class BlackjackDealer implements BlackjackActions {

    private ArrayList<Card> hand;
    // The dealer's hand is stored in an arraylist.

    public BlackjackDealer() {
        hand = new ArrayList<Card>();
        // The arraylist is initialized.
    }

    public void addCard(Card card) {
        hand.add(card);
        // The card is added to the dealer's hand.
    }

    public void clearHand() {
        hand.clear();
        // The dealer's hand is cleared.
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for(Card c : hand) {
            // For each card in hand, get the value of the card and add it to the value count
            int cardValue = c.getValue();
            value += cardValue;

            // If there is an ace, then increment the numAces counter
            if(cardValue == 11) {
                numAces++;
            }

            // If the value count is over 21 and the dealer has aces then the value counter is adjusted
            while(value > 21 && numAces > 0) {
                value -=10;
                numAces--;
            }
        }
        return value;
        // returns the value of the dealer's hand
    }

    public boolean hasBlackjack() {
        // returns true if there are 2 cards in hand with a combined value of 21
        if(hand.size() == 2 && getHandValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBust() {
        if(getHandValue() > 21) {
            return true;
            // If the dealer's hand value is over 21, then the dealer is bust.
        } else {
            return false;
        }
    }

    public void revealFaceUpCard() {
        System.out.println("The dealer's face up card is " + hand.get(0));
        // The dealer's face up card is printed.
    }

    public void hit(Card c) {
        addCard(c);
    }

    public void stand() {
        System.out.println("The dealer stands.");
        // The dealer stands.
    }

    public void showHand() {
        System.out.println("The dealer's hand is:");
        for (Card c : hand) {
            System.out.println(c.toString());
        }
        // The dealer's hand is printed at the end of the game.
    }
}
