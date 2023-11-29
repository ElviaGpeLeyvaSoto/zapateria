/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.CRUD.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.conexion.baseDatos;
import controlador.usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eglso
 */
public class usuarioDAO implements CRUD<usuario> {

    @Override
    public int agregar(usuario u) {
        
        baseDatos bd = new baseDatos();
        int numero_control = 0;

        try {

            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO dbzapateria.empleado")
                .append("( id, nombre, direccion, correo, telefono, rol, pass )")
                .append("VALUES (?,?,?,?,?,?,?);");

                PreparedStatement st = bd.getConn().prepareStatement(sql.toString(),
                        PreparedStatement.RETURN_GENERATED_KEYS);

                
                st.setString(1, u.getNombre());
                st.setString(2, u.getDireccion());
                st.setString(3, u.getCorreo());
                st.setString(4, u.getTelefono());
                st.setString(5, u.getRol());
                st.setString(6, u.getPass());

                if (st.executeUpdate() == 1) {

                    ResultSet keys = st.getGeneratedKeys();
                    if (keys.next()) {
                        numero_control = keys.getInt(1);
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
            e.printStackTrace();
        } finally {
            bd.cerrarConexion();
        }
        return numero_control;
    
    }

    @Override
    public void editar(usuario u) {
        baseDatos bd = new baseDatos();
        int respuesta = 0;

        try {

            if (bd.getConn() != null) {
                StringBuilder cons = new StringBuilder();

                cons.append("UPDATE dbzapateria.empleado")
                .append("SET")
                .append("id = ?,")
                .append("nombre = ?,")
                .append("direccion = ?,")
                .append("correo = ?,")
                .append("telefono = ?,")
                .append("rol = ?")
                .append("pass = ?")
                .append("WHERE id = ?;");
                PreparedStatement st = bd.getConn().prepareStatement(cons.toString());

                st.setString(1, u.getNombre());
                st.setString(2, u.getDireccion());
                st.setString(3, u.getCorreo());
                st.setString(4, u.getTelefono());
                st.setString(5,u.getRol());
                st.setString(6, u.getPass());
                st.setInt(7,u.getId());

                if (st.executeUpdate() == 1) {

                    respuesta = 1;

                }
            }

        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
    }

    @Override
    public void eliminar(int pk) {
        
        baseDatos bd = new baseDatos();
        int respuesta = 0;

        try {
            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append("DELETE FROM dbzapateria.empleado WHERE id = ?;");

                PreparedStatement st = bd.getConn().prepareStatement(sql.toString());

                st.setInt(2, pk);

                if (st.executeUpdate() == 1) {

                    respuesta = 1;

                }
            }
        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
        
    }

    @Override
    public List<usuario> obtener() {
        
        baseDatos bd = new baseDatos();
        List<usuario> _listUsers = new ArrayList();
        try {
            
            if(bd.getConn() != null){
                StringBuilder consulta = new StringBuilder();
                
                consulta.append("SELECT * FROM dbzapateria.empleado;");
                PreparedStatement st = bd.getConn().prepareStatement(consulta.toString());
                
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    
                    usuario u = new usuario();
                
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setDireccion(rs.getString("domicilio"));
                    u.setCorreo(rs.getString("correo"));
                    u.setTelefono(rs.getString("teléfono"));
                    u.setRol(rs.getString("rol"));
                    u.setPass(rs.getString("pass"));
                
                    _listUsers.add(u);
                    
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR]:" );
        }finally{
            bd.cerrarConexion();
        }
        return _listUsers;
    
    }

    @Override
    public List<usuario> obtener(String columna, String dato) {
        
        baseDatos bd = new baseDatos();
       List<usuario> _listUsers = new ArrayList();

        try {

            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();

                sql.append("SELECT * FROM dbzapateria.empleado ")
                        .append(" WHERE ")
                        .append(dato).append(" LIKE ? ");

                PreparedStatement st = bd.getConn().prepareStatement(sql.toString());

                st.setString(1, "%" + dato + "%");

                ResultSet rs = st.executeQuery();

                while(rs.next()){
                    
                    usuario u = new usuario();
                
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setDireccion(rs.getString("domicilio"));
                    u.setCorreo(rs.getString("correo"));
                    u.setTelefono(rs.getString("teléfono"));
                    u.setRol(rs.getString("rol"));
                    u.setPass(rs.getString("pass"));
                
                    _listUsers.add(u);
                    
                }
            }

        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
        return _listUsers;
        
    }

    @Override
    public usuario obtener(int pk) {
    
        baseDatos bd = new baseDatos();  
        usuario u = new usuario();

        try {

            if (bd.getConn() != null) {
                StringBuilder sql = new StringBuilder();

                sql.append("SELECT * dbzapateria.empleado ")
                        .append(" WHERE ")
                        .append(" id = ? ");

                PreparedStatement st = bd.getConn().prepareStatement(sql.toString());

                st.setInt(1, pk);

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                      

                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setDireccion(rs.getString("domicilio"));
                    u.setCorreo(rs.getString("correo"));
                    u.setTelefono(rs.getString("teléfono"));
                    u.setRol(rs.getString("rol"));
                    u.setPass(rs.getString("pass"));

                }
            } else {
                JOptionPane.showMessageDialog(null, "ID no encontrado");
            }

        } catch (Exception e) {
            
        } finally {
            bd.cerrarConexion();
        }
        return u;
        
    }

    

   
    
}
