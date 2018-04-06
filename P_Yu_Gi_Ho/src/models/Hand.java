package models;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cardsHand;
	
	public Hand() {
		cardsHand = new ArrayList<Card>();
	}
	public byte seachCardHand(short id){
		byte pos = 0;
		for (int i = 0; i < cardsHand.size(); i++) {
			if(cardsHand.get(i).getIdCard() == id){
				pos = (byte) i;
			}
		}
		return pos;
	}
	
	public void initHand(Deck deck) {
		for (int i = 0; i < 3; i++) {
		addCardAtHand(deck.getCardDeck());
		}
	}
	
	

	public void addCardAtHand(Card card) {
		this.cardsHand.add(card);
	}
	
	
	public void LoadCardHand(short id,Card card){
		this.cardsHand.set(seachCardHand(id),card);
	}
	
	
	
	public Card getCard(short id){
		return cardsHand.get(seachCardHand(id));
	}
	

	public ArrayList<Card> getCardsHand() {
		return cardsHand;
	}

	public void setCardsHand(ArrayList<Card> cardsHand) {
		this.cardsHand = cardsHand;
	}

	
	
	

}
