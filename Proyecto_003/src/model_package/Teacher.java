package model_package;

public class Teacher {
	private int id;
	private String name;
	private String last_name;
	private int age;
	
	public Teacher(int id, String name, String last_name, int age) {
		this.id= id; 
		this.name = name; 
		this.last_name = last_name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
