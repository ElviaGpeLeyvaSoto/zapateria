/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eglso
 */
public class conexion {
    
    private Connection _connection = null;
    
    public conexion(){
        
        String url = "jdbc:mysql://loalhost:3306/dbzapateria?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = "admin";
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this._connection = DriverManager.getConnection(url, user, password);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public Connection getConnection(){
        return this._connection;
    }
    public void closeConnection(){
        if (this._connection!=null) {
            try {
                this._connection.close();
            } catch (SQLException ex){
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}
