
public class Nurse extends User{

	public Nurse(String username, String password) {
		
		username = super.username;
		password = super.password;
		isNurse = true;			//UI Will use this to identify difference to allow certain menu options.
		
		
	}
	
	
}
