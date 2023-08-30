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

    public String toString() {
        return rank + " of " + suit;
    }
}
