/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Morad
 */
public class Serializar  {
    //serializar  es transformar los atributos de un objeto a datos para un fichero binario
    // de la forma inversa,leer datos del fichero y deserializar
   static File f = new File("empleados.dat");
    
    public static void escribirObjeto(){
         //escribir en un fichero
        
        Empleado empleado1 = new Empleado("Morad","El mourabit",25, 20.0);
        Empleado empleado2 = new Empleado("Tupac","Shakur",25, 6000);
        
        
        try{
            
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
           
            oos.writeObject(empleado1);
            oos.writeObject(empleado2);
            
            System.out.println("objeto añadido con exito");
            
            oos.close();
              
        }catch(IOException e) {
        
                System.out.println(e.getMessage());
        
        }
        
    }
    
    
    public static void leerObjeto(){
    
        try{
            //if file exist
            FileInputStream  fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while(true){
            Empleado auxiliar = (Empleado)ois.readObject();//castear forzosamente 
            
            System.out.println(auxiliar.getNombre());
            System.out.println(auxiliar.getApellido());
            System.out.println(auxiliar.getEdad());
            System.out.println(auxiliar.getSalario());

            System.out.println("\n");

             
                
               // System.out.println(auxiliar.toString());
        }
          
            
        }
       
        catch(ClassNotFoundException e){}
        catch(EOFException e){}//para salir cuando no hay nada
        
        catch(IOException e){}
        
    
    }
    
    
    public static void anadirBinario() {
        
        Empleado empleado3 = new Empleado("50cent","Curtis",28, 60000);
        
        Empleado empleado4 = new Empleado("5cet","Cts",2, 6000);
        
        try{
            
            
            
            FileOutputStream fos = new FileOutputStream(f,true);//importante poner el true
            
            AñadirContenido anadir = new AñadirContenido(fos);
            
           
           
            anadir.writeObject(empleado3);
            anadir.writeObject(empleado4);
            System.out.println("Añadido con exito");
            anadir.close();
            fos.close();
            
         
              
        }catch(IOException e) {
        
                System.out.println(e.getMessage());
        
        }
        
        
    }
    
    
    public static void main(String[] args) {
        
       escribirObjeto();
      
       
       anadirBinario();
       
       leerObjeto();
       //cabeceras
       //cada vez que se crea un objet se crea una cabecera
       //solucion crear otra clase para meeter los datos añadidos
        
    }
}
