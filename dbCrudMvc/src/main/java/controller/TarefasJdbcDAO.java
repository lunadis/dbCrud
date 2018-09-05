package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Tarefas;

public class TarefasJdbcDAO {
	private Connection conn;
	
	public TarefasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefas c) throws SQLException{
		String sql="insert into tarefa(titulo,pEstimado,descricao,dataInicio,dataFInal) values ('"+c.getTitulo()+"','"+c.getpEstimado()+"','"+c.getDescricao()+"','"+c.getDataInicio()+"','"+c.getDataFinal()+"')";
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
		String sql="DELETE FROM 'terefa' WHERE 'tarefa','id' ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	 
	
	// metodo para verificar se a seleção é valida
	public String select(int a) throws SQLException{
		
		String sql="SELECT * FROM `tarefa` WHERE `id_tarefa` = "+a+"";
		System.out.println(sql);
		
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs2 = prepareStatement.executeQuery();
		
		//checando o resultado da query
		System.out.println(rs2.next());
		
		//armazenando o resultado em uma string para usar no controlador de fluxo
		String rsf = rs2.getString(a);
		
		//checando
		System.out.println(rsf);
		prepareStatement.close();
		
		return	rsf;	
	}
	
	public List<Tarefas> listar(){
		
		String sql = "select * 'from tarefas'";
		System.out.println(sql);
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
			try {
				PreparedStatement preparedStatment = this.conn.prepareStatement(sql);
				ResultSet rs = preparedStatment.executeQuery();
				//enquanto ainda houver indices para percorrerer (.next() tem a função de percorrer os indices da query);
				while(rs.next()) {
					
					int id_tarefa = rs.getInt("id");
					String titulo = rs.getString("titulo");
					String PrazoEstimado = rs.getString("pEstimado");
					String descricao = rs.getString("descricao");
					String dataInicio = rs.getString("dataInicio");
					String datafinal = rs.getString("dataFinal");
					
					Tarefas tarefa = new Tarefas();
					
					tarefa.setTitulo(titulo);
					tarefa.setpEstimado(PrazoEstimado);
					tarefa.setDescricao(descricao);
					tarefa.setDataInicio(dataInicio);
					tarefa.setDataFinal(datafinal);
				}
				preparedStatment.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
			return tarefas;
			
		
	}
	
}
