package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import controller.TarefasJdbcDAO;

public class ScrePanel extends JFrame {
	
	private Connection conn;
	
	public ScrePanel(Connection conn) {
		this.conn = conn;
	}

	//Painel principal que vai receber a barra de menu
	JDesktopPane painel = new JDesktopPane();
	
	//barra de menu que vai receber os componentes do menu
	JMenuBar barra = new JMenuBar();
	
	//Componentes da barra de menu
	JMenu menuP = new JMenu("Pessoas");
	JMenu menuT = new JMenu("Tarefas");
	JMenu menuM = new JMenu("Metodologia");
	JMenu menuI = new JMenu("Influencia");
	
	// sub itens ou sub componentes das barras
	JMenuItem cadPessoa;//ex: este item só fica visivel clicando no componente "PESSOAS" do menu, instancia menuP
	JMenuItem cadTarefa;
	JMenuItem cadMetodologia;
	JMenuItem cadInfluencia;
	
	
	JLabel lblIdP = new JLabel("Id Pessoa:");
	JLabel lblIdT = new JLabel("Id terefa:");
	JTextField txtIdP = new JTextField("");
	JTextField txtidT = new JTextField("");
	JLabel teste = new JLabel("");
	
	JButton btnRegistrar = new JButton("Registrar");
	
	
	public ScrePanel () {
		
		super("Software Gerenciador de Tarefas v0.0.0.1"); 
		
		
		Container paine = this.getContentPane();
		
		
		paine.add(lblIdP);
		paine.add(txtIdP);
		lblIdP.setBounds(20, 30, 80, 20);
		txtIdP.setBounds(90, 30, 40, 20);
	   
		paine.add(lblIdT);
		paine.add(txtidT);
		lblIdT.setBounds(20, 55, 50, 20);
		txtidT.setBounds(90, 55, 40, 20);
		
		
		btnRegistrar.setBounds(80, 80, 90, 40);
		paine.add(btnRegistrar);
		paine.add(teste);
		btnRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO PeVerificar = new PessoasJdbcDAO (connection);
					TarefasJdbcDAO TaVerificar = new TarefasJdbcDAO(connection);
					
					PeVerificar.select(Integer.parseInt(txtIdP.getText()));
					TaVerificar.select(Integer.parseInt(txtidT.getText()));
					
					if(PeVerificar.select(Integer.parseInt(txtIdP.getText())) == txtIdP.getText() && TaVerificar.select(Integer.parseInt(txtidT.getText())) == txtidT.getText()) {
						System.out.println("errou");						
					}else {
						String sql="INSERT INTO `relpessoatarefa` (`id_pessoa`, `id_tarefa`) VALUES ('"+txtIdP.getText()+"', '"+txtidT.getText()+"')";
						System.out.println(sql);
						PreparedStatement prepareStatement = connection.prepareStatement(sql);
						prepareStatement.executeUpdate();
						prepareStatement.close();
						JOptionPane.showMessageDialog(null,"Tarefa Atribuida","INSERIDO", JOptionPane.INFORMATION_MESSAGE);
					}
				
				}catch(Exception v) {
					
				}
				
				
			}
		});
		
		//adicionando a barra do menu no painel
		this.setJMenuBar(barra);
		
		//adicionando os componentes a barra do menu
		barra.add(menuP);
		barra.add(menuT);
		barra.add(menuM);
		barra.add(menuI);
		
		//adcionando os sub-componentes e a ação de abrir as suas respectivas telas
		menuP.add(cadPessoa = new JMenuItem("Cadastrar pessoas"));
		cadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ScrePessoas app = new ScrePessoas();
			}
		});
		
		menuT.add(cadTarefa = new JMenuItem("Cadastrar Tarefa"));
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreTarefas tare = new ScreTarefas();
			}
		});
		
		menuM.add(cadMetodologia = new JMenuItem("Cadastrar Metodologia"));
		cadMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreMetodologia meto = new ScreMetodologia();
			}
		});
		
		menuI.add(cadInfluencia = new JMenuItem("Cadastrar Influencia"));
		cadInfluencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreInfluenciador inf = new ScreInfluenciador();
			}
		});
		
		
		
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(true);
	}
	
	
	
}
