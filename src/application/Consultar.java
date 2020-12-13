package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Consultar {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from consultor");

			while (rs.next()) {
					System.out.println(rs.getInt("Id") +" - " + rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}
}