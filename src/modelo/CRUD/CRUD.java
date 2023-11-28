/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.CRUD;

import java.util.List;

/**
 *
 * @author eglso
 */
public interface CRUD<T> {
     public int agregar(T t);
     public void editar(T t);
     public void eliminar(int pk);
     public List<T> obtener();
     public List<T> obtener(String columna, String dato);
     public T obtener(int pk);  
    
}
