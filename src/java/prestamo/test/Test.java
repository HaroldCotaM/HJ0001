/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import prestamo.util.Conexion;


/**
 *
 * @author UPEU
 */
public class Test {
//static ClienteDAO aO1 = new ClienteDAO();
//static PrestamoDAO aO2 = new PrestamoDAO();
//static DetalleDAO dAO= new DetalleDAO();
//static List<Cliente> lista1 = new ArrayList<>();
//static List<Map<String, ?>> lista2 = new ArrayList<>();
//static List<Map<String, ?>> lista3 = new ArrayList<>();
//static List<Map<String, ?>> lista4 = new ArrayList<>();

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       conex();
        //saveP();
        //updateP();
        //listarP();
//        listarDA();
        //listarC();
        //max();
//        insertarDetalle();
        
    }
    public static void conex(){
        if(Conexion.getConexion()!=null){
            System.out.println("Si");
        }else{
            System.out.println("no");
        }
    }
//    public static void saveP(){
//     Prestamo p = new Prestamo(1, "12/02/2017", "16/02/2017");
//     if(aO2.create(p)==1){
//         System.out.println("si");
//     }else{
//         System.out.println("no");
//     }
//    }
//    public static void updateP(){
//     Prestamo p1 = new Prestamo();
//     p1.setIdprestamo(2);
//     p1.setIdcliente(1);
//     p1.setFecha1("20/03/2017");
//     p1.setFecha2("27/03/2017");
//     if(aO2.update(p1)==1){
//         System.out.println("si");
//     }else{
//         System.out.println("no");
//     }
//    }
//    public static void listarP(){
//    lista2 = aO2.readAll2();
//        System.out.println(lista2);
//    }
//    public static void listarD(){
//    lista3 = dAO.readAll2(41);
//    
//        System.out.println(lista3);
//        System.out.println(lista3.get(1).get("fecha2"));
//        System.out.println(lista3.toArray());
//
//    }
//    public static void listarC(){
//    lista1 = aO1.readAll();
//    for(int i=0;i<lista1.size();i++){
//        System.out.println(lista1.get(i).getNombres());
//    }
//    }
//    
//    public static void max(){
//     String x=aO2.generaID();
//     System.out.println(x);
//    }
//    
//    public static void insertarDetalle(){
//    DetallePrestamo d = new DetallePrestamo(41, 4);
//     if(dAO.create(d)==1){
//         System.out.println("si");
//     }else{
//         System.out.println("no");
//     }
//    
//    }
//    
//   public static void listarDA(){
//    lista4 = dAO.readAll3(21);
//    
//        System.out.println(lista4);
//
//
//    }
    
    
}
    

