 /*
	@author Divyanshu Kumar Sharma 
 */
public class StaffSchedule {

    public static void main(String[] args) {

        Nurse nurse1 = new Nurse("nurse1", "123", "John", "Doe");
        Doctor doctor1 = new Doctor("doc1", "456", "Jane", "Alexander");
        Admin admin1 = new Admin("admin1", "789", "Chris", "Jackson");

        nurse1.addShift(new Shift("Monday", "9:00 AM", "5:00 PM"));
        doctor1.addShift(new Shift("Wednesday", "1:00 PM", "9:00 PM"));

        displayStaffSchedule(nurse1);
        displayStaffSchedule(doctor1);
        displayStaffSchedule(admin1);
    }

    private static void displayStaffSchedule(User user) {
        System.out.println("Schedule for " + user.getFirstName() + " " + user.getLastName() + ":");
        for (Shift shift : user.getShifts()) {
            System.out.println(shift);
        }
        System.out.println();
    }
}