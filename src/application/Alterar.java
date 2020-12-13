package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Alterar {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE aluno "
					+ "SET Parcela = ? "
					+ "WHERE "
					+ "(Id = ?)");
			
			st.setDouble(1, 213.0);
			st.setInt(2, 5);
			
			int rowsAffected = st.executeUpdate();
			
			//OBS.: uma outra forma de ALTERAR com os dados seria:
			//INT ROWS1 = st.executeUpdate("UPDATE consultor SET Name = Consultor WHERE Id = 4");
			
			System.out.println("Feito! Colunas afetadas: " + rowsAffected);
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