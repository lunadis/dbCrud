package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import model.Tarefas;

public class ScreTarefas extends JFrame {
	
	JLabel lblTitulo = new JLabel ("Titulo:");
	JLabel lblpEstimado = new JLabel ("Prazo Estimado:");
	JLabel lblDescricao = new JLabel ("Descricão");
	JLabel lblDataInicio = new JLabel ("Data Inicio:");
	JLabel lblDataFinal = new JLabel ("Data Final:");
	JTextField txtTitulo = new JTextField();
	JTextField txtpEstimado = new JTextField();
	JTextArea txtDescricao = new JTextArea();
	JTextField txtDataInicio = new JTextField();
	JTextField txtDataFinal = new JTextField();
	JScrollPane Scrollpane = new JScrollPane(txtDescricao);
	JButton btnSalvar = new JButton("Salvar");
	
	public ScreTarefas() {
		
		super("tarefas");
		
		Container paine = this.getContentPane();
		
		paine.add(lblTitulo);
		paine.add(txtTitulo);
		lblTitulo.setBounds(10, 20, 50, 20);
		txtTitulo.setBounds(60, 20, 200, 20);
		
		paine.add(lblpEstimado);
		paine.add(txtpEstimado);
		lblpEstimado.setBounds(10, 50, 95,20);
		txtpEstimado.setBounds(110, 50, 100, 20);
		
		paine.add(lblDescricao);
		paine.add(Scrollpane);
		lblDescricao.setBounds(10, 80, 70, 20);
		Scrollpane.setBounds(75, 80, 200, 100);
		
		paine.add(lblDataInicio);
		paine.add(txtDataInicio);
		lblDataInicio.setBounds(10, 190, 95, 20);
		txtDataInicio.setBounds(80, 190, 100, 20);
		
		/*paine.add(lblDataFinal);
		paine.add(txtDataFinal);
		lblDataFinal.setBounds(10, 190, 95, 20);
		txtDataFinal.setBounds(80, 190, 100, 20);*/
		
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(80, 230, 80, 60);
		btnSalvar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection connection = JdbUtil.getConnection();
					TarefasJdbcDAO TarefasDAO = new TarefasJdbcDAO(connection);
					
					Tarefas t = new Tarefas();
					t.setTitulo(txtTitulo.getText());
					t.setpEstimado(txtpEstimado.getText());
					t.setDescricao(txtDescricao.getText());
					t.setDataInicio(txtDataInicio.getText());
					t.setDataFinal("28/01/2018");
					
					TarefasDAO.salvar(t);
					dispose();
					
				}catch(Exception v){
					v.printStackTrace();
				}
				
			}
			
		});
		
		
		
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(300, 400);
		// para não fexar todo a aplicação em cada tela devera estar escrito HIDE_On_Close ao inves de EXIT_ON_CLOSE
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

}
