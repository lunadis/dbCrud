package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScreMetodologia extends JFrame {


	JLabel lblNome = new JLabel("Nome");
	JTextField txtNome = new JTextField();
	JButton btnSalvar = new JButton("Salvar");
	


	public ScreMetodologia() {
	
	super("Metodologia");	
		
	Container paine = this.getContentPane();
	
	paine.add(lblNome);
	paine.add(txtNome);
	lblNome.setBounds(10, 20,40, 20);
	txtNome.setBounds(50, 20, 120, 25);
	
	paine.add(btnSalvar);
	btnSalvar.setBounds(50, 60, 80, 50);
		
		
	this.setLayout(null);
	this.setSize(280, 200);
	this.setVisible(true);
	// para não fexar todo a aplicação em cada tela devera estar escrito HIDE_On_Close ao inves de EXIT_ON_CLOSE
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
}
}