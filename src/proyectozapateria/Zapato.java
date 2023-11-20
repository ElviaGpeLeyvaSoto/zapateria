/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozapateria;

/**
 *
 * @author Carlos Espinoza
 */
public class Zapato {
    
    
    public Zapato(){
        
    }

    public Zapato(String nombre,  float precio, int cantidad,String catalogo) {
        this.nombre = nombre;
        this.catalogo = catalogo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    
    
    
    private String nombre;
    private String catalogo;
    private float precio;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
