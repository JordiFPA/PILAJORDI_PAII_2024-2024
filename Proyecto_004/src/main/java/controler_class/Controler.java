package controler_class;

import interfaces_packages.IDaos;

import java.util.List;

public class Controler<T> {
	private IDaos<T> dao;

	public Controler(IDaos<T> dao) {
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

	public void update(int id, String newName, String newLastName, int newAge) {
		dao.update(id, newName, newLastName, newAge);
	}

}