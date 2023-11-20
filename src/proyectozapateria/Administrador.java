/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozapateria;

/**
 *
 * @author carlo
 */
public class Administrador {
    
    private Zapato[] zapatillas = new Zapato[30];
    private Zapato[] zapatoCerrado = new Zapato[30];
    private Zapato[] tenis = new Zapato[30];
    private Zapato[] huaraches = new Zapato[30];

    public boolean agregarZapato(String nombre, float precio, int cantidad, String catalogo) {

        Zapato zapato = new Zapato(nombre, precio, cantidad, catalogo);

        switch (catalogo.toUpperCase()) {

            case "ZAPATILLAS":
                for (int i = 0; i < 30; i++) {
                     if(zapatillas[i]==null)
                     {
                         zapatillas[i]=zapato;
                         return true;
                     } else {
                         
                     }       
                    
                }
                
                break;
            case "ZAPATOCERRADO":
                for (int i = 0; i < 30; i++) {
                     if(zapatoCerrado[i]==null)
                     {
                         zapatoCerrado[i]=zapato;
                         return true;
                     } else {
                         
                     }       
                    
                }
                break;
            case "TENIS":
                for (int i = 0; i < 30; i++) {
                     if(tenis[i]==null)
                     {
                         tenis[i]=zapato;
                         return true;
                     } else {
                         
                     }       
                    
                }
                break;
            case "HUARACHES":
                for (int i = 0; i < 30; i++) {
                     if(huaraches[i]==null)
                     {
                         huaraches[i]=zapato;
                         return true;
                     } else {
                         
                     }       
                    
                }
                break;
            default:
                break;
        }

        return false;
    }
    
    public boolean modificarPrecio(String nombre, float precio)
    {
        for (int i = 0; i < 30; i++) {
            if (zapatillas[i]!=null&&zapatillas[i]!=null&&zapatillas[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatillas[i].setPrecio(precio);
                
                return true;
            } else if(zapatoCerrado[i]!=null&&zapatoCerrado[i]!=null&&zapatoCerrado[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatoCerrado[i].setPrecio(precio);
                
                return true;
            } else if  (tenis[i]==null&&tenis[i]!=null&&tenis[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                tenis[i].setPrecio(precio);
                return true;
            } else if (huaraches[i]!=null&&huaraches[i]!=null&&huaraches[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
             
                huaraches[i].setPrecio(precio);
                return true;
            }
        }
        
        
        
        return false;
    }
    
    public boolean modificarCantidad(String nombre, int cantidad)
    {
        for (int i = 0; i < 30; i++) {
            if (zapatillas[i]!=null&&zapatillas[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatillas[i].setCantidad(cantidad);
                
                return true;
            } else if(zapatoCerrado[i]!=null&&zapatoCerrado[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatoCerrado[i].setCantidad(cantidad);
                
                return true;
            } else if  (tenis[i]!=null&&tenis[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                tenis[i].setCantidad(cantidad);
                return true;
            } else if (huaraches[i]!=null&&huaraches[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
             
                huaraches[i].setCantidad(cantidad);
                return true;
            }
        } 
        
        
      
        return false;
        
    }
    
    public boolean eliminarArticulo(String nombre)
    {
        for (int i = 0; i < 30; i++) {
            if (zapatillas[i]!=null && zapatillas[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatillas[i]=null;
                
                return true;
            } else if(zapatoCerrado[i]!=null&&zapatoCerrado[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                zapatoCerrado[i]=null;
                
                return true;
            } else if  (tenis[i]!=null&&tenis[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
                
                tenis[i]=null;
                return true;
            } else if (huaraches[i]!=null&&huaraches[i].getNombre().toUpperCase().equals(nombre.toUpperCase())){
             
                huaraches[i]=null;
                return true;
            }
        }
        
        
      
        return false;
        
        
        
        
    }
    
    
    public void desplegarCantidades()
    {
       int totalZapatillas=0, totalZapatoCerrado=0, totalTenis=0, totalHuaraches=0, totalCantidades;
       
        for (int i = 0; i < 30; i++) {
            
            if (zapatillas[i]!=null) {
                
                totalZapatillas+=zapatillas[i].getCantidad();
                
            }
            if (zapatoCerrado[i]!=null){
                
                totalZapatoCerrado+=zapatoCerrado[i].getCantidad();
                
            }
            if(tenis[i]!=null){
                
                totalTenis+=tenis[i].getCantidad();
            }
            if(huaraches[i]!=null){
                
                totalHuaraches+=huaraches[i].getCantidad();
            }
            
            
            
        }
        
        totalCantidades=totalHuaraches+totalTenis+totalZapatoCerrado+totalZapatillas; 
        
        System.out.println("Pares por catalogo");
        System.out.println(" ");
        System.out.println("Zapatillas:       " +totalZapatillas);
        System.out.println("Zapatos Cerrado:  " + totalZapatoCerrado);
        System.out.println("Tenis:            "+totalTenis);
        System.out.println("Huaraches:        "+ totalHuaraches);
        System.out.println("                 ---------- ");
        System.out.println("Inventario total: "+ totalCantidades);
      
     
        
        
        
        
        
        
    }
    
    public void desplegarPrecios(){
    
        
        float totalZapatillas=0, totalZapatoCerrado=0, totalTenis=0, totalHuaraches=0, totalCantidades;
       
        for (int i = 0; i < 30; i++) {
            
            if (zapatillas[i]!=null) {
                
                totalZapatillas+=(zapatillas[i].getCantidad()  *  zapatillas[i].getPrecio());
                
            }
            if (zapatoCerrado[i]!=null){
                
                totalZapatoCerrado+=(zapatoCerrado[i].getCantidad() * zapatoCerrado[i].getPrecio());
                
            }
            if(tenis[i]!=null){
                
                totalTenis+=(tenis[i].getCantidad()*tenis[i].getPrecio());
            }
            if(huaraches[i]!=null){
                
                totalHuaraches+=(huaraches[i].getCantidad()*huaraches[i].getPrecio());
            }
            
            
            
        }
        
        totalCantidades=totalHuaraches+totalTenis+totalZapatoCerrado+totalZapatillas; 
        
        System.out.println("Costos por catalogo");
        System.out.println(" ");
        System.out.println("Zapatillas:                " +totalZapatillas);
        System.out.println("Zapatos Cerrado:           " + totalZapatoCerrado);
        System.out.println("Tenis:                     " +totalTenis);
        System.out.println("Huaraches:                 " + totalHuaraches);
        System.out.println("                          ---------- ");
        System.out.println("Costo total de Inventario: "+ totalCantidades);
    
    
    }
    
    
    
    

    public Zapato[] getZapatillas() {
        return zapatillas;
    }

    public void setZapatillas(Zapato[] zapatillas) {
        this.zapatillas = zapatillas;
    }

    public Zapato[] getZapatoCerrado() {
        return zapatoCerrado;
    }

    public void setZapatoCerrado(Zapato[] zapatoCerrado) {
        this.zapatoCerrado = zapatoCerrado;
    }

    public Zapato[] getTenis() {
        return tenis;
    }

    public void setTenis(Zapato[] tenis) {
        this.tenis = tenis;
    }

    public Zapato[] getHuaraches() {
        return huaraches;
    }

    public void setHuaraches(Zapato[] huaraches) {
        this.huaraches = huaraches;
    }

}
