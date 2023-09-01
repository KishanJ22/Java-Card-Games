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
        deck.shuffle();
        initialDeal();

        if (player.hasBlackjack()) {
            endGame(player.getUsername() + " has Blackjack! " + player.getUsername() + " wins!");
        } else {
            playerTurn();
            if (!player.isBust()) {
                dealerTurn();
            }
        }
    }

    private void initialDeal() {
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.revealFaceUpCard();
        player.showHand();
    }

    private void endGame(String message) {
        dealer.showHand();
        System.out.println(message);
    }

    private void playerTurn() {
        while (true) {
            System.out.println("Would you like to hit or stand?");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                player.hit(deck.drawCard());
                player.showHand();
            } else if (choice.equalsIgnoreCase("stand")) {
                player.stand();
                player.showHand();
                break;
            } else {
                System.out.println("Please enter a valid input.");
            }
        }

        if (player.isBust()) {
            endGame(player.getUsername() + " has gone bust! " + player.getUsername() + " loses.");
        }
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            System.out.println("The dealer hits.");
            dealer.hit(deck.drawCard());
        }

        if (dealer.hasBlackjack()) {
            endGame("Dealer has Blackjack! " + player.getUsername() + " loses.");
        } else if (dealer.isBust()) {
            endGame("The dealer is bust! " + player.getUsername() + " wins!");
        } else if (dealer.getHandValue() >= 17) {
            dealer.stand();
            endGame(player.getUsername() + " wins!");
        }
    }

}
