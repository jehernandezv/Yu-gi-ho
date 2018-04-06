package models;

import java.util.ArrayList;

public class Battlefield {
		private ArrayList<Card> listCardPlayerBattle;
		
		//CONSTRUCTOR
		public Battlefield() {
			listCardPlayerBattle = new ArrayList<Card>();
			listCardPlayerBattle.add(new Card(EStatusCard.EMPRY));
			listCardPlayerBattle.add(new Card(EStatusCard.EMPRY));
		}
	
		//METHODS
		/**
		 * Este metodo elimina retorna la carta a eliminar
		 * @param idCard el id correspondiente a ser eliminada'
		 * @return la carta eliminada
		 */
		public Card removeCardBattlefield(short idCard){
			Card card = null;
			for (int i = 0; i < listCardPlayerBattle.size(); i++) {
				if(idCard == listCardPlayerBattle.get(i).getIdCard()){
					card = listCardPlayerBattle.get(i);
					listCardPlayerBattle.set(i, new Card(EStatusCard.EMPRY));
				}
			}
			return card;
		}
		
		
		
		/**
		 * Este metodo adiciona una carta a la batalla
		 * @param card la carta a adicionar
		 */
		public void addCardBattle(Card card) {
			byte add = 0;
			for (int i = 0; i < listCardPlayerBattle.size(); i++) {
				if(listCardPlayerBattle.get(i).geteStatusLetter().name()== EStatusCard.EMPRY.name() && add == 0) {
					listCardPlayerBattle.set(i, card);
					add ++;
				}
			}
		}

		public ArrayList<Card> getListCardPlayerBattle() {
			return listCardPlayerBattle;
		}

		public void setListCardPlayerBattle(ArrayList<Card> listCardPlayerBattle) {
			this.listCardPlayerBattle = listCardPlayerBattle;
		}
			
			
	
		//GETTERS AND SETTERS
		
		
		
		
		
		
		
		
		
}
