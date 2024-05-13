package interfaces_packages;

import java.util.List;

public interface IDaosSc<T> {
	void create(T p);

	void update(int Id, int id_subject, int id_student, int id_teacher, String starTime, String endTime, String day);

	void delete(int id);

	void read(int id);

	List<T> readList(); 

}