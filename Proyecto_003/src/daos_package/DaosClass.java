package daos_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces_package.IDaoC;
import model_package.Classe;
import model_package.Conecction_Class;

public class DaosClass implements IDaoC {

	Connection connection;

	public DaosClass() {
		this.connection = Conecction_Class.getInstance().getConnection();
	}

	@Override
	public void createClass(Classe cl) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO materias VALUES (?,?,?,?)");
			ps.setInt(1, cl.getId());
			ps.setString(2, cl.getName());
			ps.setString(3, cl.getDescription());
			ps.setInt(4, cl.getLevel());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al insertar materia: " + e.getMessage());
		}
	}

	@Override
	public void updateClass(int id, String newName, String newDescription, int newLevel) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE materiales SET name=?, description=?, level=? WHERE id=?");
			ps.setString(1, newName);
			ps.setString(2, newDescription);
			ps.setInt(3, newLevel);
			ps.setInt(4, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Materia con ID " + id + " actualizado correctamente");
			} else {
				System.out.println("No se encontró ningúna materia con la ID " + id);
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al actualizar materia: " + e.getMessage());
		}
	}

	@Override
	public void readClass() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM materias");
			ResultSet rs = ps.executeQuery();

			System.out.println("Lista de materias:");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int level = rs.getInt("level");

				System.out.println("ID: " + id + ", Nombre: " + name + ", description: " + description + ", nivel: " + level);
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al imprimir las materias: " + e.getMessage());
		}
	}

	@Override
	public void deleteClass(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM materias WHERE id=?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Materia con ID " + id + " eliminado correctamente");
			} else {
				System.out.println("No se encontró ningúna materia con la ID " + id);
			}

			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al eliminar materia: " + e.getMessage());
		}
	}

}
