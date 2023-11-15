
public class Testing {
    public static void main(String[] args) {

        System.out.println("Testing Admin & Staff Records User Story");
        Admin admin1 = new Admin("admin1_username", "admin1_password", "admin1_Fname", "admin1_Lname");
        admin1.createUser("admin2_username", "admin2_password", "admin2_Fname", "admin2_Lname", true, false, false);
        Admin  admin3 = new Admin("admin3_username", "admin3_password", "admin3_Fname", "admin3_Lname");

        Doctor doctor1 = new Doctor("doc1_username", "doc1_password", "doc1_Fname", "doc1_Lname");
        admin1.createUser("doc2_username", "doc2_password", "doc2_Fname", "doc2_Lname",false, true, false);
        Doctor doctor3 = new Doctor("doc3_username", "doc3_password", "doc3_Fname", "doc3_Lname");

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

        System.out.println("\nTesting Admin & Appointments");
        Patient patient1 = new Patient ("Patient1_name", "Patient1_Adrress", "Patient1_medHistory", "Patient1_Diagnosis");
        admin3.createPatient(patient1);
        CalendarDate date1 = new CalendarDate(2023, 12, 1, 9, 00);
        CalendarDate date2 = new CalendarDate(2023, 12, 5, 10, 00);
        CalendarDate date3 = new CalendarDate(2023, 12, 16, 13, 00);
        String appReason = "Appointment1_Reason";
        Appointment appointment1 = new Appointment(date1, appReason, patient1, doctor3);
        Appointment appointment2 = new Appointment(date2, "Appointment2_Reason", patient1, doctor3);
        Appointment appointment3 = new Appointment(date3, "Appointment3_Reason", patient1, doctor3);
        admin3.addAppointment(appointment1);
        admin3.addAppointment(appointment2);
        admin3.addAppointment(appointment3);
        System.out.println(patient1.appointmentToString());

        System.out.println("****Testing Cancelling Appointment1 & Appointment2****");
        admin3.cancelAppointment(date1, appReason, patient1, doctor3); 
        admin3.cancelAppointment(appointment2);
        System.out.println(patient1.appointmentToString());

        System.out.println("****Testing rescheduling Appointment3****");
        admin3.rescheduleAppointment(date3, date1, "Appointment3_Reason", patient1, doctor3);
        System.out.println(patient1.appointmentToString());

        System.out.println("**** Testing adding appointment for multiple patients****" );
        Patient patient2 = new Patient("Patient2_name", "Patient2_address", "Pateint2_medHistory", "Patient2_diagnosis");
        admin3.addAppointment(new Appointment(date1, appReason,patient2, doctor3));
        System.out.print(patient1.appointmentToString());
        System.out.println(patient2.appointmentToString());

    }
}
