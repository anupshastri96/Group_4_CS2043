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
    
    
	public static void main(String[] args) {
        Admin admin1 = new Admin("admin1_username", "admin1_password", "admin1_Fname", "admin1_Lname");
        admin1.createUser("admin2_username", "admin2_password", "admin2_Fname", "admin2_Lname", true, false, false);
        Admin  admin3 = new Admin("admin3_username", "admin3_password", "admin3_Fname", "admin3_Lname");

        Doctor doctor1 = new Doctor("doc1_username", "doc1_password", "doc1_Fname", "doc1_Lname");
        admin1.createUser("doc2_username", "doc2_password", "doc2_Fname", "doc2_Lname",false, true, false);
        new Doctor("doc3_username", "doc3_password", "doc3_Fname", "doc3_Lname");

        Nurse nurse1 = new Nurse("nurse1_username", "nurse1_password", "nurse1_Fname", "nurse1_Lname");
        new Nurse("nurse2_username", "nurse2_password", "nurse2_Fname", "nurse2_Lname");
        admin1.createUser("nurse3_username", "nurse3_password", "nurse3_Fname", "nurse3_Lname", false, false, true);

        System.out.println("****Printing all staff records****");
        System.out.println(admin1.viewStaffRecords());

        System.out.println("****Testing if all admins can view staff records****");
        System.out.println(admin3.viewStaffRecords());

        
        System.out.println("****Testing if admin can delete admin1, doc1, nurse1 records****");
        admin3.deleteUser("nurse1_username");
        admin3.deleteUser("admin1_username");
        admin3.deleteUser("doc1_username");
        System.out.println(admin3.viewStaffRecords());

        System.out.println("****Testing if admin can update doc3 username***");
        admin3.updateUser("doc3_username", "doc3_newUsername","doc3_password", "doc3_Fname", "doc3_Lname", false, true, false);
        System.out.println(admin3.viewStaffRecords());

        System.out.println("****Updating nurse3 to doctor4 after she went to med school****");
        admin3.updateUser("nurse3_username", "doctor4_username","doc4_password", "doc4_Fname", "doc4_Lname", false, true, false);
        System.out.println(admin3.viewStaffRecords());

    }
	
	
}
