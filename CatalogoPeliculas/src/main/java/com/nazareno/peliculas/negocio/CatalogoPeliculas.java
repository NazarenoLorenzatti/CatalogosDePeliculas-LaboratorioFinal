package com.nazareno.peliculas.negocio;

/**
 *
 * @author Nazareno
 */
public interface CatalogoPeliculas {
    
    public abstract void agregarPelicula (String nombrePelicula, String nombreArchivo);
    
    public abstract void listarPelicula (String nombreArchivo);
    
    public abstract void buscarPelicula (String nombreArchivo, String buscar);
    
    public abstract void iniciarArchivo (String nombreArchivo);
    
    
}
