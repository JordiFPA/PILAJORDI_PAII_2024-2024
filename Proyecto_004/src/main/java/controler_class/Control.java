package controler_class;

import java.util.List;
import interfaces_packages.IDaosSc;

public class Control <T>{

	private IDaosSc<T> dao;

	public Control(IDaosSc<T> dao) {
		this.dao = dao;
	}

	public void create(T entity) {
		dao.create(entity);
	}

	public List<T> readList() {
		return dao.readList();
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(int Id, int id_subject, int id_student, int id_teacher, String starTime, String endTime, String day) {
		dao.update(Id, id_subject, id_student, id_teacher, starTime, endTime, day);
	}
}
