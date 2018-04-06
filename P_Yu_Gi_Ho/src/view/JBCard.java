package view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JBCard extends JButton{
	
	private static final long serialVersionUID = 1L;
	private short idCard;
	private short valueAttack;
	private short valueDefense;
	private String status;
	
	
	public JBCard(short valueAttack,short valueDefense, short idCard) {
		this.valueAttack = valueAttack;
		this.valueDefense = valueDefense;
		this.idCard = idCard;
		
		String path = "/card.jpg";  
		URL url = this.getClass().getResource(path);  
		this.setSize(350,70);
		ImageIcon icon = new ImageIcon(url);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		
		
	}
	
	public JBCard() {
		String path = "/card.jpg";  
		URL url = this.getClass().getResource(path);  
		this.setSize(350,70);
		ImageIcon icon = new ImageIcon(url);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		
	
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Defense: " + valueDefense, (this.getWidth() /2) + 35, (this.getHeight() /2) + 15);
		g.drawString("Attack: " + valueAttack, (this.getWidth() / 4) - 35, (this.getHeight() / 2) + 15);
	}
	
	public short getValueAttack() {
		return valueAttack;
	}

	public void setValueAttack(short valueAttack) {
		this.valueAttack = valueAttack;
	}

	public short getValueDefense() {
		return valueDefense;
	}

	public void setValueDefense(short valueDefense) {
		this.valueDefense = valueDefense;
	}

	public short getIdCard() {
		return idCard;
	}

	public void setIdCard(short idCard) {
		this.idCard = idCard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
	
	
	
	

}
