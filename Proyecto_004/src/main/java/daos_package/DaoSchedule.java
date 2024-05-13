package daos_package;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import interfaces_packages.IDaosSc;
import models.Schedule;

public class DaoSchedule implements IDaosSc<Schedule> {

	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Schedule.class);

		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public void create(Schedule schedule) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(schedule);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int Id, int id_subject, int id_student, int id_teacher, String starTime, String endTime,
			String day) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Schedule schedule = session.get(Schedule.class, Id);
			if (schedule != null) {
				schedule.setId_subject(id_subject);
				schedule.setId_student(id_student);
				schedule.setId_teacher(id_teacher);
				schedule.setStartTime(starTime);
				schedule.setEndTime(endTime);
				schedule.setDay(day);
				session.update(schedule);
				session.getTransaction().commit();
			} else {
				System.out.println("No se encontró ningún horario con ID: " + Id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Schedule schedule = session.get(Schedule.class, id);
			if (schedule != null) {
				session.delete(schedule);
				session.getTransaction().commit();
				System.out.println("Horario eliminado correctamente.");
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
	public List<Schedule> readList() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Schedule", Schedule.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
