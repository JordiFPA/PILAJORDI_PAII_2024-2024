package model_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecction_Class {

	private static Conecction_Class instance;
	private Connection connection;

	private Conecction_Class() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "root");

		} catch (SQLException e) {
			System.err.print("Conexion no exitosa" + e.getMessage());
		}
	}

	public static synchronized Conecction_Class getInstance() {
		if (instance == null) {
			instance = new Conecction_Class();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión: " + e.getMessage());
		}
	}

}
