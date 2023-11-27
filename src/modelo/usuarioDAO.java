/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eglso
 */
public class usuarioDAO implements CRUD {

    private final Connection _connection;
    
    public usuarioDAO(Connection _connection){
        this._connection = _connection;
    }
    
    
    public boolean agregar(Object _object) {
        
        usuario u = (usuario) _object;
        
        boolean respuesta = false;
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("INSERT INTO dbzapateria.empleado")
           .append("( id, nombre, direccion, correo, telefono, pass )")
           .append("VALUES (?,?,?,?,?,?);");
        
        PreparedStatement st;
        
        try {
            
            st = this._connection.prepareStatement(sql.toString());
            
            st.setString(1, u.getNombre());
            st.setString(2, u.getDireccion());
            st.setString(3, u.getCorreo());
            st.setString(4, u.getTelefono());
            st.setString(5, u.getPass());

            respuesta = st.execute();
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de agregar un cliente en la base de datos, error:" + ex.getMessage());
        }
        
        return respuesta;
        
    }

    @Override
    public boolean eliminar(int _object) {
    
        
        boolean respuesta = false;
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("DELETE FROM dbzapateria.empleado WHERE id = ?;");
        
        PreparedStatement st;
        
        try {
            
            st = this._connection.prepareStatement(sql.toString());
            
            st.setInt(1,_object);
            
            respuesta = st.execute();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de eliminar al usuario de la base de datos, error:" + ex.getMessage());
        }
        return respuesta;
    }

    @Override
    public boolean modificar(Object _object) {
    
        usuario u = (usuario) _object;
        
        boolean respuesta = false;
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE dbzapateria.empleado")
           .append("SET")
           .append("id = ?,")
           .append("nombre = ?,")
           .append("direccion = ?,")
           .append("correo = ?,")
           .append("telefono = ?,")
           .append("pass = ?")
           .append("WHERE id = ?;");
        
        PreparedStatement st;
        
        try {
            
            st = this._connection.prepareStatement(sql.toString());
            
            st.setString(1, u.getNombre());
            st.setString(2, u.getDireccion());
            st.setString(3, u.getCorreo());
            st.setString(4, u.getTelefono());
            st.setString(5, u.getPass());
            st.setInt(6,u.getId());

            respuesta = st.execute();
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de modificar un cliente en la base de datos, error:" + ex.getMessage());
        }
        
        return respuesta;
    }

    @Override
    public Object buscarPorId(int _id) {
        usuario u = null;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("id, ")
                .append("nombre, ")
                .append("direccion, ")
                .append("correo, ")
                .append("teléfono, ")
                .append("pass ")
            .append("FROM dbzapateria.empleado ")
            .append("WHERE id = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _id);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            if (_respuesta.next()){
                
                u = new usuario();
                
                u.setId(_respuesta.getInt("id"));
                u.setNombre(_respuesta.getString("nombre"));
                u.setDireccion(_respuesta.getString("domicilio"));
                u.setCorreo(_respuesta.getString("correo"));
                u.setTelefono(_respuesta.getString("teléfono"));
                u.setPass(_respuesta.getString("pass"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de buscar el usuario en la base de datos, error: " + ex.getMessage());
        }
        
        return u;
        
    }

    @Override
    public Object buscarPor(String _campo, String _dato) {
        List<usuario> _listUsers = new ArrayList<usuario>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("id, ")
                .append("nombre, ")
                .append("direccion, ")
                .append("correo, ")
                .append("teléfono, ")
                .append("pass ")
            .append("FROM dbzapateria.empleado ")
            .append( "WHERE " + _campo + " LIKE ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _dato);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                usuario u = new usuario();
                
                u.setId(_respuesta.getInt("id"));
                u.setNombre(_respuesta.getString("nombre"));
                u.setDireccion(_respuesta.getString("domicilio"));
                u.setCorreo(_respuesta.getString("correo"));
                u.setTelefono(_respuesta.getString("teléfono"));
                u.setPass(_respuesta.getString("pass"));
                
                _listUsers.add(u);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de buscar el usuario en la base de datos, error: " + ex.getMessage());
        }
        
        return _listUsers;
    }

    @Override
    public Object buscarTodo() {
        List<usuario> _listUsers = new ArrayList<usuario>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("id, ")
                .append("nombre, ")
                .append("direccion, ")
                .append("correo, ")
                .append("teléfono, ")
                .append("pass ")
            .append("FROM dbzapateria.empleado ");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                usuario u = new usuario();
                
                u.setId(_respuesta.getInt("id"));
                u.setNombre(_respuesta.getString("nombre"));
                u.setDireccion(_respuesta.getString("domicilio"));
                u.setCorreo(_respuesta.getString("correo"));
                u.setTelefono(_respuesta.getString("teléfono"));
                u.setPass(_respuesta.getString("pass"));
                
                _listUsers.add(u);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al momento de buscar el usuario en la base de datos, error: " + ex.getMessage());
        }
        
        return _listUsers;
        
    }
    
}
