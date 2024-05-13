package controler_class;
import interfaces_packages.IDaosSc;
import models.Schedule;

public class ScheduleController extends Control<Schedule> {

	public ScheduleController(IDaosSc<Schedule> dao) {
		super(dao);
	}


}
