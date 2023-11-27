/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author eglso
 */
public interface CRUD {
    boolean agregar(Object _object);
    boolean eliminar(int _object);
    boolean modificar(Object _object);
    Object buscarPorId(int _id);
    Object buscarPor(String _campo, String _dato);
    Object buscarTodo();
}
