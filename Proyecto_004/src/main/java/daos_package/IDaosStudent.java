package daos_package;

import interfaces_packages.IDaos;
import models.Student;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IDaosStudent implements IDaos<Student> {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public void create(Student student) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int studentId, String newName, String newLastname, int newAge) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if (student != null) {
				student.setName(newName);
				student.setLastname(newLastname);
				student.setAge(newAge);
				session.update(student);
				session.getTransaction().commit();
			} else {
				System.out.println("No se encontró ningún estudiante con ID: " + studentId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int studentId) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if (student != null) {
				session.delete(student);
				session.getTransaction().commit();
				System.out.println("Estudiante eliminado correctamente.");
			} else {
				System.out.println("No se encontró ningún estudiante con ID: " + studentId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int studentId) {
		try (Session session = sessionFactory.openSession()) {
			Student student = session.get(Student.class, studentId);
			if (student != null) {
				System.out.println("Información del estudiante obtenida:");
				System.out.println(student);
			} else {
				System.out.println("No se encontró ningún estudiante con ID: " + studentId);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> readList() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Student", Student.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
