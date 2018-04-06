package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import controller.EAction;

public class JPBattle extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitleBattle , jLabelPlayer1,jLabelplayer2;
	private JButton jButtonAttack1,jButtonAttack2;
	private ImageIcon imageIconJpanel;
	private ArrayList<JBCard> listJBcardsBattlePlayer1,listJBcardsBattlePlayer2;
	private JBCard jbCard1 ,jbCard2,jbCard3,jbCard4;
	public JPBattle(Controller controller) {
		this.setLayout(new GridLayout(4,3,50,70));
		listJBcardsBattlePlayer1 = new ArrayList<JBCard>();
		listJBcardsBattlePlayer2 = new ArrayList<JBCard>();
		jLabelPlayer1 = new JLabel("Jhonn");
		jLabelTitleBattle = new JLabel("Battle");
		jLabelplayer2 = new JLabel("Juan");
		jButtonAttack1 = new JButton();
		jButtonAttack2 = new JButton();
		jButtonAttack1.addActionListener(controller);
		jButtonAttack1.setActionCommand(EAction.JB_ATACK_CARD_1.name());
		jButtonAttack2.addActionListener(controller);
		jButtonAttack2.setActionCommand(EAction.JB_ATACK_CARD_2.name());
		
		jbCard1 = new JBCard((short)0, (short)0,(short) 45);
		jbCard1.setStatus("EMPRY");
		jbCard2 = new JBCard((short)0, (short)0,(short) 12);
		jbCard2.setStatus("EMPRY");
		jbCard3 = new JBCard((short)0, (short)0,(short) 69);
		jbCard3.setStatus("EMPRY");
		jbCard4 = new JBCard((short)0, (short)0,(short) 77);
		jbCard4.setStatus("EMPRY");
		imageIconJpanel = new ImageIcon(this.getClass().getResource("/yugioh.jpg"));
		
		String path = "/yugioh.jpg";  
		URL url = this.getClass().getResource(path);  
		this.setSize(1200,600);
		imageIconJpanel = new ImageIcon(url);
		imageIconJpanel = new ImageIcon(imageIconJpanel.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		
		
		init();
	}

	private void init() {

		URL url = this.getClass().getResource("/Versus.gif");  
		ImageIcon imageIcon = new ImageIcon(url);
		imageIcon.setImage(imageIcon.getImage());
		jButtonAttack1.setIcon(imageIcon);
		jButtonAttack2.setIcon(imageIcon);
		jButtonAttack1.setBackground(Color.white);
		jButtonAttack2.setBackground(Color.white);
		jButtonAttack1.setFocusable(false);
		jButtonAttack2.setFocusable(false);
		jButtonAttack1.setBorderPainted(false);
		jButtonAttack2.setBorderPainted(false);
		
		
		jLabelTitleBattle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelplayer2.setHorizontalAlignment(SwingConstants.CENTER);
		
		jLabelTitleBattle.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelTitleBattle.setForeground(Color.WHITE);
		jLabelTitleBattle.setHorizontalAlignment(SwingConstants.CENTER);
		
		jLabelPlayer1.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelPlayer1.setForeground(Color.WHITE);
		jLabelPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		
		jLabelplayer2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelplayer2.setForeground(Color.WHITE);
		jLabelplayer2.setHorizontalAlignment(SwingConstants.CENTER);
		
		listJBcardsBattlePlayer1.add(jbCard1);
		listJBcardsBattlePlayer1.add(jbCard2);
		listJBcardsBattlePlayer2.add(jbCard3);
		listJBcardsBattlePlayer2.add(jbCard4);
		
		this.add(new JLabel());
		this.add(jLabelTitleBattle);
		this.add(new JLabel());
		//2da fila
		this.add(jLabelPlayer1);
		this.add(listJBcardsBattlePlayer1.get(0));
		this.add(listJBcardsBattlePlayer1.get(1));
		//3er fila
		this.add(new JLabel());
		this.add(jButtonAttack1);
		this.add(jButtonAttack2);
		// 4ta fila
		this.add(jLabelplayer2);
		this.add(listJBcardsBattlePlayer2.get(0));
		this.add(listJBcardsBattlePlayer2.get(1));
		
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imageIconJpanel.getImage(),0, 0, null);
	}

	public ArrayList<JBCard> getListJBcardsBattlePlayer1() {
		return listJBcardsBattlePlayer1;
	}

	public void setListJBcardsBattlePlayer1(ArrayList<JBCard> listJBcardsBattlePlayer1) {
		this.listJBcardsBattlePlayer1 = listJBcardsBattlePlayer1;
	}

	public ArrayList<JBCard> getListJBcardsBattlePlayer2() {
		return listJBcardsBattlePlayer2;
	}

	public void setListJBcardsBattlePlayer2(ArrayList<JBCard> listJBcardsBattlePlayer2) {
		this.listJBcardsBattlePlayer2 = listJBcardsBattlePlayer2;
	}


	
	
	
	
	
	
}
