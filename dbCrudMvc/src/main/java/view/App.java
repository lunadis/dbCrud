package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.JdbUtil;
import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.TarefasJdbcDAO;
import model.Metodologia;
import model.Pessoas;
import model.Tarefas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//ScrePanel principal = new ScrePanel();
    	try {
    		Connection connection = JdbUtil.getConnection();
    		
    		TarefasJdbcDAO TarefasDAO = new TarefasJdbcDAO(connection);
    		
    		TarefasDAO.listar();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	
    }
}
