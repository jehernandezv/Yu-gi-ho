package models;

import model.MyList;

public class Card {
	private short idCard;
	private EStatusCard eStatusLetter;
	private short attackPoint;
	private short defencePoint;
	

	public Card(short idCard, EStatusCard eStatusLetter, short attackPoint,short defencePoint) {
		this.idCard = idCard;
		this.eStatusLetter = eStatusLetter;
		this.defencePoint = defencePoint;
		this.attackPoint = attackPoint;
	}
	
	public Card getCardDeck(MyList<Card> listDeck) {
		return listDeck.pop();
	}
	
	public Card(EStatusCard statusCard) {
		this.eStatusLetter = statusCard;
	}

	public EStatusCard geteStatusLetter() {
		return eStatusLetter;
	}

	public void seteStatusLetter(EStatusCard eStatusLetter) {
		this.eStatusLetter = eStatusLetter;
	}

	public short getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(short attackPoint) {
		this.attackPoint = attackPoint;
	}

	public short getDefencePoint() {
		return defencePoint;
	}

	public void setDefencePoint(short defencePoint) {
		this.defencePoint = defencePoint;
	}

	public short getIdCard() {
		return idCard;
	}

	public void setIdCard(short idCard) {
		this.idCard = idCard;
	}
	
	
	
	

}
