/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TRABAJO PRACTICO N°3
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 * MODULO VENTA PERSISTENCIA
 */

public class VentaDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    // Metodo recuperar el ID
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM VENTA";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
           
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    // METODO REGISTRAR VENTA
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO venta (cliente, vendedor, total) VALUES(?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2,v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    
    // METODO REGISTRAR DETALLE DE VENTA
    public int RegistrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalle(cod_prod, cantidad, precio, id_venta) VALUES(?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, Dv.getCod_prod());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    // METODO ACTUALIZACION DE STOCK AL REALIZARCE UNA NUEVA VENTA
    public boolean ActualizarStock(int cant, String cod){
        String sql = "UPDATE producto SET stock = ? WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return false;
        
    }
}
