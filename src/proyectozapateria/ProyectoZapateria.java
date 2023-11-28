/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozapateria;

import controlador.usuario;
import java.util.List;
import java.util.Scanner;
import modelo.conexion.baseDatos;
import modelo.usuarioDAO;

/**
 *
 * @author carlo
 */
public class ProyectoZapateria {

    
    public static void main(String[] args) {
        
        
        /*Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador();

        int respMenu, respSw;

        do {

            System.out.println("******************************************************************");
            System.out.println("**            ZAPATERIA PIRATITAS SA de CV                      **");
            System.out.println("******************************************************************");
            System.out.println("**                    MENU PRINCIPAL                            **");
            System.out.println("**                                                              **");
            System.out.println("** 1. ALTA EN CATALOGO DE ARTICULOS                             **"); 
            System.out.println("** 2. ACTUALIZACION DE EXISTENCIA                               **");
            System.out.println("** 3. ACTUALIZANCION  DE PRECIO                                 **");
            System.out.println("** 4. BAJA A ARTICULO                                           **");
            System.out.println("** 5. CONSULTA TOTAL DE ARTICULOS POR CATALOGO                  **");
            System.out.println("** 6. CONSULTA TOTAL COSTE DE INVENTARIO POR ARTICULO           **");
            System.out.println("** 7. TERMINAR                                                  **");
            System.out.println("**                                                              **");
            
            
            respMenu = sc.nextInt();
            sc.nextLine();

            String nombre;
            int existencia;
            float precio;

            switch (respMenu) {

                case 1:

                    System.out.println("¿En que catalogo desea dar de alta el producto?");
                    System.out.println("1. Zapatillas");
                    System.out.println("2. Zapato cerrado");
                    System.out.println("3. Tenis");
                    System.out.println("4. Huaraches");
                    respSw = sc.nextInt();
                    sc.nextLine();

                    switch (respSw) {
                        case 1:
                            System.out.println("Ingrese el nombre del Articulo");
                            nombre = sc.nextLine();

                            System.out.println("Ingrese el precio de articulo");
                            precio = sc.nextFloat();
                            System.out.println("Cuantos hay en existencia");
                            existencia = sc.nextInt();
                            
                            if (admin.agregarZapato(nombre, precio, existencia, "Zapatillas")==true) {
                                
                                System.out.println("Zapato agregado correctamente");
                            } else {
                                System.out.println("Catalogo lleno");
                            }
                            
                            sc.nextLine();

                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del Articulo");
                            nombre = sc.nextLine();

                            System.out.println("Ingrese el precio de articulo");
                            precio = sc.nextFloat();
                            System.out.println("Cuantos hay en existencia");
                            existencia = sc.nextInt();
                            
                            if (admin.agregarZapato(nombre, precio, existencia, "ZapatoCerrado")==true)
                           {
                                System.out.println("Zapato agregado correctamente");
                            } else {
                                System.out.println("Catalogo lleno");
                            }
                            sc.nextLine();
                            break;

                        case 3:
                            System.out.println("Ingrese el nombre del Articulo");
                            nombre = sc.nextLine();

                            System.out.println("Ingrese el precio de articulo");
                            precio = sc.nextFloat();
                            System.out.println("Cuantos hay en existencia");
                            existencia = sc.nextInt();

                            if (admin.agregarZapato(nombre, precio, existencia, "Tenis")==true) {
                                System.out.println("Zapato agregado correctamente");
                            }else{
                                System.out.println("Catalogo lleno");
                            }
                            sc.nextLine();
                            break;
                        case 4:
                            System.out.println("Ingrese el nombre del Articulo");
                            nombre = sc.nextLine();

                            System.out.println("Ingrese el precio de articulo");
                            precio = sc.nextFloat();
                            System.out.println("Cuantos hay en existencia");
                            existencia = sc.nextInt();

                            if (admin.agregarZapato(nombre, precio, existencia, "Huaraches")==true) {
                                System.out.println("Zapato agregado correctamente");
                            } else {
                                System.out.println("Catalogo lleno");
                            }
                            sc.nextLine();
                            break;
                        default:
                            System.out.println("Opcion incorrecta, intente de nuevo");
                            break;
                    }

                    break;
                case 2:
                    String nom;
                    int cant;
                    
                    System.out.println("Ingrese el nombre del articulo");
                    nom = sc.nextLine();
                    System.out.println("Ingrese el total actual");
                    cant = sc.nextInt();

                    if (admin.modificarCantidad(nom, cant)==true) {

                        System.out.println("Cantidad modificada");

                    }

                    break;
                case 3:
                    
                    System.out.println("Ingrese el nombre del articulo");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el nuevo precio");
                    float precioModificar= sc.nextFloat();
                    
                     if (admin.modificarPrecio(nom, precioModificar)==true){
                         System.out.println("Precio modificado");
                         
                     }
                    
                    break;
                case 4:
                    
                    System.out.println("Ingrese el nombre del articulo");
                    nom=sc.nextLine();
                    if(admin.eliminarArticulo(nom)== true){
                        System.out.println("Articulo eliminado del catalogo");
                    }
                    break;
                case 5:
                    
                    admin.desplegarCantidades();
                    break;
                case 6:
                    admin.desplegarPrecios();
                    break;
                case 7:
                    System.out.println("Sistema terminado.");

                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
                    break;
            }

        } while (respMenu!=7);*/
        
        //baseDatos conexion = new baseDatos();
        
        usuarioDAO daousuario = new usuarioDAO();
        
        
        usuario u = new usuario();
        
        u.setNombre("paulina");
        u.setDireccion("san geronimo");
        u.setCorreo("pau@correo.com");
        u.setTelefono("6221555807");
        u.setRol("administrador");
        u.setPass("1234");
        
        int num_control = daousuario.agregar(u);
        
        if(num_control > 0){
            u.setId(num_control);
            System.out.println("Usuario agregado");
            
        }else{
            System.out.println("no se puede agregar usuario");
        }
        
        List<usuario> usuarios = daousuario.obtener();
        
        for(usuario a: usuarios){
            System.out.println(a.toString());
        }
    }
}
