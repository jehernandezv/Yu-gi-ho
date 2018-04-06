package models;

import java.util.ArrayList;

public class Player extends Person{
	private int idPlayer;
	private Deck deck;
	private Battlefield battlefield;
	private Hand hand;
	private Cemetety cemetety;
	private short life;
	
	
	public Player(String name) {
		super(name);
		this.deck = new Deck();
		this.deck.initDeck();
		this.hand = new Hand();
		this.hand.initHand(deck);
		
		this.battlefield = new Battlefield();
		
	}

	public ArrayList<Card> getlistHand(){
		return this.hand.getCardsHand();
	}
	
	//METHODS
	public void subtractLife(short value){
		this.life = (short) (this.life - value);
	}
	
	public Card updateHand(short id) {
		Card card = deck.getCardDeck();
		hand.LoadCardHand(id, deck.getCardDeck());
		
		return card;
	}
	
	public void passCardDeckAtHand() {
		this.hand.addCardAtHand(deck.getMyListDeck().pop());
	}
	
	public short sizeDeck() {
		return deck.sizeDeck();
	}
	
	
	public void addCardEmpryHand() {
		for (int i = 0; i < this.getHand().getCardsHand().size(); i++) {
			if(this.getHand().getCardsHand().get(i).geteStatusLetter().name() == EStatusCard.EMPRY.name()){
				hand.getCardsHand().set(i, deck.getMyListDeck().pop());
			}
			
		}
	}
	
	public ArrayList<Card> getListCardPlayerBattle() {
		return battlefield.getListCardPlayerBattle();
	}
	
	public void addZoneBattle(Card card) {
		battlefield.getListCardPlayerBattle().add(card);
	}
	
	public void addCardBattle(Card card){
		battlefield.addCardBattle(card);
	}
	
	
	//GETTERS ANDS SETTERS
	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}

	public Cemetety getCemetety() {
		return cemetety;
	}

	public void setCemetety(Cemetety cemetety) {
		this.cemetety = cemetety;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}


	public short getLife() {
		return life;
	}


	public void setLife(short life) {
		this.life = life;
	}
	
	
	
	
}
