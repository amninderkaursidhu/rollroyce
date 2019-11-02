package javacollections;

public class Transaction {

     customer cus;
     vehcile ves;
     Rental rs;
     Reservation rsv;
     Return retn;
     String status;
    public  Transaction(customer cus,vehcile ves,Rental rs,Reservation rsv,Return retn,String status)
     {
          this.cus=cus;
          this.ves=ves;
          this.rs=rs;
          this.rsv=rsv;
          this.retn=retn;
          this.status=status;
     }

    public customer getCus() {
        return cus;
    }

    public void setCus(customer cus) {
        this.cus = cus;
    }

    public vehcile getVes() {
        return ves;
    }

    public void setVes(vehcile ves) {
        this.ves = ves;
    }

    public Rental getRs() {
        return rs;
    }

    public void setRs(Rental rs) {
        this.rs = rs;
    }

    public Reservation getRsv() {
        return rsv;
    }

    public void setRsv(Reservation rsv) {
        this.rsv = rsv;
    }

    public Return getRetn() {
        return retn;
    }

    public void setRetn(Return retn) {
        this.retn = retn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
