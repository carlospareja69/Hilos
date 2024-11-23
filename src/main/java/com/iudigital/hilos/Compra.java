/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iudigital.hilos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Napster
 */
 /*
 * Definimos la clase compra con sus atributos cliente, productos y tiempoTotalCompra.
 * El numero entero largo (long) que representa el tiempo total de la compra
 */
public class Compra {
    String cliente;
    List<Producto> productos;
    long tiempoTotalCompra;

    
    /*Creamos el metodo constructor
    *inicializamos la lista de productos como una nueva instancia de ArrayList
    *y se establece el tiempo total de compra en 0
    */
    public Compra(String cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.tiempoTotalCompra = 0;
    }
// Creamos el método permite agregar un producto a la lista de productos de la compra
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}
