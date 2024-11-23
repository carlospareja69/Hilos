/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iudigital.hilos;

/**
 *
 * @author Napster
 */
import java.util.ArrayList;
import java.util.List;

/**
*Vamos a simular un escenario en un supermercado con dos cajeras y dos clientes realizando compras
 */
public class Hilos {
/*
    *Se crean dos instancias de la clase Compra (compra1 y compra2) 
    *cada una asociada a un cliente diferente.
    *Agregamos productos específicos utlizando la clase productos
    */
public static void main(String[] args) {
        Compra compra1 = new Compra("Cliente 1");
        compra1.agregarProducto(new Producto("Leche", 6500));
        compra1.agregarProducto(new Producto("Pan", 5000));

        Compra compra2 = new Compra("Cliente 2");
        compra2.agregarProducto(new Producto("Huevos", 18000));
        compra2.agregarProducto(new Producto("Cereal", 23000));
        
        Compra compra3 = new Compra("Cliente 3");
        compra3.agregarProducto(new Producto("Arepas", 3200));
        compra3.agregarProducto(new Producto("Salsa Rosada", 6000));
        
        // Creamos una lista de cajeras y se añaden dos instancias de la clase cajera
        List<Cajero> cajeros = new ArrayList<>();
        cajeros.add(new Cajero("Cajero 1"));
        cajeros.add(new Cajero("Cajero 2"));
        cajeros.add(new Cajero("Cajero 3"));

/*
Se itera sobre la lista de cajeros.
Para cada cajera, se crea un nuevo hilo (Thread) y se asigna a esa cajera una de las compras. 
Esto se hace en el bucle for donde se verifica el índice (i) 
para asignar la compra correspondiente a cada cajero.
Luego, se inicia el hilo y se espera a que termine utilizando thread.join(). 
Durante este proceso, cada cajera procesa los productos de la compra asignada.
*/
        for (int i = 0; i < cajeros.size(); i++) {
            Cajero cajero = cajeros.get(i);
            Thread thread = new Thread(cajero);
            cajero.asignarCompra(i == 0 ? compra1 : compra2); // Asignar la compra correspondiente a cada cajera
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

/*
*Después de que los hilos han terminado de ejecutarse
 se calcula el tiempo total de cobro sumando los tiempos de cobro individuales de cada cajera.
*Se utiliza la función mapToLong en la lista de cajeras para extraer 
 los tiempos totales de cobro de cada cajera y luego se suman con sum().
*Por ultimo se imprime el tiempo total de cobro para todas las compras en segundos.
*/
        long tiempoTotalCobro = cajeros.stream().mapToLong(c -> c.tiempoTotalCobro).sum();
        System.out.println("Tiempo total de cobro para todas las compras: " + tiempoTotalCobro/1000 + " segundos");
    }
}
