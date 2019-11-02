package javacollections;

public class Reservation {

    String startdate,enddate;
    public Reservation(String startdate,String enddate)
    {
        this.startdate=startdate;
        this.enddate=enddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
