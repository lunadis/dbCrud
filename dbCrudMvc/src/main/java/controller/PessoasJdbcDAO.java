package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import model.Pessoas;

public class PessoasJdbcDAO {
	private Connection conn;
	
	public PessoasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Pessoas c) throws SQLException{
		String sql="insert into pessoas (nome, email, sexo) values ('"+c.getNome()+"','"+c.getEmail()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="DELETE FROM `pessoas` WHERE `pessoas`.`id_pessoa` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int a, String string) throws SQLException{
		String sql="UPDATE `pessoas` SET `nome` = '"+string+"' WHERE `alunos`.`id_pessoa` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public String select(int a) throws SQLException{
		String sql="SELECT * FROM `pessoas` WHERE `id_pessoa` = "+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		
		System.out.println(rs.next());
		
		String rsf = rs.getString(a);
		System.out.println(rsf);
		prepareStatement.close();
		
		return	rsf;	
	}
}
