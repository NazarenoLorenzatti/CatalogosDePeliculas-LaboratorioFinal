package com.nazareno.peliculas.datos;

import com.nazareno.peliculas.domain.Pelicula;
import java.util.*;
import com.nazareno.peliculas.excepciones.*;

/**
 *
 * @author Nazareno
 */
public interface AccesoDatos {

    public abstract void borrar(String nombreArchivo);
    
    public abstract void crear(String nombreArchivo) throws AccesoDatosEx ;

    public abstract String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx;

    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx;

    public abstract List<Pelicula> Listar(String nombre);

    public abstract boolean Existe(String nombreArchivo);

}
