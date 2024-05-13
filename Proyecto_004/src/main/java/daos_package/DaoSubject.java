package daos_package;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import interfaces_packages.IDaos;
import models.Subjects;

public class DaoSubject implements IDaos<Subjects> {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Subjects.class);

		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public void create(Subjects subject) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(subject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int Id, String newName, String description, int level) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Subjects subject = session.get(Subjects.class, Id);
			if (subject != null) {
				subject.setName(newName);
				subject.setDescription(description);
				subject.setLevel(level);
				session.update(subject);
				session.getTransaction().commit();
			} else {
				System.out.println("No se encontró ningúna materia  con ID: " + Id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Subjects subject = session.get(Subjects.class, id);
			if (subject != null) {
				session.delete(subject);
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

	}

	@Override
	public List<Subjects> readList() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Subjects", Subjects.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
