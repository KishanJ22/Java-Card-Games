package blackjack;
import cards.Card;


public interface BlackjackActions {

        void addCard(Card card);

        void clearHand();

        int getHandValue();

        boolean hasBlackjack();

        boolean isBust();

        void hit(Card card);

        void stand();

}
