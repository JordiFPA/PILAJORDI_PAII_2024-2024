package model_package;

public class Schedule {
	private int id;
	private int idClass;
	private int idStudent;
	private int idTeacher;
	private String startTime;
	private String endTime;
	private String day;

	public Schedule(int id,int idClass, int idStudent, int idTeacher, String startTime, String endTime, String day) {
		this.id= id;
		this.idClass = idClass;
		this.idStudent = idStudent;
		this.idTeacher = idTeacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public int getIdClass() {
		return idClass;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
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
	
}
