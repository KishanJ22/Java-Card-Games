import blackjack.BlackjackGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // A scanner is created to read user input.
        System.out.println("Welcome to Java Card Games!");
        System.out.println("Games available (more to be added with updates!):");
        System.out.println("Blackjack");
        System.out.println("Please enter the name of the game you would like to play:");
        // The user is asked to enter the name of the game they would like to play.
        String game = scanner.nextLine();
        // The user's input is stored in a local variable.
        if(game.equalsIgnoreCase("blackjack")) {
            // If the user enters "blackjack", then a new BlackjackGame object is created.
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            // The user is asked to enter their username.
            System.out.println("Starting Blackjack!");
            BlackjackGame blackjackGame = new BlackjackGame(username);
            // The startGame() method is called on the BlackjackGame object.
            blackjackGame.startGame();
        } else {
            // Otherwise, the user is asked to enter a valid input.
            System.out.println("Please enter a valid input.");
        }
    }
}