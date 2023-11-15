
import java.util.ArrayList;

public class Appointment {
    private CalendarDate date;
    private String appReason;
    private Patient patient;
    private Doctor doc;
    

    public Appointment( CalendarDate date1, String appReason,Patient patient ,Doctor doc){
        this.date = date1;
        this.appReason = appReason;
        this.patient = patient;
        this.doc = doc;
    }

   

    public String getAppReason(){
        return appReason;
    }
    public CalendarDate getDate(){
        return date;
    }
    public Patient getPatient(){
        return patient;
    }
    public Doctor getDoc(){
        return doc;
    }

    private void reschedule(CalendarDate date){
        this.date = date;
    }

    public String toString(){
        String summary = "";
        summary += ("Appointment for: " + patient.getName() + " on " + date.toString() + " with Doctor: " + doc.getLname() + ", " +doc.getFName() + " for: " + appReason );
        return summary;
    }



}
