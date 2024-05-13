package daos_package;

import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import interfaces_packages.IDaos;
import models.Teacher;

public class DaoTeacher implements IDaos<Teacher> {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Teacher.class);

		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public void create(Teacher teacher) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(teacher);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int idTeacher, String newName, String newLastname, int newAge) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, idTeacher);
			if (teacher != null) {
				teacher.setName(newName);
				teacher.setLastname(newLastname);
				teacher.setAge(newAge);
				session.update(teacher);
				session.getTransaction().commit();
			} else {
				System.out.println("No se encontró ningún profesor con ID: " + idTeacher);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				session.delete(teacher);
				session.getTransaction().commit();
				System.out.println("Estudiante eliminado correctamente.");
			} else {
				System.out.println("No se encontró ningún estudiante con ID: " + id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int id) {
		try (Session session = sessionFactory.openSession()) {
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				System.out.println("Información del estudiante obtenida:");
				System.out.println(teacher);
			} else {
				System.out.println("No se encontró ningún estudiante con ID: " + id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> readList() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Teacher", Teacher.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
