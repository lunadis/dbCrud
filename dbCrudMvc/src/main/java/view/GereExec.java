package view;

import java.sql.Connection;

import controller.InfluenciadorJdbcDAO;
import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.TarefasJdbcDAO;
import controller.JdbUtil;
import model.Influenciador;
import model.Metodologia;
import model.Pessoas;
import model.Tarefas;

public class GereExec {

	public static void main(String[] args) {
		Pessoas p = new Pessoas();
		Influenciador i = new Influenciador();
		Metodologia m = new Metodologia();
		Tarefas t = new Tarefas();
		
		try {
			p.setNome("Luis");
			p.setEmail("luis@luis");
			p.setSexo("m");
			
			i.setNome("Bom-humor");
			
			m.setNome("Scrum");
			
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO PessoasJdbDAO = new PessoasJdbcDAO(connection);
			InfluenciadorJdbcDAO inlfuenciadorJdbDAO = new InfluenciadorJdbcDAO (connection);
			MetodologiaJdbcDAO metodologiaJdbDAO = new MetodologiaJdbcDAO(connection);
			TarefasJdbcDAO tarefasJdbDAO = new TarefasJdbcDAO(connection);
			
			PessoasJdbDAO.salvar(p);
			inlfuenciadorJdbDAO.salvar(i);
			metodologiaJdbDAO.salvar(m);
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		

	}

}
