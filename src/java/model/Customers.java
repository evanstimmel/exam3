
package model;


public class Customers {
    
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String Addr1;
    private String Addr2;
    private String City;
    private String State;
    private String Zip;
    private String EmailAddr;
    
    
    
    public Customers() {
        this.CustomerID = CustomerID = 0;
        this.FirstName = FirstName ="";
        this.LastName = LastName = "";
        this.Addr1 = Addr1 = "";
        this.Addr2 = Addr2 = "";
        this.City = City = "";
        this.State = State = "";
        this.Zip = Zip = "";
        this.EmailAddr = EmailAddr = "";
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddr1() {
        return Addr1;
    }

    public void setAddr1(String Addr1) {
        this.Addr1 = Addr1;
    }

    public String getAddr2() {
        return Addr2;
    }
    
    public void setAddr2(String Addr2) {
        this.Addr2 = Addr2;
    }

     public String getCity() {
        return City;
    }
   
    public void setCity(String City) {
        this.City = City;
    }
    
    
    public String getState() {
        return State;
    }
    
    public void setState(String State) {
        this.State = State;
    }

     public String getZip() {
        return Zip;
    }
    
    public void setZip(String Zip) {
        this.Zip = Zip;
    }
    
     public String getEmailAddr() {
        return EmailAddr;
    }
    
    public void setEmailAddr(String EmailAddr) {
        this.EmailAddr = EmailAddr;
    }
    
    
    
    
    
    public Customers(int CustomerID, String FirstName, String LastName, String Addr1, String Addr2, String City, String State, String Zip, String EmailAddr) {
        this.CustomerID = CustomerID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Addr1 = Addr1;
        this.Addr2 = Addr2;
        this.City = City;
        this.State = State;
        this.Zip = Zip;
        this.EmailAddr = EmailAddr;
    }
    
    @Override
    public String toString() {
        return "Customers{" + "CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Addr1=" + Addr1 + ", Addr2=" + Addr2 + " "
                + ", " + "City=" + City + "," + "State=" + State + "," + "Zip=" + Zip + "," + "EmailAddr=" + EmailAddr +'}';
    }
}
    

    
