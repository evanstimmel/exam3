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

/**
 *
 * @author Evan Stimmel
 */
public class DeleteQuery {
    
    private Connection conn;
    
    public DeleteQuery(){
        
         Properties props = new Properties();  //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doDelete(int custID) throws SQLException{
        
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM customer WHERE custID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, custID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ps.close();
        }
        
    }
    
    
    
    
}

