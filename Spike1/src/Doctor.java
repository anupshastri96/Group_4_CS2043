
public class Doctor extends User{

		public Doctor(String username, String password) {
			
			username = super.username;
			password = super.password;
			isDoctor = true;			//UI Will use this to identify difference to allow certain menu options.
				
			
		}
	
}
