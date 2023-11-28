/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class baseDatos {
    //Atributos
    private Connection conn=null;
    private String error = new String();
   
    private String _url = "jdbc:mysql://localhost:3306/dzapateria?useSSL=false";
    private String _user= "root";
    private String _password ="admin";
    
//Contructor
    public baseDatos(){
         
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(_url,_user,_password);
        } catch (Exception e) {
            error = e.getMessage();
        }
        
    }

    //Getter and setter
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    //Metodos propios de la clase
    
    public void cerrarConexion(){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
