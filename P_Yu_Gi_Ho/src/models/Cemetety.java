package models;

import model.MyList;

public class Cemetety {
	private MyList<Card> myListCemetery;
	
	public Cemetety() {
		myListCemetery = new MyList<Card>();
	}

	public MyList<Card> getMyListCemetery() {
		return myListCemetery;
	}

	public void setMyListCemetery(MyList<Card> myListCemetery) {
		this.myListCemetery = myListCemetery;
	}
	
	
}
