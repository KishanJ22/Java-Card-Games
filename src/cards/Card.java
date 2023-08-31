package cards;

public class Card {
    private final String rank;
    // There are 13 ranks in a deck of cards.
    // 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace.
    private final String suit;
    // There are 4 suits in a deck of cards.
    // Clubs, Diamonds, Hearts, and Spades.

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        if(rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return 10;
            // Jack, Queen, and King are all worth 10 points.
        } else if(rank.equals("Ace")) {
            return 11;
            // Ace is worth 11 points.
        } else {
            return Integer.parseInt(rank);
            // The rank is returned as an integer (2 to 10).
        }
    }

    public String toString() {
        return rank + " of " + suit;
        // The rank and suit of the card are returned as a string.
    }
}
