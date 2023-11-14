
public class Doctor extends User{

		public Doctor(String username, String password, String firstName, String lastName) {
			
			super(username, password, firstName, lastName, false, true, false);
            docsList.add(this);
            

				
			
		}
	
}
