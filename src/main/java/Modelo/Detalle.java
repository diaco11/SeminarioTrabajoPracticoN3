/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * TRABAJO PRACTICO N°3
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 * MODULO DETALLE VENTA
 */
public class Detalle {
    
    private int id;
    private String cod_prod;
    private int cantidad;
    private double precio;
    private int id_venta;
    
    
    // CONSTRUCTORES
    public Detalle(){
        
    }

    public Detalle(int id, String cod_prod, int cantidad, double precio, int id_venta) {
        this.id = id;
        this.cod_prod = cod_prod;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }

    
    // METODOS GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    
    
    
}
