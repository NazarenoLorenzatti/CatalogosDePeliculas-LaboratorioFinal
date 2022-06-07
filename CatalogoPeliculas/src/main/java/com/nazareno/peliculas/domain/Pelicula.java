package com.nazareno.peliculas.domain;

/**
 *
 * @author Nazareno
 */
public class Pelicula {
    
    private String nombre;
    
    private Pelicula(){
        
    }
    
    public Pelicula (String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
    
}
