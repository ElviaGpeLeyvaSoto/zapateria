/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author eglso
 */
public class venta {
    private int id;
    private String folio;
    private int zapato;
    private double subtotal;

    public venta() {
    }

    public venta(int id, String folio, int zapato, double subtotal) {
        this.id = id;
        this.folio = folio;
        this.zapato = zapato;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getZapato() {
        return zapato;
    }

    public void setZapato(int zapato) {
        this.zapato = zapato;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
