import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    // An arraylist is declared to store the cards in the deck.
    private String[] ranks;
    // The ranks of the cards are stored in an array.
    private String[] suits;
    // The suits of the cards are stored in an array.

    public Deck() {
        cards = new ArrayList<Card>();
        // The arraylist is initialized.
        ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};
        // The ranks of the cards are stored in an array.
        suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        // The suits of the cards are stored in an array.

        for (String rank : ranks) {
            // For each rank in the ranks array...
            for (String suit : suits) {
                cards.add(new Card(rank, suit));
                // A card is created for each rank and suit.
            }
        }
        System.out.println("The deck has been created. Now shuffle it!");
    }

    public void shuffle() {
        Collections.shuffle(cards);
        // The cards are shuffled.
        System.out.println("The deck has been shuffled.");
    }

    public int size() {
        return cards.size();
        // The size of the deck is returned.
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card drawCard() {
        if(isEmpty()) {
            System.out.println("The deck is empty!");
            return null;
        } else {
            Card card = cards.get(0);
            cards.remove(0);
            return card;
            // The first card in the deck is stored in a local variable, removed from the deck and returned.
        }
    }

    public void addCard(Card card) {
        if(cards.contains(card)) {
            System.out.println("The deck already contains this card!");
        } else {
            cards.add(card);
            // A card is added to the deck.
        }
    }

    public void reset() {
        cards.clear();
        // The deck is cleared.
        for (String rank : ranks) {
            // For each rank in the ranks array...
            for (String suit : suits) {
                cards.add(new Card(rank, suit));
                // A card is created for each rank and suit.
            }
        }
        System.out.println("The deck has been reset. Now shuffle it!");
    }

    public void getCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
        // The cards in the deck are printed.
    }

    public String toString() {
        String deck = "";
        for (Card card : cards) {
            deck += card.toString() + "\n";
        }
        return deck;
    }
}
