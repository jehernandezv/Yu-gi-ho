package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import controller.EAction;

public class JDModeCard extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JButton jButtonModeDefense,JButtonModeAttack;
	private JPanel jPanelIconMode;
	private JLabel jLabelTitleMode;
	private short idCard;
	
	
	public JDModeCard(JFmainWindow fmainWindow,Controller controller) {
		super(fmainWindow,true);
		this.setTitle("Selec rol");
		this.setIconImage(null);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
		
		this.setLayout(new BorderLayout());
		jButtonModeDefense = new JButton();
		JButtonModeAttack = new JButton();
		jPanelIconMode = new JPanel();
		jLabelTitleMode = new JLabel("Select the type of role. ( Attack , Defence)");
		jLabelTitleMode.setHorizontalAlignment(SwingConstants.CENTER);
		
		jButtonModeDefense.addActionListener(controller);
		jButtonModeDefense.setActionCommand(EAction.JD_BUTON_DEFENSE.name()+":"+this.idCard+":"+"Defense");
		
		JButtonModeAttack.addActionListener(controller);
		JButtonModeAttack.setActionCommand(EAction.JD_BUTON_ATACK.name()+":"+this.idCard+":"+"Attack");
		
			init();

	}

	
	

	private void init() {
		jPanelIconMode.setLayout(new GridLayout(1,2));
		JButtonModeAttack.setSize(170, 390);
		jButtonModeDefense.setSize(170, 390);
		JButtonModeAttack.setToolTipText("Mode Attack");
		jButtonModeDefense.setToolTipText("Mode Defence");
		jLabelTitleMode.setFont((new Font("Comic Sans", Font.BOLD,16)));
		jLabelTitleMode.setForeground(Color.BLACK);
		jLabelTitleMode.setBackground(Color.BLACK);

		String path = "/ataque.jpg";  
		URL url = this.getClass().getResource(path);  
		ImageIcon imageIconAttack = new ImageIcon(url);
		imageIconAttack.setImage(imageIconAttack.getImage());
		JButtonModeAttack.setIcon(imageIconAttack);
		
		path = "/defensa.jpg";
		url = this.getClass().getResource(path); 
		ImageIcon imageIconDefense  = new  ImageIcon(url);
		imageIconDefense.setImage(imageIconDefense.getImage());
		jButtonModeDefense.setIcon(imageIconDefense);
		
		
		
		JButtonModeAttack.setText("Attack");
		jButtonModeDefense.setText("Defence");
		
		jPanelIconMode.add(JButtonModeAttack);
		jPanelIconMode.add(jButtonModeDefense);
		this.add(jLabelTitleMode, BorderLayout.NORTH);
		this.add(jPanelIconMode,BorderLayout.CENTER);
		
	}

	public short getIdCard() {
		return idCard;
	}

	public void setIdCard(short idCard) {
		this.idCard = idCard;
	}
	
	
	
	
	
	
	
	

}
