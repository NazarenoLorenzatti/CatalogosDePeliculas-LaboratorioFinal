package com.nazareno.peliculas.datos;

import com.nazareno.peliculas.domain.Pelicula;
import com.nazareno.peliculas.excepciones.*;
import java.io.*;
import java.util.*;

/**
 * Fecha:7/6/2022
 *  
 * @author Nazareno Lorenzatti
 * @version 1.0
 */

//Implementacion de la interface de acceso a datos.

public class AccesoDatosImpl implements AccesoDatos {
    
    private static List<Pelicula> lista;

    public AccesoDatosImpl() {
        this.lista = new ArrayList(); // List es una interface y como no se pueden instanciar objetos de interface hay que crear una instancia de una clase que la implemente en este caso ArrayList
    }

    // Borrar un catalogo
    
    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
    }
    
    // crear un nuevo archivo Catalogo
    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDeDatosEx("Error en la creacion de archivo");

        }

    }

    // buscar en un catalogo ya creado una pelicula listada dentro del catalogo
    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx {

        String retorno = null;
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {

                if (buscar.equals(lectura)) {
                    retorno = lectura;
                    System.out.println("La pelicula: " + buscar + " se encuenta dentro del catalogo " + nombreArchivo);
                    break;
                } else if (lectura == null) {
                    System.out.println("La pelicula que esta buscando no se encuentra listada");
                }
                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturasDeDatosEx("Error en la Lectura de archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturasDeDatosEx("Error en la Lectura de archivo");
        }
        return retorno;
    }
    
    // listar una nueva pelicula en un catalogo especifico

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.println();
            salida.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDeDatosEx("Error en la creacion de archivo");
        }

    }

    // Listar en una coleccion dinamica todas las peliculas independientemente del catalogo

    @Override
    public List<Pelicula> Listar(String nombre) {
            
        lista.add(new Pelicula(nombre));        
        return lista;
    }

    // comprobar si un catalogo esta creado
    
    @Override
    public boolean Existe(String nombreArchivo) {

        boolean retorno;
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }
    
    //metodo get para obtener el ateributo lista
        public static List<Pelicula> getLista() {
        return lista;
    }

}
