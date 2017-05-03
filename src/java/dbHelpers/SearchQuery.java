
package dbHelpers;

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


public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        Properties props = new Properties();  //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void doSearch (String firstname) throws SQLException {
        
        String query = "SELECT * FROM customer WHERE UPPER (firstName) LIKE ? ORDER BY CustID ASC";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + firstname.toUpperCase() + "%");
        this.results = ps.executeQuery();
  }
    
     public String getHTMLTable(){
        
        
        String table = "";
        
        table += "<table>";
        
        table += "<tr>";
             table += "<th>CustomerID</th> <th>FirstName</th> <th>LastName</th> <th>Addr1</th> <th>Addr2</th> <th>City</th> <th>State</th> <th>Zip</th> <th>EmailAddr</th>";
        table += "</tr>";
        
            try {
                while(this.results.next()){
                    
                    Customers customer = new Customers();
                    customer.setCustID(this.results.getInt("custID"));
                    customer.setFirstName(this.results.getString("firstName"));
                    customer.setLastName(this.results.getString("lastName"));
                    customer.setAddr1(this.results.getString("addr1"));
                    customer.setAddr2(this.results.getString("addr2"));
                    customer.setCity(this.results.getString("city"));
                    customer.setCustState(this.results.getString("custState"));
                    customer.setZip(this.results.getString("zip"));
                    customer.setEmailAddr(this.results.getString("emailAddr"));
                    
                    table += "<tr>";
                    
                    table += "<td>";
                    table += customer.getCustID();
                    table += "</td>";
 
                    
                    table += "<td>";
                    table += customer.getFirstName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getLastName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getAddr1();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getAddr2();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getCity();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getCustState();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getZip();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getEmailAddr();
                    table += "</td>";
                    
                    table += "<td>";
                    table += "<a href=update?CustID=" + customer.getCustID() + "> Update </a>" + "<a href=delete?CustID=" + customer.getCustID() + "> Delete </a>";
                    table += "</td>";
                    
                    table += "</tr>";
                   
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
          
                
                
        table +="</table>";
        
            return table;
        }
    
}



