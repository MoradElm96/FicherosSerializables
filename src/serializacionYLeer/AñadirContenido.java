/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacionYLeer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Morad
 */
public class AñadirContenido extends ObjectOutputStream {
    //importante que herede de object outputstream
    //sobreescribimos el metodo que crea la cabecera
  
     AñadirContenido(FileOutputStream fos) throws IOException{
        super(fos);
    }

    @Override
    protected void writeStreamHeader() throws IOException {}  
    
}
