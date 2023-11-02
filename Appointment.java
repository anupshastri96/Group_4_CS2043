import java.sql.Date;

public class Appointment {
    private Date day;
    private String appReason;
    private Patient patient;
    private Staff doc;

    public Appointment(Date day, String appReason,Patient patient ,Staff doc){
        this.day = day;
        this.appReason = appReason;
        this.patient = patient;
        this.doc = doc;
    }

    private String getAppReason(){
        return appReason;
    }
    private Date getDate(){
        return day;
    }
    private Patient getPatient(){
        return patient;
    }
    private Staff getDoc(){
        return doc;
    }

    private void reschedule(Date day){
        this.day = day;
    }

    public String toString(){
        String summary = "";
        summary += ("Appointment for: " + patient.getName() + " on " + day + " with Doctor: " + doc.getName() + " for: " + appReason );
        return summary;
    }



}
