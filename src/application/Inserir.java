package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Inserir {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO consultor"
					+ "(Name)"
					+ "VALUES"
					+ "(?)");
			
			st.setString(1, "consultor 03");
			//este proximo comando insere os dados
			st.executeUpdate();
    	}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}