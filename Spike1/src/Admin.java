
public class Admin extends User{

	public Admin(String username, String password) {
		
		username = super.username;
		password = super.password;
		isAdmin = true;			//UI Will use this to identify difference to allow certain menu options.
			
		
	}

	
	
}
