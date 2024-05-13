package interfaces_packages;

import java.util.List;

public interface IDaos<T> {
	void create(T p);

	void update(int Id, String newName, String newLastname, int newAge);

	void delete(int id);

	void read(int id);

	List<T> readList();

}
