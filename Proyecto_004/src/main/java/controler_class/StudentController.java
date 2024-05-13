package controler_class;
import interfaces_packages.IDaos;
import models.Student;

public class StudentController extends Controler<Student>{

	public StudentController(IDaos<Student> dao) {
		super(dao);
		
	}
	

}
