package models;

import java.util.ArrayList;
import java.util.Random;

import model.MyList;

public class Deck {
	private MyList<Card> myListDeck;
	private static final byte NUM_CARDS  = 20;
	private short contCardsDeck;
	
	public Deck() {
		myListDeck = new MyList<Card>();
		
	}
	
	/**
	 * Este metodo genera posiciones aleatorias para las cartas especiales
	 * @param index posicion al cual se le va a sumar un numero aleatorio
	 * @return posicion aleatoria para las cartas especiales
	 */
	public short posSpecialCard(){
		return (short) (new Random().nextInt(NUM_CARDS));
	}
	/**
	 * Este metodo genera el mazo con 3 cartas especiales al azar
	 * @return retorna un array con el mazo y cartas especiales aleatoriamente
	 */
	public ArrayList<Card> generateCardRandom(){
		Random random = new Random();
		byte cont = 0;
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < NUM_CARDS; i++) {
			cards.add(new Card((short)random.nextInt(500),EStatusCard.EMPRY,(short) random.nextInt(1000), (short)random.nextInt(1000)));
			
		}
		while(cont < 3){
			cards.set(posSpecialCard(), new Card(EStatusCard.SPECIAL));
			cont ++;
		}
		return cards;
	}
	
	public short sizeDeck() {
		return contCardsDeck;
	}
	/**
	 * Este metodo inicia la baraja en 20 cartas en un tipo de dato de pila
	 */
	public void initDeck(){
		ArrayList<Card> cards = generateCardRandom();
		for (int i = 0; i < cards.size(); i++) {
			this.myListDeck.push(cards.get(i));
			contCardsDeck ++;
		}
	}
	
	public Card getCardDeck(){
		return myListDeck.pop();
	}
	
	//GETTERS AND SETTERS
	public MyList<Card> getMyListDeck() {
		return myListDeck;
	}
	

}
