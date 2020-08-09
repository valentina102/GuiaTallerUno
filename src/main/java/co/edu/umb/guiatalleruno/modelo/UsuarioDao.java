/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.guiatalleruno.modelo;

import co.edu.umb.guiatalleruno.negocio.constantes.EMensajes;
import co.edu.umb.guiatalleruno.negocio.excepciones.GuiaUnoException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author User
 */
public class UsuarioDao {

    private final static String NOMBRE_ARCHIVO = "usuarios_guia_uno.txt";
    private final static String CARPETA_ARCHIVO = "guia_uno_demo";
    private final static String RUTA_ARCHIVO = System.getProperty("user.home")
            + File.separator + CARPETA_ARCHIVO + File.separator + NOMBRE_ARCHIVO;

    // /Users/dev_manuel/guia_uno_demo/usuarios_guia_uno.txt
    // C://Users/usuario/guia_uno_demo/usuarios_guia_uno.txt

    public void escribir(ArrayList<Usuario> listaUsuarios) throws GuiaUnoException {
        try {
            PrintStream escritor = new PrintStream(RUTA_ARCHIVO);
            String dataJson = new Gson().toJson(listaUsuarios);
            escritor.print(dataJson);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e) {
            throw new GuiaUnoException(EMensajes.ERROR_LOGIN);
        }
    }

    public ArrayList<Usuario> leer() throws GuiaUnoException{
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try{
            // escribir los objetos que representan el canal de lectura 3 objetos
            // noob
            /*FileInputStream fis = new FileInputStream(RUTA_ARCHIVO);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);*/

            // pro
            BufferedReader lector = new BufferedReader(
                    // Objeto Anonimo
                    new InputStreamReader(
                            new FileInputStream(RUTA_ARCHIVO)
                    )
            );
            // Recibir el texto del archivo plano como String
            StringBuilder contenido = new StringBuilder();
            // mientras el lector, tenga lineas por leer
            while (lector.ready()){
                contenido.append(lector.readLine());
            }
            // si ya no hay mas lineas por leer!
            // ByteCode
            Type tipoDato = new TypeToken<ArrayList<Usuario>>(){}.getType();
            // Proceso de Deserialización!
            listaUsuarios = new Gson().fromJson(contenido.toString(), tipoDato);
        } catch(IOException e){
            throw new GuiaUnoException(EMensajes.ERROR_LOGIN);
        }
        return listaUsuarios;
    }

}
