package test;

import models.Deck;

public class TestGenerate {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.initDeck();
		for (int i = 0; i < 19; i++) {
			System.out.println("num " + i + " " +deck.getMyListDeck().pop().toString());
		}
	}
}
