 /*
	@author Divyanshu Kumar Sharma 
 */
public class StaffManagementSystem {

    public static void main(String[] args) {
    
        /*
        Creating Users
        */
        Nurse nurse1 = new Nurse("nurse1", "123", "John", "Doe");
        Doctor doctor1 = new Doctor("doc1", "456", "Jane", "Alexander");
        Admin admin1 = new Admin("admin1", "789", "Chris", "Jackson");

        /*
        Displaying staff lists
        */
        System.out.println("Nurses:");
        for (Nurse nurse : User.nursesList) {
            System.out.println(nurse);
        }

        System.out.println("\nDoctors:");
        for (Doctor doctor : User.docsList) {
            System.out.println(doctor);
        }

        System.out.println("\nAdmins:");
        for (Admin admin : User.adminList) {
            System.out.println(admin);
        }
    }
}