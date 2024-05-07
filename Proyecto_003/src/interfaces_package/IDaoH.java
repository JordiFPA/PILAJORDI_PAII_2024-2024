package interfaces_package;

import model_package.Classe;
import model_package.Schedule;
import model_package.Student;
import model_package.Teacher;

public interface IDaoH {
	void createSchedule(Schedule sh, Student s, Teacher t, Classe c); 
	void updateSchedule(int id, int newID_Class, int newID_Student, int newID_Teacher, String newStartTime, String newEndTime, String newDay); 
	void readSchedule(); 
	void deleteSchedule(int id);
}
