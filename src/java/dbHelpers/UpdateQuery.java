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
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author Evan Stimmel
 */
public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery() {
        
          Properties props = new Properties();  //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void doUpdate (Customers customers) throws SQLException{
        
            String query = "UPDATE customers SET FirstName = ?, LastName = ?, Addr1 = ?, Addr2 = ?, City = ?, State = ?, Zip = ?, EmailAddr = ? WHERE CustomerID = ?";
    
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, customers.getFirstName());
            ps.setString(2, customers.getLastName());
            ps.setString(3, customers.getAddr1());
            ps.setString(4, customers.getAddr2());
            ps.setString(5, customers.getCity());
            ps.setString(6, customers.getState());
            ps.setString(7, customers.getZip());
            ps.setString(8, customers.getEmailAddr());

            ps.executeUpdate();

}
    
}