/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.hilos;
import java.util.Random;

/**
 *
 * @author Napster
 */
public class Cajero implements Runnable{
         String nombre;
    Compra compra;
    long tiempoTotalCobro;
/*
    *Se crea el constructor de la clase para crear una nueva instancia de Cajera
    *Se inicializa el tiempo total de cobro en 0.
    */
    public Cajero(String nombre) {
        this.nombre = nombre;
        this.tiempoTotalCobro = 0;
    }
/*
    *Creamos el método asignarCompra que se utiliza para asignar una instancia de Compra a la cajera. 
    *La palabra clave synchronized indica que este método es seguro 
     para ser llamado por varios hilos simultáneamente
    */
    public synchronized void asignarCompra(Compra compra) {
        this.compra = compra;
    }
/*
    *Creamos el método procesarProducto
    *El cual simula el proceso de cobro de un producto. 
    *Tambien Imprime información sobre el producto y 
     simula un tiempo de procesamiento aleatorio entre 1 y 4 segundos
     */
    private void procesarProducto(Producto producto) throws InterruptedException {
        System.out.println("Procesando producto: " + producto.nombre + ", Costo: $" + producto.costo);
        long tiempoProducto = new Random().nextInt(3000) + 1000; // entre 1 y 4 segundos
        Thread.sleep(tiempoProducto);
        tiempoTotalCobro += tiempoProducto;
    }

    /*
    *Creamos el método procesarCompra que simula el proceso de cobro de todos los productos en la compra. 
    *Itera sobre la lista de productos en la compra, llamando al método procesarProducto.
    *Acumula el costo total de la compra y el tiempo total de cobro.
    */
    public void procesarCompra() {
        System.out.println("Cajero " + nombre + " está procesando la compra de " + compra.cliente);

        double costoTotalCompra = 0; // Variable para almacenar el costo total de la compra

        for (Producto producto : compra.productos) {
            try {
                procesarProducto(producto);
                costoTotalCompra += producto.costo; // Sumar el costo de cada producto al total
                compra.tiempoTotalCompra += tiempoTotalCobro; // Se acumula el tiempo por producto
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        System.out.println("Cajero " + nombre + " ha terminado de procesar la compra de " + compra.cliente);
        System.out.println("Costo total de la compra para " + compra.cliente + ": $" + costoTotalCompra);
        System.out.println("Tiempo total de compra para " + compra.cliente + ": " + compra.tiempoTotalCompra/1000 + " segundos");
        System.out.println("---------------------------------------------------------------------");
    }

    /*
    *El método run es parte de la interfaz Runnable y se ejecuta cuando se inicia un nuevo hilo.
    *Llama al método procesarCompra representando el trabajo que realiza la cajera al procesar una compra.
    */
    
    @Override
    public void run() {
        procesarCompra();
    }
}


