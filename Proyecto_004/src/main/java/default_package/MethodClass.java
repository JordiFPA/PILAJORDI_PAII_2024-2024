package default_package;

import javax.swing.JOptionPane;
import controler_class.Controler;
import daos_package.DaoSchedule;
import daos_package.DaoSubject;
import daos_package.DaoTeacher;
import daos_package.IDaosStudent;
import models.Schedule;
import models.Student;
import models.Subjects;
import models.Teacher;
import controler_class.Control;

public class MethodClass {

	Controler<Student> studentController = new Controler<>(new IDaosStudent());
	Controler<Teacher> teacherController = new Controler<>(new DaoTeacher());
	Controler<Subjects> subjectController = new Controler<>(new DaoSubject());
	Control<Schedule> scheduleController = new Control<>(new DaoSchedule());

	public void crearEstudiante() {
		String id = JOptionPane.showInputDialog(null, "Ingrese el id del estudiante");
		if (id != null && !id.isEmpty()) {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante:");
			if (nombre != null && !nombre.isEmpty()) {
				String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del estudiante:");
				if (apellido != null && !apellido.isEmpty()) {
					String edadStr = JOptionPane.showInputDialog(null, "Ingrese la edad del estudiante:");
					if (edadStr != null && !edadStr.isEmpty()) {
						try {
							int ID = Integer.parseInt(id);
							int edad = Integer.parseInt(edadStr);
							Student estudiante = new Student();
							estudiante.setName(nombre);
							estudiante.setLastname(apellido);
							estudiante.setAge(edad);
							estudiante.setId(ID);
							studentController.create(estudiante);
							JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente");
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "La edad ingresada no es válida. Inténtelo de nuevo.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar una edad.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar un apellido.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
			}
		}
	}

	public void deleteStudent(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				int ID = Integer.parseInt(id);
				studentController.delete(ID);
				JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intente de nuevo.");
			}
		} else {
			System.out.println("Id no es valida.");
		}
	}

	public void UpdateStudent(String studentId, String newName, String newLastname, String newAge) {
		if (studentId != null && !studentId.isEmpty()) {
			try {
				int id = Integer.parseInt(studentId);
				int age = Integer.parseInt(newAge);
				studentController.update(id, newName, newLastname, age);
				JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intentelo nuevamente");
			}
		}
	}

	// ---------------------------------------Aqui empieza los metodos varios para
	// profesor --------------------------------

	public void createTeacher() {
		String id = JOptionPane.showInputDialog(null, "Ingrese el id del profesor");
		if (id != null && !id.isEmpty()) {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del profesor:");
			if (nombre != null && !nombre.isEmpty()) {
				String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del profesor:");
				if (apellido != null && !apellido.isEmpty()) {
					String edadStr = JOptionPane.showInputDialog(null, "Ingrese la edad del profesor:");
					if (edadStr != null && !edadStr.isEmpty()) {
						try {
							int ID = Integer.parseInt(id);
							int edad = Integer.parseInt(edadStr);
							Teacher teacher = new Teacher();
							teacher.setName(nombre);
							teacher.setLastname(apellido);
							teacher.setAge(edad);
							teacher.setId(ID);
							teacherController.create(teacher);
							JOptionPane.showMessageDialog(null, "Profesor agregado correctamente");
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "La edad ingresada no es válida. Inténtelo de nuevo.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar una edad.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar un apellido.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
			}
		}
	}

	public void deleteTeacher(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				int ID = Integer.parseInt(id);
				teacherController.delete(ID);
				JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intente de nuevo.");
			}
		} else {
			System.out.println("Id no es valida.");
		}
	}

	public void UpdateTeacher(String teacherId, String newName, String newLastname, String newAge) {
		if (teacherId != null && !teacherId.isEmpty()) {
			try {
				int id = Integer.parseInt(teacherId);
				int age = Integer.parseInt(newAge);
				teacherController.update(id, newName, newLastname, age);
				JOptionPane.showMessageDialog(null, "Teacher actualizado correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intentelo nuevamente");
			}
		}
	}

///---------------Metodos para las materias ---------------------- 

	public void createSubject() {
		String id = JOptionPane.showInputDialog(null, "Ingrese el id de la materia");
		if (id != null && !id.isEmpty()) {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la materia ");
			if (nombre != null && !nombre.isEmpty()) {
				String apellido = JOptionPane.showInputDialog(null, "Ingrese la descripcion de la materia");
				if (apellido != null && !apellido.isEmpty()) {
					String edadStr = JOptionPane.showInputDialog(null, "Ingrese el nivel de la materia");
					if (edadStr != null && !edadStr.isEmpty()) {
						try {
							int ID = Integer.parseInt(id);
							int edad = Integer.parseInt(edadStr);
							Subjects subject = new Subjects();
							subject.setName(nombre);
							subject.setDescription(apellido);
							subject.setLevel(edad);
							subject.setId(ID);
							subjectController.create(subject);
							JOptionPane.showMessageDialog(null, "Materia agregada correctamente");
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "El nivel ingresado no es válidp. Inténtelo de nuevo.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar un nivel.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar una descripción.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
			}
		}
	}

	public void deleteSubject(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				int ID = Integer.parseInt(id);
				subjectController.delete(ID);
				JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intente de nuevo.");
			}
		} else {
			System.out.println("Id no es valida.");
		}
	}

	public void UpdateSubject(String teacherId, String newName, String newLastname, String newAge) {
		if (teacherId != null && !teacherId.isEmpty()) {
			try {
				int id = Integer.parseInt(teacherId);
				int age = Integer.parseInt(newAge);
				subjectController.update(id, newName, newLastname, age);
				JOptionPane.showMessageDialog(null, "Materia actualizada correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intentelo nuevamente");
			}
		}
	}

// -----------------------------------Metodos para los horarios-------------------------------------
	public void createSchedule() {
		String id = JOptionPane.showInputDialog(null, "Ingrese el id para este horario");
		if (id != null && !id.isEmpty()) {
			String id_subject = JOptionPane.showInputDialog(null, "Ingrese el id la materia ");
			if (id_subject != null && !id_subject.isEmpty()) {
				String id_student = JOptionPane.showInputDialog(null, "Ingrese el id de estudiante");
				if (id_student != null && !id_student.isEmpty()) {
					String id_teacher = JOptionPane.showInputDialog(null, "Ingrese el id del profesor");
					if (id_teacher != null && !id_teacher.isEmpty()) {
						String startTime = JOptionPane.showInputDialog(null, "Ingrese la hora de inicio (HH:MM)");
						String endTime = JOptionPane.showInputDialog(null, "Ingrese la hora de fin (HH:MM)");
						String day = JOptionPane.showInputDialog(null, "Ingrese el día de la semana");
						if (startTime != null && !startTime.isEmpty() && endTime != null && !endTime.isEmpty()
								&& day != null && !day.isEmpty()) {
							try {
								int ID = Integer.parseInt(id);
								int ID_SUBJECT = Integer.parseInt(id_subject);
								int ID_STUDENT = Integer.parseInt(id_student);
								int ID_TEACHER = Integer.parseInt(id_teacher);
								Schedule schedule = new Schedule();
								schedule.setId_subject(ID_SUBJECT);
								schedule.setId_student(ID_STUDENT);
								schedule.setId_teacher(ID_TEACHER);
								schedule.setStartTime(startTime);
								schedule.setEndTime(endTime);
								schedule.setDay(day);
								schedule.setId(ID);
								scheduleController.create(schedule);
								JOptionPane.showMessageDialog(null, "Materia agregada correctamente");
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"El ID ingresado no es válido. Inténtelo de nuevo.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Debe ingresar la hora de inicio, hora de fin y día.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar el ID del profesor.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe ingresar el ID del estudiante.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar el ID de la materia.");
			}
		}
	}

	public void deleteSchedule(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				int ID = Integer.parseInt(id);
				scheduleController.delete(ID);
				JOptionPane.showMessageDialog(null, "Horario eliminado correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intente de nuevo.");
			}
		} else {
			System.out.println("Id no es valida.");
		}
	}

	public void UpdateSchedule(String id, String idClass, String idStudent, String idTeacher, String startTime,
			String endTime, String day) {
		if (id != null && !id.isEmpty()) {
			try {
				int ID = Integer.parseInt(id);
				int IDCLASS = Integer.parseInt(idClass);
				int IDSTUDENT = Integer.parseInt(idStudent);
				int IDTEACHER = Integer.parseInt(idTeacher);
				scheduleController.update(IDCLASS, ID, IDSTUDENT, IDTEACHER, startTime, endTime, day);
				JOptionPane.showMessageDialog(null, "Materia actualizada correctamente");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Intentelo nuevamente");
			}
		}

	}

}
