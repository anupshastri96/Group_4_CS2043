public class CalendarDate{
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;

    public CalendarDate(int year, int month, int day, int hours, int minutes){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String toString(){
        String minute = String.valueOf(minutes);
        if(minute.length() == 1){
            minute += "0";
        }
        String date ="";
        date += (month + "/" + day + "/" + year + " " + hours + ":" + minute);
        return date;
    }
}