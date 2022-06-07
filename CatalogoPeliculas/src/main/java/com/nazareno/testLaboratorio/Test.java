package com.nazareno.testLaboratorio;

import com.nazareno.peliculas.domain.Pelicula;
import com.nazareno.peliculas.negocio.*;
import java.util.*;

/**
 * Fecha: 7/6/20522
 * @author Nazareno Lorenzatti
 * @version 1.0
 */


// Implementacion que se encuentra en contacto con el usuario.
public class Test {

    public static void main(String[] args) {

        int respuesta;
        String nombre = null;
        String nombreCat = null;
        String directorio = "C:\\Users\\Nazareno\\Desktop\\Analista de sistemas\\";
        CatalogoPeliculasImpl catalogo = new CatalogoPeliculasImpl();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("<<<<<MENU>>>>>>");
            System.out.println("Elija una opcion:");
            System.out.println("1 - iniciar catalogo de peliculas");
            System.out.println("2 - Agregar pelicua");
            System.out.println("3 - Listar pelicula");
            System.out.println("4 - Buscar Pelicula");
            System.out.println("5 - Imprimir Lista de peliculas");
            System.out.println("0 - Salir");

            respuesta = sc.nextInt();

            while (respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4 && respuesta != 0 && respuesta != 5) {
                System.out.println("RESPUESTA INCORRECTA. Ingrese el numero correspondiente a la operacion que desea realizar.");
                System.out.println("<<<<<MENU>>>>>>");
                System.out.println("Elija una opcion:");
                System.out.println("1 - iniciar catalogo de peliculas");
                System.out.println("2 - Agregar pelicua");
                System.out.println("3 - Listar pelicula");
                System.out.println("4 - Buscar Pelicula");
                System.out.println("5 - Imprimir Lista de peliculas");
                System.out.println("0 - Salir");
                respuesta = sc.nextInt();
            }

            switch (respuesta) {
                case 1:
                    System.out.println("Iniciar Nuevo catalogo de peliculas");
                    System.out.println("Ingrese el nombre del nuevo catalogo: ");
                    nombreCat = sc.next();
                    catalogo.iniciarArchivo(directorio + nombreCat + ".txt");
                    break;
                case 2:
                    System.out.println("Agregar una nueva pelicula al catalogo");
                    System.out.println("Ingrese el nombre del catalogo");
                    nombreCat = sc.next();

                    if (catalogo.Existe(directorio + nombreCat + ".txt")) {
                        System.out.println("Ingrese el nombre de la pelicula a agregar");
                        nombre = sc.next();
                        catalogo.agregarPelicula(nombre, directorio + nombreCat + ".txt");
                    } else {
                        System.out.println("El catalogo al que hace referencia no esta creado.");
                    }

                    break;
                case 3:
                    System.out.println("Listar pelicula");
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombre = sc.next();
                    Pelicula pelicula = new Pelicula(nombre);
                    catalogo.listarPelicula(nombre);
                    break;
                case 4:
                    System.out.println("Buscar Pelicula");
                    System.out.println("Ingrese el nombre del catalogo donde desea buscar la pelicula");
                    nombreCat = sc.next();

                    if (catalogo.Existe(directorio + nombreCat + ".txt")) {
                        System.out.println("Ingrese el nombre de la pelicula que desea buscar");
                        nombre = sc.next();
                        catalogo.buscarPelicula(directorio + nombreCat + ".txt", nombre);
                    } else {
                        System.out.println("El catalogo al que hace referencia no esta creado.");
                    }
                    break;
                case 5:
                    System.out.println("Imprimir Lista de peliculas anotadas");
                    catalogo.imprimirLista(catalogo.getLista());
                    break;

            }

        } while (!(respuesta == 0));

        System.out.println("PROGRAMA FINALIZADO");

    }
}
