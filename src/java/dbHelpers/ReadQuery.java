
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;


public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
        
        Properties props = new Properties();  //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead(){
     
        
        try{
             String query = "Select * FROM customers ORDER BY CustomerID ASC";
      
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
     
        } catch (SQLException ex) {
        Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
    
    public String getHTMLTable(){
        
        
        String table = "";
        
        table += "<table>";
        
        table += "<tr>";
             table += "<th>CustomerID</th> <th>FirstName</th> <th>LastName</th> <th>Addr1</th> <th>Addr2 Wins</th> <th>City</th> <th>State</th> <th>Zip</th> <th>EmailAddr</th>";
        table += "</tr>";
        
            try {
                while(this.results.next()){
                    
                    Customers customers = new Customers();
                    customers.setCustomerID(this.results.getInt("CustomerID"));
                    customers.setFirstName(this.results.getString("FirstName"));
                    customers.setLastName(this.results.getString("LastName"));
                    customers.setAddr1(this.results.getString("Addr1"));
                    customers.setAddr2(this.results.getString("Addr2"));
                    customers.setCity(this.results.getString("City"));
                    customers.setState(this.results.getString("State"));
                    customers.setZip(this.results.getString("Zip"));
                    customers.setEmailAddr(this.results.getString("EmailAddr"));
                    
                    
                    table += "<tr>";
                    
                    table += "<td>";
                    table += customers.getCustomerID();
                    table += "</td>";
 
                    
                    table += "<td>";
                    table += customers.getFirstName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getLastName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getAddr1();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getAddr2();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getCity();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getState();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getZip();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customers.getEmailAddr();
                    table += "</td>";
                    
                    table += "<td>";
                    table += "<a href=update?CustomerID=" + customers.getCustomerID() + "> Update </a>" + "<a href=delete?playerID=" + customers.getCustomerID() + "> Delete </a>";
                    table += "</td>";
                    
                    table += "</tr>";
                   
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
          
                
                
        table +="</table>";
        
            return table;
        }
}
        
            
    


