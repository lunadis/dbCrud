package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Tarefas;

public class TarefasJdbcDAO {
	private Connection conn;
	
	public TarefasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefas c) throws SQLException{
		String sql="insert into tarefas(titulo,pEstimado,descricao,dataInicio,dataFInal) values ('"+c.getTitulo()+"','"+c.getpEstimado()+"','"+c.getDescricao()+"','"+c.getDataInicio()+"','"+c.getDataFinal()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(int b, String string) throws SQLException{
		String sql="Update 'terefa' SET 'titulo' = '"+string+"' WHERE 'terefas','id' = "+b+"";
		System.out.println();
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM 'terefas' WHERE 'tarefa','id' ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
}
