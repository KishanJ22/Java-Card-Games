package blackjack;
import cards.Deck;
import java.util.Scanner;

public class BlackjackGame {

    private Deck deck;
    private BlackjackDealer dealer;
    private BlackjackPlayer player;

    private Scanner scanner;

    public BlackjackGame(String username) {
        deck = new Deck();
        dealer = new BlackjackDealer();
        player = new BlackjackPlayer(username);
        // The deck, dealer and player are initialised
        scanner = new Scanner(System.in);
        // A scanner is created to read user input.
    }

    public void startGame() {
        // The deck is shuffled
        deck.shuffle();
        // The dealer and player are dealt 2 cards each
        dealer.addCard(deck.drawCard());
        // The dealer's first card is drawn from the deck
        player.addCard(deck.drawCard());
        // The player's first card is drawn from the deck
        dealer.addCard(deck.drawCard());
        // The dealer's second card is drawn from the deck
        player.addCard(deck.drawCard());
        // The player's second card is drawn from the deck
        dealer.revealFaceUpCard();
        // The dealer's face up card is revealed
        player.showHand();
        // The player's hand is shown
        if(player.hasBlackjack()) {
            // If the player has blackjack, then the game ends
            System.out.println(player.getUsername()+" has Blackjack!");
            System.out.println(player.getUsername()+" wins!");
        } else {
            // Otherwise, the player is asked if they want to hit or stand
            System.out.println("Would you like to hit or stand?");
            // The player's input is stored in a local variable
            String choice = scanner.nextLine();
            // If the player hits, then a card is drawn from the deck and added to the player's hand
            if(choice.equalsIgnoreCase("hit")) {
                player.hit(deck.drawCard());
                // If the player stands, then the player's turn ends
                player.showHand();
                // The player's hand is shown
            } else if(choice.equalsIgnoreCase("stand")) {
                player.stand();
                // Otherwise, the player is asked to enter a valid input
                player.showHand();
                // The player's hand is shown
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
        if(player.isBust()) {
            System.out.println(player.getUsername()+" has gone bust!");
            // If the player is bust, then the game ends
            dealer.showHand();
            // The dealer's hand is shown
            System.out.println(player.getUsername()+" loses.");
        }
        // If the player has not gone bust, then the dealer's turn begins
        while(!player.isBust()) {
            // If the dealer has blackjack, then the game ends
            if(dealer.hasBlackjack()) {
                System.out.println("Dealer has Blackjack!");
                dealer.showHand();
                // The dealer's hand is shown
                System.out.println(player.getUsername()+" loses.");
                break;
            }
            // If the dealer is bust, then the game ends
            if(dealer.isBust()) {
                System.out.println("The dealer is bust!");
                dealer.showHand();
                // The dealer's hand is shown
                System.out.println(player.getUsername()+" wins!");
                break;
            }
            // If the dealer's hand value is less than 17, then the dealer hits
            if(dealer.getHandValue() < 17) {
                System.out.println("The dealer hits.");
                dealer.hit(deck.drawCard());
                // Otherwise, the dealer stands
            } else {
                dealer.stand();
                System.out.println(player.getUsername()+" wins!");
                break;
            }
        }
    }
}
