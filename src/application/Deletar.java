package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityExcepition;

public class Deletar {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM consultor "
					+ "WHERE "
					+ "(Id = ?)");
			
			st.setInt(1, 2);
			int rowsAffected = st.executeUpdate();
			System.out.println("Feito! Colunas afetadas: " + rowsAffected);
	    }
		catch (SQLException e) {
			throw new DbIntegrityExcepition(e.getMessage());
		} 
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}