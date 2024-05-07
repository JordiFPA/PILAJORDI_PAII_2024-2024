package daos_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces_package.IDaoH;
import model_package.Classe;
import model_package.Conecction_Class;
import model_package.Schedule;
import model_package.Student;
import model_package.Teacher;

public class DaosShedule implements IDaoH{
	private Connection connection;
	
	
	public DaosShedule() {
		this.connection = Conecction_Class.getInstance().getConnection();
	}
	
	@Override
	public void createSchedule(Schedule cl,Student s, Teacher t, Classe c ) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO horario VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, cl.getId());
			ps.setInt(2, c.getId());
			ps.setInt(3, s.getId());
			ps.setInt(4, t.getId());
			ps.setString(5, cl.getStartTime()); 
			ps.setString(6, cl.getEndTime());
			ps.setString(7, cl.getDay());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al insertar el horario: " + e.getMessage());
		}
		
	}

	@Override
	public void updateSchedule(int id, int newID_Class, int newID_Student, int newID_Teacher, String newStartTime, String newEndTime, String newDay) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE horario SET id_materia=?, id_alumno=?, id_profesor=?, hora_inicio=?, hora_fin=?, dia =? WHERE id=?");
			ps.setInt(1, newID_Class);
			ps.setInt(2, newID_Student);
			ps.setInt(3, newID_Teacher);
			ps.setString(4, newStartTime);
			ps.setString(5, newEndTime);
			ps.setString(6, newDay);
			ps.setInt(7, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Horario con ID " + id + " actualizado correctamente");
			} else {
				System.out.println("No se encontró ningún horario con la ID " + id);
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al actualizar horario: " + e.getMessage());
		}
		
	}

	@Override
	public void readSchedule() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM horario");
			ResultSet rs = ps.executeQuery();

			System.out.println("Lista de horario:");

			while (rs.next()) {
				int id = rs.getInt("id");
				int idClass = rs.getInt("id_materia");
				int idStudent = rs.getInt("id_alumno");
				int idTeacher = rs.getInt("id_profesor");
				String startTime = rs.getString("hora_inicio");
				String endTime = rs.getString("hora_fin");
				String day = rs.getString("dia");

				System.out.println("ID: " + id + ", ID de clase: " + idClass + ", ID de alumno: " + idStudent + ", ID de profesor: " + idTeacher
						+ ", Hora de inicio: "+startTime + ", Hora fin: "+endTime + ", Dia: " + day);
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al imprimir el horario: " + e.getMessage());
		}
		
	}

	@Override
	public void deleteSchedule(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM horario WHERE id=?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Horario con ID " + id + " eliminado correctamente");
			} else {
				System.out.println("No se encontró ningún horario con la ID " + id);
			}

			ps.close();
		} catch (SQLException e) {
			System.err.println("Error al eliminar el horario: " + e.getMessage());
		}

	}

	

}
