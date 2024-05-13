package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule {
	@Id
	private int id;
	@Column(name = "id_subject")
	private int id_subject;
	@Column(name = "id_student")
	private int id_student;
	@Column(name = "id_teacher")
	private int id_teacher;
	@Column(name = "startTime")
	private String startTime;
	@Column(name = "endTime")
	private String endTime;
	@Column(name = "day")
	private String day;

	 
	public Schedule() {
	}
	public Schedule(int id, int idClass, int idStudent, int idTeacher, String startTime, String endTime, String day) {
		this.id = id;
		this.id_subject = idClass;
		this.id_student = idStudent;
		this.id_teacher = idTeacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId_subject() {
		return id_subject;
	}
	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}
	public int getId_student() {
		return id_student;
	}
	public void setId_student(int id_student) {
		this.id_student = id_student;
	}
	public int getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}
	@Override
	public String toString() {
		return "(id: " + id + ", claseID: " + id_subject + ", estudianteID: " + id_student + ", profesorID: "
				+ id_teacher + ", hora de inicio: " + startTime + ", hora de fin: " + endTime + ", dia: " + day + ")";
	}
 
	
	
	

}
