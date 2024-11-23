/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.hilos;

/**
 *
 * @author Napster
 */
/**
*Definimos la clase llamada Producto, 
*Los atributos del producto son un nombre y un costo. 
 */ 
public class Producto {
    String nombre;
    double costo;

/**
 * Creamos el constructor de la clase que permite crear una nueva instancia de Producto
 * y el cual asigna los valores proporcionados para el nombre y el costo a los atributos correspondientes
 */
    public Producto(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

}
