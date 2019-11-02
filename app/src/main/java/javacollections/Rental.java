package javacollections;

public class Rental {

    String Startdate,duedate;
    public Rental(String startdate,String duedate)
    {
        this.duedate=startdate;
        this.duedate=duedate;
    }

    public String getStartdate() {
        return Startdate;
    }

    public void setStartdate(String startdate) {
        Startdate = startdate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}
