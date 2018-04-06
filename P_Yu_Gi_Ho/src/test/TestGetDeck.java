package test;

import models.Card;
import models.Deck;
import models.Hand;

public class TestGetDeck {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.initDeck();
		Hand hand = new Hand();
		hand.initHand(deck);
		
		System.out.println("cant deck: " + deck.sizeDeck());
		System.out.println("hand size: " + hand.getCardsHand().size());
		Card card = deck.getCardDeck();
		System.out.println("cant deck: " + deck.sizeDeck());
		
	}
}
