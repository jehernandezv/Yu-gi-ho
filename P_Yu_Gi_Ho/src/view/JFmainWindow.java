package view;

import java.awt.BorderLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class JFmainWindow extends JFrame{
	private static final String APP_NAME = "YU-GI-OH";
	private static final long serialVersionUID = 1L;
	private JPBattleField battleField;
	private JPHpPlayer jpHpPlayer1;
	private JPHpPlayer jpHpPlayer2;
	private JDModeCard jdModeCard;
	
	public JFmainWindow(Controller controller) {
		this.setTitle(APP_NAME);
		URL url = this.getClass().getResource("/logo.png");  
		ImageIcon imageIcon = new ImageIcon(url);
		imageIcon.setImage(imageIcon.getImage());
		this.setIconImage(imageIcon.getImage());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.jdModeCard = new JDModeCard(this,controller);
		this.setLayout(new BorderLayout());
		battleField = new JPBattleField(controller);
		init();
		this.setVisible(true);
	}

	private void init() {
		
		jpHpPlayer1 = new JPHpPlayer((short) 2000, "Jhonn","#214e75");
		jpHpPlayer2 = new JPHpPlayer((short) 800, "Juan","#093646");
		
		this.add(battleField, BorderLayout.CENTER);
		this.add(jpHpPlayer1, BorderLayout.EAST);
		this.add(jpHpPlayer2, BorderLayout.WEST);
	}
	
	
	public ArrayList<JBCard> getListJBcardsBattlePlayer1(){
		return battleField.getListJBcardsBattlePlayer1();
	}
	
	public ArrayList<JBCard> getListJBcardsBattlePlayer2(){
		return battleField.getListJBcardsBattlePlayer2();
	}
	
	
	public void showJDialog(){
		jdModeCard.setVisible(true);
	}
	
	public void ocultJDialog(){
		jdModeCard.dispose();
	}

	public JPBattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(JPBattleField battleField) {
		this.battleField = battleField;
	}

	public JPHpPlayer getJpHpPlayer1() {
		return jpHpPlayer1;
	}

	public void setJpHpPlayer1(JPHpPlayer jpHpPlayer1) {
		this.jpHpPlayer1 = jpHpPlayer1;
	}

	public JPHpPlayer getJpHpPlayer2() {
		return jpHpPlayer2;
	}

	public void setJpHpPlayer2(JPHpPlayer jpHpPlayer2) {
		this.jpHpPlayer2 = jpHpPlayer2;
	}

	public JDModeCard getJdModeCard() {
		return jdModeCard;
	}

	public void setJdModeCard(JDModeCard jdModeCard) {
		this.jdModeCard = jdModeCard;
	}
	
	

	
	

	
	
	
	
}
