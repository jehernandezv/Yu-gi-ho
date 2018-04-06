package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;

public class JPBattleField extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPCardsNort jPCardsNort;
	private JPCardsSouth JPCardsSouth;
	private JPBattle jpBattle;
	
	
	public JPBattleField(Controller controller) {
		this.setLayout(new BorderLayout());
		jPCardsNort = new JPCardsNort(controller);
		JPCardsSouth = new JPCardsSouth(controller);
		jpBattle = new JPBattle(controller);
		init();
	}
	
	
	
	private void init() {
		this.add(JPCardsSouth, BorderLayout.SOUTH);
		this.add(jPCardsNort, BorderLayout.NORTH);
		this.add(jpBattle, BorderLayout.CENTER);	
	}
	
	public ArrayList<JBCard> getListJBcardsBattlePlayer1(){
		return jpBattle.getListJBcardsBattlePlayer1();
	}
	
	public ArrayList<JBCard> getListJBcardsBattlePlayer2(){
		return jpBattle.getListJBcardsBattlePlayer2();
	}
	
	
	public int sizeJBCArd() {
		return getListJBCardNort().size();
	}
	
	public ArrayList<JBCard> getListJBCardNort(){
		return jPCardsNort.getListJbCards();
	}
	
	public ArrayList<JBCard> getListJBCardSouth(){
		return JPCardsSouth.getListJbCards();
	}


	public JPCardsNort getCardsNort() {
		return jPCardsNort;
	}

	public void setCardsNort(JPCardsNort cardsNort) {
		this.jPCardsNort = cardsNort;
	}

	public JPCardsSouth getCardsSouth() {
		return JPCardsSouth;
	}

	public void setCardsSouth(JPCardsSouth cardsSouth) {
		this.JPCardsSouth = cardsSouth;
	}

	public JPBattle getJpBattle() {
		return jpBattle;
	}

	public void setJpBattle(JPBattle jpBattle) {
		this.jpBattle = jpBattle;
	}	
	
}
