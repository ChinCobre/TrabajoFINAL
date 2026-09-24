package PARTE1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConexionBD {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			Dotenv dotenv = Dotenv.load();
			String dbhost = dotenv.get("DB_HOST");
			String dbport = dotenv.get("DB_PORT");
			String dbdatabase = dotenv.get("DB_DATABASE");
			String dbusername = dotenv.get("DB_USERNAME");
			String dbpassword = dotenv.get("DB_PASSWORD");
			String url = "jdbc:mysql://" + dbhost + ":" + dbport + "/" + dbdatabase;
			conn = DriverManager.getConnection(url, dbusername, dbpassword);

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

