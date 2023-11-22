import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTesting{

    private Admin admin3;
    private Doctor doctor3;
    private Nurse nurse3;
    private User user1;
    private CalendarDate date1;
    private CalendarDate date2;
    private CalendarDate date3;

    @Before
    public void setUp() {
        admin3 = new Admin("admin3_username", "admin3_password", "admin3_Fname", "admin3_Lname");
        doctor3 = new Doctor("doc3_username", "doc3_password", "doc3_Fname", "doc3_Lname");
        nurse3 = new Nurse("nurse3_username", "nurse3_password", "nurse3_Fname", "nurse3_Lname");
        user1 = new User("user1_username","user1_password", "user1_Fname", "user1_Lname",true,false,false); 
        date1 = new CalendarDate(2023, 12, 1, 9, 00);
        date2 = new CalendarDate(2023, 12, 5, 10, 00);
        date3 = new CalendarDate(2023, 12, 16, 13, 00);
    }

    @Test
    public void testDoctor() {
         
    }

    @Test
    public void testAdmin() {

    }

    @Test
    public void testPatient() {  
        Patient patient1 = new Patient("Patient1_name", "Patient1_Adrress", "Patient1_medHistory", "Patient1_Diagnosis");
        Appointment  ap1 = new Appointment(date1,"Lungs issue", patient1, doctor3); 
        patient1.addAppointment(ap1);
        
	    assertEquals(patient1.getName(), "Patient1_name"); 
	    
	    assertEquals(patient1.getAdress(), "Patient1_Adrress"); 
	    
	    
    }

    @Test
    public void testNurse() {

    }

    
    @Test
    public void testAppointment() {
    	Patient patient1 = new Patient("Patient1_name", "Patient1_Adrress", "Patient1_medHistory", "Patient1_Diagnosis");
        Appointment  ap1 = new Appointment(date1,"Lungs issue", patient1, doctor3); 
        
        assertEquals(ap1.getAppReason(),"Lungs issue");
        
        assertEquals(ap1.getDoc(),doctor3);
    }

    
    @Test
    public void testMedicalSupplies() {

    }

    @Test
    public void testMedicalSupplyInventory() {

    }

    @Test
    public void testShift() {

    }

    @Test
    public void testStaffSchedule() {

    }

 
}
