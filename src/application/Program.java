package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement  st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"delete from department "
					+" where  id=?");
			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0 ) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println(id);
				}
			}
			
			
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			
		}
	}

}
