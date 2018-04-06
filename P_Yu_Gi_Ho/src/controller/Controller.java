package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Card;
import models.EStatusCard;
import models.Game;
import models.Player;
import view.JFmainWindow;

public class Controller implements ActionListener{
	private JFmainWindow jFmainWindow;
	private Game game;
	private short idCard;
	private byte turn = 0;
	
	public Controller() {
		jFmainWindow = new JFmainWindow(this);
		game = new Game();
		initHandView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String string = e.getActionCommand();
		String [] values = string.split(":");
		Card card = null;
		Player player = null;
		switch (values[0]) {
		case "BUTTON_SELECT_CARD":
			this.idCard = Short.parseShort(string.split(":")[1]);
			jFmainWindow.showJDialog();
			break;
		case "JD_BUTON_ATACK":
			player = validateTurnPlayer();
			card = getOneJBCardHand(this.idCard,player);
			card.seteStatusLetter(validationStatus(string.split(":")[2]));
			updateBattlefield(player, card);
			validationCard(card);
			jFmainWindow.ocultJDialog();
			break;
		case "JD_BUTON_DEFENSE":
			player = validateTurnPlayer();
			card = getOneJBCardHand(this.idCard,player);
			card.seteStatusLetter(validationStatus(string.split(":")[2]));
			updateBattlefield(player, card);
			validationCard(card);
			jFmainWindow.ocultJDialog();
			break;
		case "BUTTON_CHANGE_TURN":
			changeTurn();
			System.out.println("deck: " + game.getJugador().sizeDeck());
			break;
			
		case "JB_ATACK_CARD_1":
			Card cardEliminate = game.attack(game.getJugador().getListCardPlayerBattle().get(0), game.getOponente().getListCardPlayerBattle().get(0));
			if(cardEliminate != null) {
			refreshBattle(cardEliminate);
			}
			jFmainWindow.repaint();
			
			break;

		
		
		}
	}
	
	public void refreshBattle(Card card) {
		for (int i = 0; i < jFmainWindow.getListJBcardsBattlePlayer1().size(); i++) {
			if(jFmainWindow.getListJBcardsBattlePlayer1().get(i).getIdCard() == card.getIdCard()) {
				jFmainWindow.getListJBcardsBattlePlayer1().get(i).setValueAttack((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer1().get(i).setValueDefense((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer1().get(i).setIdCard((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer1().get(i).setStatus("EMPRY");
			}
			if(jFmainWindow.getListJBcardsBattlePlayer2().get(i).getIdCard() == card.getIdCard()) {
				jFmainWindow.getListJBcardsBattlePlayer2().get(i).setValueAttack((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer2().get(i).setValueDefense((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer2().get(i).setIdCard((short) 0);
				jFmainWindow.getListJBcardsBattlePlayer2().get(i).setStatus("EMPRY");
			}
		}
	}
	
	public void loadCardHand(Card card,short turn,short idCard) {
		switch (turn) {
		case 0:
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardNort().size(); i++) {
				if(jFmainWindow.getBattleField().getListJBCardNort().get(i).getIdCard() == idCard) {
					jFmainWindow.getBattleField().getCardsNort().setValueCard(i, idCard, card.getAttackPoint(), card.getDefencePoint());
				}
			}
			break;

		case 1:
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardSouth().size(); i++) {
				if(jFmainWindow.getBattleField().getListJBCardSouth().get(i).getIdCard() == idCard) {
					jFmainWindow.getBattleField().getCardsSouth().setValueCard(i, idCard, card.getAttackPoint(), card.getDefencePoint());
				}
			}
			
			break;
		}
		jFmainWindow.repaint();
		
	}
	
	public void updateBattlefield(Player player,Card card) {
		player.addCardBattle(card);
	}
	
	/**
	 * Este metodo no se esta usando
	 * @param idCard
	 * @param status
	 */
//	public void showCardBattle(short idCard,String status,Player player) {
//		Card card = getOneJBCardHand(idCard,player);
//		card.seteStatusLetter(validationStatus(status));
//		validationCard(card);
//	}
	
	public Player validateTurnPlayer() {
		Player player = null;
		switch (this.turn) {
		case 0:
			player = game.getJugador();
			break;
		case 1:
			player = game.getOponente();
			break;
		
		}
		return player;
	}
	
	public void changeTurn() {
		byte auxTurn = this.turn;
		if(auxTurn == 0) {
			auxTurn = 1;
			
			//Desactiva los botones del panel norte
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardNort().size(); i++) {
				jFmainWindow.getBattleField().getListJBCardNort().get(i).setEnabled(false);
			}
			//Activa el boton de cambio de turno del oponente
			jFmainWindow.getBattleField().getCardsNort().getjButtonChangeTurn().setEnabled(false);
			//south activa botones y boton final del turno
			jFmainWindow.getBattleField().getCardsSouth().getjButtonChangeTurn().setEnabled(true);
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardSouth().size(); i++) {
				jFmainWindow.getBattleField().getListJBCardSouth().get(i).setEnabled(true);
			}
		}else {
			auxTurn = 0;
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardSouth().size(); i++) {
				jFmainWindow.getBattleField().getListJBCardSouth().get(i).setEnabled(false);
			}
			jFmainWindow.getBattleField().getCardsSouth().getjButtonChangeTurn().setEnabled(false);
			//nort
			jFmainWindow.getBattleField().getCardsNort().getjButtonChangeTurn().setEnabled(true);
			for (int i = 0; i < jFmainWindow.getBattleField().getListJBCardNort().size(); i++) {
				jFmainWindow.getBattleField().getListJBCardNort().get(i).setEnabled(true);
			}
		}
		//if(auxTurn != 1) {
		Player playerAux = validateTurnPlayer();
		Card cardAux = playerAux.updateHand(this.idCard);
		loadCardHand(cardAux, this.turn, this.idCard);
		jFmainWindow.repaint();
	//	}
		
		this.turn = auxTurn;
		
	}
	
	public EStatusCard validationStatus(String status) {
		EStatusCard eStatusCard = EStatusCard.EMPRY;
		switch (status) {
		
		case "Defense":
			eStatusCard = EStatusCard.DEFENSE;
			break;
			
		case "Attack":
			eStatusCard = EStatusCard.ATTACK;
			break;

		}
		return eStatusCard;
	}
	
	public void validationCard(Card card) {
		if(card.geteStatusLetter().name() == EStatusCard.ATTACK.name()) {
			sentCardBattle(card.getIdCard(), card.getAttackPoint(),(short) 0,card.geteStatusLetter());
		}else if(card.geteStatusLetter().name() == EStatusCard.DEFENSE.name()) {
			sentCardBattle(card.getIdCard(), (short) 0, card.getDefencePoint(),card.geteStatusLetter());
		}
		jFmainWindow.repaint();
	}
	
	public Card getOneJBCardHand(short id,Player player) {
		return player.getHand().getCard(id);
		
	}
	
	public void sentCardBattle(short id,short valueAttack,short valueDefense,EStatusCard eStatusCard) {
		byte add = 0;
		switch (this.turn) {
		case 0:
			for (int i = 0; i < jFmainWindow.getListJBcardsBattlePlayer1().size(); i++) {
				if(jFmainWindow.getListJBcardsBattlePlayer1().get(i).getStatus() == EStatusCard.EMPRY.name() && add == 0) {
					jFmainWindow.getListJBcardsBattlePlayer1().get(i).setValueAttack(valueAttack);
					jFmainWindow.getListJBcardsBattlePlayer1().get(i).setValueDefense(valueDefense);
					jFmainWindow.getListJBcardsBattlePlayer1().get(i).setIdCard(id);
					jFmainWindow.getListJBcardsBattlePlayer1().get(i).setStatus(eStatusCard.name());
					add ++;
				}
			}
		case 1:
			for (int i = 0; i < jFmainWindow.getListJBcardsBattlePlayer2().size(); i++) {
				if(jFmainWindow.getListJBcardsBattlePlayer2().get(i).getStatus() == EStatusCard.EMPRY.name() && add == 0) {
					jFmainWindow.getListJBcardsBattlePlayer2().get(i).setValueAttack(valueAttack);
					jFmainWindow.getListJBcardsBattlePlayer2().get(i).setValueDefense(valueDefense);
					jFmainWindow.getListJBcardsBattlePlayer2().get(i).setIdCard(id);
					jFmainWindow.getListJBcardsBattlePlayer2().get(i).setStatus(eStatusCard.name());
					add ++;
				}
			}
			
			break;

		
		}
		add = 0;
		
		
	}
	
	
	
	
	/**
	 * Este metodo inicia la mano de cada jugador
	 */
	public void initHandView() {
		for (int i = 0; i < jFmainWindow.getBattleField().sizeJBCArd(); i++) {
			jFmainWindow.getBattleField().getListJBCardNort().get(i).setValueAttack(game.getJugador().getlistHand().get(i).getAttackPoint());
			jFmainWindow.getBattleField().getListJBCardNort().get(i).setValueDefense(game.getJugador().getlistHand().get(i).getDefencePoint());
			jFmainWindow.getBattleField().getListJBCardNort().get(i).setIdCard(game.getJugador().getlistHand().get(i).getIdCard());
			jFmainWindow.getBattleField().getListJBCardNort().get(i).addActionListener(this);
			jFmainWindow.getBattleField().getListJBCardNort().get(i).setActionCommand(EAction.BUTTON_SELECT_CARD.name()+ ":" + 
					game.getJugador().getlistHand().get(i).getIdCard());
			
			jFmainWindow.getBattleField().getListJBCardSouth().get(i).setValueAttack(game.getOponente().getlistHand().get(i).getAttackPoint());
			jFmainWindow.getBattleField().getListJBCardSouth().get(i).setValueDefense(game.getOponente().getlistHand().get(i).getDefencePoint());
			jFmainWindow.getBattleField().getListJBCardSouth().get(i).setIdCard(game.getOponente().getlistHand().get(i).getIdCard());
			jFmainWindow.getBattleField().getListJBCardSouth().get(i).addActionListener(this);
			jFmainWindow.getBattleField().getListJBCardSouth().get(i).setActionCommand(EAction.BUTTON_SELECT_CARD.name()+ ":" + 
					game.getOponente().getlistHand().get(i).getIdCard());
		}
		jFmainWindow.repaint();
	}
	
	
	public JFmainWindow getjFmainWindow() {
		return jFmainWindow;
	}

	public void setjFmainWindow(JFmainWindow jFmainWindow) {
		this.jFmainWindow = jFmainWindow;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
