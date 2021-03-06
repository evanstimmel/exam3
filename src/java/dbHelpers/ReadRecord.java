/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Evan Stimmel
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Customers customer = new Customers();
    private int CustomerID;
    
    public ReadRecord (int CustomerID) {
    
      Properties props = new Properties();  //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.CustomerID = CustomerID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public Customers getCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void doRead() {
    
        try {
            
            String query = "SELECT * FROM customer WHERE CustID = ?";
            
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement (query);
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                ps.setInt(1, CustomerID);
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            customer.setCustID(this.results.getInt("CustID"));
            customer.setFirstName(this.results.getString("FirstName"));
            customer.setLastName(this.results.getString("LastName"));
            customer.setAddr1(this.results.getString("Addr1"));
            customer.setAddr2(this.results.getString("Addr2"));
            customer.setCity(this.results.getString("City"));
            customer.setCustState(this.results.getString("State"));
            customer.setZip(this.results.getString("Zip"));
            customer.setEmailAddr(this.results.getString("EmailAddr"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
  
        
        
   
    
    public Customers getCutomers(){
       
        return this.customer;
    
}

}
    

    

