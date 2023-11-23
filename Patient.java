import java.util.ArrayList;

public class Patient {

    private String name;
    private String address;
    private String medHistory;
    private Staff doc;
    private String diagnosis;
    private ArrayList <Appointment> appointments;


    public Patient(String name, String address, String medHistory, String diagnosis){
        this.name = name;
        this.address = address;
        this.medHistory = medHistory;
        this.diagnosis = diagnosis;
        this.appointments = new ArrayList<Appointment>();
    }
    public String patientToString(){
        String temp = "";
        temp += ("Patient Name: " + name + " Patient Adress: " + address + "\nPatient Medical History: "  + medHistory + "\nPatient Diagnosis: " + diagnosis + "\nAppointments: " + appointmentToString());
        return temp;
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
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    public String appointmentToString(){
        String viewAppointment ="";
        for(int i =0; i < appointments.size(); i++){
            viewAppointment += (appointments.get(i).toString() +"\n");
        }
        return viewAppointment;
    }
}
