package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import controller.EAction;



public class JPCardsNort extends JPanel{
	private static final String NAME_PLAYER = "Hand player 1: Jhonn";
	private static final byte NUM_CARD = 3;
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitle;
	private ArrayList<JBCard> listJbCards;
	private JButton jButtonChangeTurn;
	
	public JPCardsNort(Controller controller) {
		this.setLayout(new GridLayout(2,NUM_CARD));
		this.listJbCards = new ArrayList<JBCard>();
		jButtonChangeTurn = new JButton("Terminate Turn");
		listJbCards.add(new JBCard());
		listJbCards.add(new JBCard());
		listJbCards.add(new JBCard());
		
		jButtonChangeTurn.addActionListener(controller);
		jButtonChangeTurn.setActionCommand(EAction.BUTTON_CHANGE_TURN.name());
		
		jLabelTitle = new JLabel(NAME_PLAYER);
		
		
		init();
	}


	private void init() {
		this.setBackground(Color.decode("#214e75"));
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		for (int i = 0; i < listJbCards.size(); i++) {
			listJbCards.get(i).setBackground(Color.decode("#642809"));
		}
		
		jLabelTitle.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelTitle.setForeground(Color.WHITE);
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		this.add(new JLabel());
		this.add(jLabelTitle);
		this.add(jButtonChangeTurn);
		addJbutonCard(listJbCards);
		
	}

	
	public void addJbutonCard(ArrayList<JBCard> jbCards) {
		for (int j = 0; j < jbCards.size(); j++) {
		this.add(jbCards.get(j));
		}
	}

	public void setValueCard(int index,short idCard,short attack,short defense) {
		listJbCards.get(index).setValueAttack(attack);
		listJbCards.get(index).setValueDefense(defense);
		listJbCards.get(index).setIdCard(idCard);
		
	}


	public JLabel getjLabelTitle() {
		return jLabelTitle;
	}


	public void setjLabelTitle(JLabel jLabelTitle) {
		this.jLabelTitle = jLabelTitle;
	}


	public ArrayList<JBCard> getListJbCards() {
		return listJbCards;
	}


	public void setListJbCards(ArrayList<JBCard> listJbCards) {
		this.listJbCards = listJbCards;
	}


	public JButton getjButtonChangeTurn() {
		return jButtonChangeTurn;
	}


	public void setjButtonChangeTurn(JButton jButtonChangeTurn) {
		this.jButtonChangeTurn = jButtonChangeTurn;
	}


	
	
	
	
}
