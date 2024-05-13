package controler_class;

import interfaces_packages.IDaos;
import models.Subjects;

public class SubjectController extends Controler<Subjects> {

	public SubjectController(IDaos<Subjects> dao) {
		super(dao);
	}

}
