import java.util.ArrayList;

public class Patient {

    private String name;
    private String address;
    private String medHistory;
    private Staff doc;
    private String diagnosis;
    private ArrayList <Appointment> appointments;


    public Patient(String name, String address, String medHistory, Staff doc, String diagnosis, ArrayList<Appointment> appointments){
        this.name = name;
        this.address = address;
        this.medHistory = medHistory;
        this.doc = doc;
        this.diagnosis = diagnosis;
        this.appointments = appointments;
    }

    public String getName(){
        return name;
    }
    public String getAdress(){
        return address;
    }
    public String getMedHistory(){
        return medHistory;
    }
    public Staff getDoc(){
        return doc;
    }
    public String getDiagnosis(){
        return diagnosis;
    }
    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }

    private void editAddress(String address){
        this.address = address;
    }
    private void addMedHistory(String history){
        medHistory += (" " + history);
    }
    private void editDoctor(Staff doc){
        this.doc = doc;
    }
    private void addDiagnosis(String diagnosis){
        diagnosis += (" " + diagnosis);
    }
    private void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
}
