
public class Nurse extends User{

	public Nurse(String username, String password, String firstName, String lastName) {
		
		super(username, password, firstName, lastName, false, false, true);
        nursesList.add(this);
        
		
		
	}
	
	
}
