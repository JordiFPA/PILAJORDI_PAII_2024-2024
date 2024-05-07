package daos_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces_package.IDaoP;
import model_package.Conecction_Class;
import model_package.Teacher;

public class DaosTeacher implements IDaoP<Teacher> {
	private Connection connection;

	public DaosTeacher() {
		this.connection = Conecction_Class.getInstance().getConnection();
	}
	
	@Override
	public void createPerson(Teacher t) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO profesores  VALUES (?,?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getLast_name());
			ps.setInt(4, t.getAge());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al insertar profesor: " + e.getMessage());
		}

	}

	@Override
	public void readPersonList() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM profesores");
			ResultSet rs = ps.executeQuery();

			System.out.println("Lista de profesores:");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String lastName = rs.getString("apellido");
				int age = rs.getInt("edad");

				System.out.println("ID: " + id + ", Nombre: " + name + ", Apellido: " + lastName + ", Edad: " + age);
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al imprimir profesores: " + e.getMessage());
		}
	}

	@Override
	public void updatePerson(int id, String newName, String newLastName, int newAge) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE profesores SET name=?, apellido=?, edad=? WHERE id=?");
			ps.setString(1, newName);
			ps.setString(2, newLastName);
			ps.setInt(3, newAge);
			ps.setInt(4, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Profesor con ID " + id + " actualizado correctamente");
			} else {
				System.out.println("No se encontró ningún profesor con la ID " + id);
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al actualizar profesor: " + e.getMessage());
		}
	}

	@Override
	public void deletePerson(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM profesor WHERE id=?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Alumno con ID " + id + " eliminado correctamente");
			} else {
				System.out.println("No se encontró ningún alumno con la ID " + id);
			}

			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al eliminar alumno: " + e.getMessage());
		}
	}

}
