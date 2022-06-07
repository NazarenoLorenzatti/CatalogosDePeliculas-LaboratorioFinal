package com.nazareno.peliculas.negocio;



import com.nazareno.peliculas.datos.*;
import com.nazareno.peliculas.domain.Pelicula;
import com.nazareno.peliculas.excepciones.*;
import java.util.Collection;

/**
 * Fecha: 7/6/2022
 * @author Nazareno Lorenzatti
 * @version 1.0
 */


// Clase que implementa los metodos que estaran en contacto directo con el usuario haciendo de nexo con los metodos tecnicos de la clase AccesoDatos
public class CatalogoPeliculasImpl extends AccesoDatosImpl implements CatalogoPeliculas {

    private static AccesoDatosImpl datos; 
 
    public CatalogoPeliculasImpl() {

        AccesoDatosImpl d1 = new AccesoDatosImpl(); // Instancio la clase AccesosDatosImpl para poder llamar a los metodos de esta. 
        this.datos = d1; // Guardo la referencia a la clase instanciada en un atributo para poder utilizarlo en cada metodo
    }

    //Agregar una nueva pelicula a un catalogo ya creado
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {

        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            this.datos.Listar(nombrePelicula);
            this.datos.escribir(pelicula, nombreArchivo, true);           
        } catch (EscrituraDeDatosEx ex) {
            System.out.println("Error de escritura de datos");
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
        }

    }
    
    //Listar pelicula sin agregar al catalogo
    @Override
    public void listarPelicula(String nombre) {

       this.datos.Listar(nombre);

    }
    
    // Buscar pelicula dentro de un catalogo
    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {

        try {
            this.datos.buscar(nombreArchivo, buscar);
        } catch (LecturasDeDatosEx ex) {
            System.out.println("Error de Lectura de datos");
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
        }

    }
    
    //Crear un nuevo catalogo
    @Override
    public void iniciarArchivo(String nombreArchivo) {

        try {
            this.datos.crear(nombreArchivo);
        } catch (EscrituraDeDatosEx ex) {
            System.out.println("Error de escritura de datos");
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
        }

    }
    
    // Imprimir la lista de peliculas anotadas indiferentemente del catalogo
    public void imprimirLista(Collection coleccion){
        for (Object elemento: coleccion){
            System.out.println("ELEMENTO: " + elemento);
        }
    }

}
