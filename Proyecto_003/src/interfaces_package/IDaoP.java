package interfaces_package;

public interface IDaoP<T> {
	public void createPerson(T person);
	public void readPersonList();
	public void updatePerson(int id, String newName, String newLastName, int newAge); 
	public void deletePerson(int id);
}
