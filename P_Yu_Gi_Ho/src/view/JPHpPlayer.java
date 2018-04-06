package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPHpPlayer extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitleHP, jLabelHp,jLabelPointHp;
	private short health ;
	private String namePlayer = "";

	
	public JPHpPlayer(short health,String namePlayer,String color) {
		this.setBackground(Color.decode(color));
		
		this.health = health;
		this.namePlayer = namePlayer;
		this.setLayout(new GridLayout(3,1));
		jLabelTitleHP = new JLabel("Player: "+ namePlayer);
		jLabelHp = new JLabel();
		jLabelPointHp = new JLabel("Hp: " + health);
		jLabelHp = new JLabel();
		
		init();
		
	}
	/*public JPHpPlayer() {
		this.setLayout(new GridLayout(3,1));
		jLabelTitleHP = new JLabel("Player: "+ namePlayer);
		jLabelHp = new JLabel();
		jLabelPointHp = new JLabel("Hp: " + health);
		jLabelHp = new JLabel("Image Cara feliz");
		image = new ImageIcon(this.getClass().getResource("/logo.jpg"));
		init();
	}*/

	public void generatorIconHp(){
		if(this.health <= 2000 && this.health > 1600){
			 jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/feliz.png")));
		}else if(this.health <= 1600 && this.health > 1200){
			jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/medio feliz.png")));
		}else if(this.health <= 1200 && this.health > 800){
			jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/serio.png")));
		}else if(this.health <= 800 && this.health > 400){
			jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/mediomuerto.png")));
		}else if(this.health <= 400 && this.health >0){
			jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/casimuerto.png")));
		}else{
			jLabelHp.setIcon(new ImageIcon(this.getClass().getResource("/muerto.png")));
		}
	 }

	

	private void init() {
		
		jLabelTitleHP.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelTitleHP.setForeground(Color.WHITE);
		jLabelTitleHP.setHorizontalAlignment(SwingConstants.CENTER);
		
		jLabelPointHp.setFont(new Font("Comic Sans", Font.BOLD, 25));
		jLabelPointHp.setForeground(Color.WHITE);
		jLabelPointHp.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.generatorIconHp();
		this.add(jLabelTitleHP);
		this.add(jLabelHp);
		this.add(jLabelPointHp);
	}
	
	//GETTERS AND SETTERS
	public short getHealth() {
		return health;
	}
	public void setHealth(short health) {
		this.health = health;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	
	
}
