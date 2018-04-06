package test;


import model.MyList;
import models.Card;
import models.EStatusCard;

public class TestArray {
	public static void main(String[] args) {
		//ArrayList<Card> cards = new ArrayList<Card>();
	//	Card card1 = new Card((short)5, EStatusCard.ATTACK, (short) 500,(short) 700);
		Card card2 = new Card((short)6, EStatusCard.DEFENSE, (short) 500,(short) 400);
		Card card3 = new Card((short)8, EStatusCard.DEFENSE, (short) 500,(short) 400);
		Card card4= new Card((short)11, EStatusCard.ATTACK, (short) 500,(short) 700);
		
		/*cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		
		cards.set(1, new Card(EStatusCard.EMPRY));
		for (int i = 0; i < cards.size(); i++) {
			System.out.println("estado: " + cards.get(i).geteStatusLetter().name());
		}*/
		
		MyList<Card> myList = new MyList<Card>();
		//myList.add(card1);
		myList.add(card2);
		myList.add(card3);
		myList.add(card4);
		
		
		//Card card = myList.pop();
		Card aux = myList.dequeue();
		System.out.println("id: " + aux.getIdCard());
		
		
	}

}
