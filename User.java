import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	
	private String firstName;
	private String lastName;

	private boolean isDoctor;
	private boolean isNurse;
	private boolean isAdmin;

    static ArrayList <User> userList = new ArrayList<User>();
    static ArrayList <Doctor> docsList = new ArrayList<Doctor>();
    static ArrayList <Nurse> nursesList = new ArrayList<Nurse>();
    static ArrayList <Admin> adminList = new ArrayList<Admin>();
   

	public User(String username, String password, String firstName, String lastName, boolean isAdmin, boolean isDoctor, boolean isNurse){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
        this.isAdmin = isAdmin;
        this.isDoctor = isDoctor;
        this.isNurse = isNurse;

        userList.add(this);	
	}

    public String getUserName(){
        return username;
    }
	public String getFName(){
		return firstName;
	}
	public String getLname(){
		return lastName;
	}
    
    public boolean isAdmin(){
        return isAdmin;
    }
    public boolean isDoctor(){
        return isDoctor;
    }
    public boolean isNurse(){
        return isNurse;
    }

    
    public String toString(){
        String info = "";
        info += (lastName + ", " + firstName + " --username: " + username);
        return info;
    }
	
	
}
