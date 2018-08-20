package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Influenciador;

public class InfluenciadorJdbcDAO {
	private Connection conn;
	
	public InfluenciadorJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Influenciador c) throws SQLException {
		String sql="insert into influenciador (nome) values ('"+c.getNome()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `influenciador` WHERE `influenciador`.`id` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, String string) throws SQLException{
		String sql="UPDATE `influenciador` SET `nome` = '"+string+"' WHERE `influenciador`.`id` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

}
