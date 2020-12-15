package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnexion {

	private final static String dbName = "dbb4mtke988ghd";
	private final static String urlConnection = "jdbc:postgresql://ec2-52-0-155-79.compute-1.amazonaws.com:5432/"
			+ dbName;
	private final static String login = "hhxuphgehzrizj";
	private final static String pwd = "b7bfd568fb375c6b461102563eaa3a3197bca8d280425fb1b387b8d59113ddf8";
	private static Connection connexion;

	public static PreparedStatement getPs(String query) {
		PreparedStatement ps = null;
		try {
			if (connexion == null || connexion.isClosed()) {
				Class.forName("org.postgresql.Driver");

				connexion = DriverManager.getConnection(urlConnection, login, pwd);
				ps = connexion.prepareStatement(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public static void close() {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
