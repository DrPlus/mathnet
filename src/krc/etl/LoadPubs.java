package krc.etl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import krc.util.MySQLUtils;

public class LoadPubs {
	private void getAuthors() {
		try {
			Connection conn = MySQLUtils.getMySQLConnection();
			Statement st = conn.createStatement();
			ResultSet rss = st.executeQuery("select id, personid, lastname from authors where personid is not null order by lastname");
			while (rss.next()) {
				System.out.println(rss.getString(3));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		LoadPubs lp = new LoadPubs();
		lp.getAuthors();
		// TODO Auto-generated method stub

	}

}
