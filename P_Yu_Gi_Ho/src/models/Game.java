package models;



public class Game {
	//private ArrayList<Player> players; 
	private Player jugador;
	private Player oponente;
	public Game() {
		this.jugador = new Player("jhonn");
		this.oponente = new Player("Juan");
	}
	
	
	
	
	
	
	
	
	
	//METHODS
	public Card attack(Card cardPlayer1,Card cardPlayer2){
		Card eliminateCard = null;
		//ATTACK VS ATTACK
		if(validationAttackVsAttack(cardPlayer1, cardPlayer2)){
			if(cardPlayer1.getAttackPoint() < cardPlayer2.getAttackPoint()){
				this.jugador.subtractLife(this.calculateDiferencePoints(cardPlayer2, cardPlayer1));
				//this.jugador.getCemetety().getMyListCemetery().add(cardPlayer1);
				this.jugador.getBattlefield().removeCardBattlefield(cardPlayer1.getIdCard());
				eliminateCard = cardPlayer1;
				System.out.println("Eliminado: " +cardPlayer1.getAttackPoint());
			}else{
				this.oponente.subtractLife(this.calculateDiferencePoints(cardPlayer1, cardPlayer2));
				//this.oponente.getCemetety().getMyListCemetery().add(cardPlayer2);
				this.oponente.getBattlefield().removeCardBattlefield(cardPlayer2.getIdCard());
				eliminateCard = cardPlayer2;
				System.out.println("Eliminado: " +cardPlayer2.getAttackPoint());
			}
			//ATTACK VS DEFENSE
		}else if(validationAttackVsDefence(cardPlayer1, cardPlayer2)){
			
			if(cardPlayer1.getAttackPoint() < cardPlayer2.getDefencePoint() && cardPlayer1.geteStatusLetter().name() == 
					EStatusCard.ATTACK.name() && cardPlayer2.geteStatusLetter().name() == EStatusCard.DEFENSE.name()){
				this.jugador.subtractLife(this.calculateDiferencePoints(cardPlayer2, cardPlayer1));
				System.out.println("resta a Attack: " +cardPlayer1.getAttackPoint());
			}else if(cardPlayer1.geteStatusLetter().name() == EStatusCard.DEFENSE.name() && cardPlayer2.geteStatusLetter().name() == 
					EStatusCard.ATTACK.name() && cardPlayer1.getDefencePoint() < cardPlayer2.getAttackPoint()){
				//oponente.getCemetety().getMyListCemetery().add(cardPlayer2);
				this.oponente.getBattlefield().removeCardBattlefield(cardPlayer2.getIdCard());
				eliminateCard = cardPlayer2;
				System.out.println("Eliminado: " +cardPlayer2.getAttackPoint());
			}
			
		}else {
			
			if(cardPlayer1.getDefencePoint() < cardPlayer2.getAttackPoint() && cardPlayer1.geteStatusLetter().name() == 
					EStatusCard.DEFENSE.name() && cardPlayer2.geteStatusLetter().name() == EStatusCard.ATTACK.name()){
				eliminateCard = cardPlayer1;
				System.out.println(": 2312d" +cardPlayer1.getAttackPoint());
			}
			else if(cardPlayer1.getDefencePoint() > cardPlayer2.getAttackPoint() && cardPlayer1.geteStatusLetter().name() == 
					EStatusCard.DEFENSE.name() && cardPlayer2.geteStatusLetter().name() == EStatusCard.ATTACK.name()){
				this.oponente.subtractLife(this.calculateDiferencePoints(cardPlayer1, cardPlayer2));
				
				System.out.println("restar: " +cardPlayer2.getAttackPoint());
			}
			
		}
		return eliminateCard;
	}
	/**
	 * Este metodo valida cuando hay dos cartas en ataque
	 * @param cardPlayer1 carta del jugador 1
	 * @param cardPlayer2 carta del jugador 2
	 * @return si las 2 cartas son de ataque entonces true sino false
	 */
	public boolean validationAttackVsAttack(Card cardPlayer1,Card cardPlayer2){
		return (cardPlayer1.geteStatusLetter().name() == EStatusCard.ATTACK.name() && 
				cardPlayer2.geteStatusLetter().name() == EStatusCard.ATTACK.name())?true:false;
	}
	
	public boolean validationAttackVsDefence(Card cardPlayer1,Card cardPlayer2){
		return (cardPlayer1.geteStatusLetter().name() == EStatusCard.ATTACK.name() &&
				cardPlayer2.geteStatusLetter().name() == EStatusCard.DEFENSE.name())?true:false;
	}
	
	
	public short calculateDiferencePoints(Card cardMax,Card cardMin){
		short diference = 0;
		if(validationAttackVsAttack(cardMin, cardMax)){
			diference = (short) (cardMax.getAttackPoint() - cardMin.getAttackPoint());
		}else if(validationAttackVsDefence(cardMin, cardMax)){
			diference = (short) (cardMax.getAttackPoint() - cardMin.getDefencePoint());
		}else{
			diference = (short) (cardMax.getDefencePoint() - cardMin.getAttackPoint());
		}
		return diference;
	}


	public Player getJugador() {
		return jugador;
	}

	public void setJugador(Player jugador) {
		this.jugador = jugador;
	}

	public Player getOponente() {
		return oponente;
	}

	public void setOponente(Player oponente) {
		this.oponente = oponente;
	}
	
	


	
}
