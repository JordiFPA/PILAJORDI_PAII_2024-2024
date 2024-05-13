package controler_class;
import interfaces_packages.IDaos;
import models.Teacher;

public class TeacherController  extends Controler<Teacher>{

	public TeacherController(IDaos<Teacher> dao) {
		super(dao);
	}

}
