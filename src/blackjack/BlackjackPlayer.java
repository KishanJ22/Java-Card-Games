package blackjack;

import java.util.ArrayList;
import cards.Card;

public class BlackjackPlayer {

    private ArrayList<Card> hand;
    private String username;

    public BlackjackPlayer(String username) {
        // Initialise the player's hand
        hand = new ArrayList<>();
        this.username = username;
    }

    public void addCard(Card c) {
        // Adds the card to hand
        hand.add(c);
    }

    public void clearHand() {
        // Removes all cards from the hand ArrayList
        hand.clear();
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

            // If the value count is over 21 and the player has aces then the value counter is adjusted
            while(value > 21 && numAces > 0) {
                value -=10;
                numAces--;
            }
        }
        return value;
        // returns the value of the player's hand
    }

    public boolean hasBlackjack() {
        // returns true if there are 2 cards in hand with a combined value of 21
         if(hand.size() == 2 && getHandValue() == 21) {
             System.out.println(getUsername()+" has Blackjack!");
             return true;
         } else {
             return false;
         }
    }

    public boolean isBust() {
        // returns true if the hand value is over 21, meaning that the player has lost
         if(getHandValue() > 21) {
             System.out.println(getUsername()+" has gone bust!");
             return true;
         } else {
             return false;
         }
    }

    public String getUsername() {
        return username;
    }

    public void hit(Card c) {
        System.out.println(getUsername()+" has decided to hit and has "+c.toString());
        if(hand.size() >= 2) {
            hand.add(c);
        }
    }

    public void stand() {
        System.out.println(getUsername()+" has decided to stand!");
    }

}
