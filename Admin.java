import java.util.ArrayList;

public class Admin extends User{

   private ArrayList <Patient> patientList = new ArrayList<Patient>(); 
    //creating admin
	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName, true, false, false);
        adminList.add(this);
        
	}

    //creating admin, docs and nurses
    public void createUser(String username, String password, String firstName, String lastName, boolean isAdmin, boolean isDoctor, boolean isNurse){
        if(isAdmin){
           new Admin(username, password, firstName, lastName);
        }
        if(isDoctor){
           new Doctor(username, password, firstName, lastName);
        }
        if(isNurse){
            new Nurse(username, password, firstName, lastName);
        }
    }

    //Creating Patient
    public void createPatient(String name, String address, String medHistory, String diagnosis){
        patientList.add(new Patient(name, address, medHistory ,diagnosis));
    }
    public void createPatient(Patient patient){
        patientList.add(patient);
    }

    

    //deleting user from list
    public void deleteUser(String username){
        User tempUser = null;
        //searching for user with a matching username
        for(int i =0 ; i < userList.size(); i++){
            if (userList.get(i).getUserName() == username){
                tempUser = userList.get(i);
            }
        }
        if (tempUser.isAdmin()){
            adminList.remove(tempUser);
            userList.remove(tempUser);
        }
        if(tempUser.isDoctor()){
            docsList.remove(tempUser);
            userList.remove(tempUser);
        }
        if(tempUser.isNurse()){
            nursesList.remove(tempUser);
            userList.remove(tempUser);
        }
    }

    //updating users by deleting the user then creating a new user
    public void updateUser(String oldUsername, String newUsername, String password, String firstName, String lastName, boolean isAdmin, boolean isDoctor, boolean isNurse){
       
        deleteUser(oldUsername);
        createUser(newUsername, password, firstName, lastName, isAdmin, isDoctor, isNurse);
    }

    //view entire staff records
    public String viewStaffRecords(){
        String info =""; 
        for(int i = 0 ; i < adminList.size(); i++){
            info += ("Admin: " + adminList.get(i).toString() + "\n");
        }
        for(int i = 0 ; i < docsList.size(); i++){
            info += ("Doctor: " + docsList.get(i).toString() + "\n");
        }
        for(int i = 0 ; i < nursesList.size(); i++){
            info += ("Nurse: " + nursesList.get(i).toString() + "\n");
        }

        return info;
    }

    public void addAppointment(CalendarDate day, String appReason,Patient patient ,Doctor doc){
        patient.addAppointment(new Appointment(day, appReason, patient, doc));
    }
    public void addAppointment(Appointment appointment){
        Patient temp = appointment.getPatient();
        temp.addAppointment(appointment);
    } 

    public void rescheduleAppointment(CalendarDate oldDay, CalendarDate newDate, String appReason,Patient patient ,Doctor doc){
        cancelAppointment(oldDay, appReason, patient, doc);
        addAppointment(newDate, appReason, patient, doc);
        
    }
    public void cancelAppointment(CalendarDate date, String appReason,Patient patient ,Doctor doc){
        Appointment temp = new Appointment(date, appReason, patient, doc);
        cancelAppointment(temp);

    }
    public void cancelAppointment(Appointment appointment){
        ArrayList <Appointment> appointments = appointment.getPatient().getAppointments();
        for(int i = 0; i < appointments.size(); i++){
            Appointment temp = appointments.get(i);
            if(temp.getDate() == appointment.getDate() && temp.getPatient() == appointment.getPatient() && temp.getDoc() == appointment.getDoc()){
                appointments.remove(i);
            }
        }
    }


}
