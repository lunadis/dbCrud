package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScreInfluenciador extends JFrame {
	
		
	
		JLabel lblNome = new JLabel("Nome");
		JTextField txtNome = new JTextField();
		JButton btnSalvar = new JButton("Salvar");
		
	
	
		public ScreInfluenciador() {
		
		super("Influenciador");	
			
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
