package interfaces_package;

import model_package.Classe;

public interface IDaoC {
	void createClass(Classe cl); 
	void updateClass(int id, String newName, String newDescription, int newLevel); 
	void readClass(); 
	void deleteClass(int id);
}
