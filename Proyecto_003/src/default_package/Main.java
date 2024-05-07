package default_package;

import java.nio.file.spi.FileSystemProvider;


import daos_package.DaosAlum;
import daos_package.DaosClass;
import daos_package.DaosShedule;
import daos_package.DaosTeacher;
import model_package.Classe;
import model_package.Schedule;
import model_package.Student;
import model_package.Teacher;
/**
 * @author Jordi Pila
 * @title Practica con bases de datos. 
 */

public class Main {

	public static void main(String[] args) {

		// -------Objetos DAOS------------------------
		DaosAlum p = new DaosAlum();
		DaosTeacher t = new DaosTeacher();
		DaosClass cl = new DaosClass();
		DaosShedule sch = new DaosShedule();

		// ----------------------------------------------------
		Student Stu = new Student(1, "Jordi", "Pila", 30);
		Teacher te = new Teacher(1, "Alex", "Soldado", 38);
		Classe cl1 = new Classe(1, "Programacion 2", "Programacion avanzada", 6);
		Schedule sc = new Schedule(1, cl1.getId(), Stu.getId(), te.getId(), "07:00", "09:00", "Lunes");

		/*
		 * Agregando Alumnos a tabla alumnos -----------------------------------
		 * 
		 * p.readPersonList(); System.out.println();
		 */
		/// a.readPersonList();

		// ----------------------- Creando y guardando Profesores
		// ---------------------------------
		/*
		 * t.createPerson(te); t.readPersonList();
		 */

		// ------------------Creando y guardando clases

		/*
		 * ; cl.createClass(cl1); cl.readClass();
		 */

		// -----------------Creando horario a partir de estudiantes, profesor y materias
		// --------------------------------
		/*
		 * 
		 * sch.createSchedule(sc, Stu, te, cl1); sch.readSchedule();
		 * 
		 */

	}

}
