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
 * MODULO VENTA
 */

public class Venta {
    private int id;
    private String cliente;
    private String vendedor;
    private double total;
    
    // CONSTRUCTORES
    public Venta(){
        
    }

    public Venta(int id, String cliente, String vendedor, double total) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    //METODOS GETTERS Y SETTERS 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
