/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 * TRABAJO PRACTICO N°3
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 * MODULO PRODUCTOS PERSISTENCIA
 */
public class ProductosDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    // METODO REGISTRAR PRODUCTO
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO Producto (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    // METODO CONSULTAR PRODUCTO
    public void ConsultarProveedor(JComboBox Proveedor){
        String sql = "SELECT nombre FROM proveedor";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Proveedor.addItem(rs.getString("nombre"));
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    // METODO LISTAR PRODUCTO
    public List ListarProductos(){
        List<Productos> Listapro = new ArrayList();
        String sql = "SELECT * FROM producto";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Productos pr = new Productos();
                
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                
                pr.setNombre(rs.getString("nombre"));
                pr.setProveedor(rs.getString("proveedor"));
                
                pr.setStock(rs.getInt("stock"));
                pr.setPrecio(rs.getDouble("precio"));  
                
                Listapro.add(pr);
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return Listapro;   
    }
    
    // METODO ELIMINAR PRODUCTO
    public boolean EliminarProductos(int id){
        String sql = "DELETE FROM producto WHERE id = ?";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
            
            
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
    // METODO MODIFICAR PRODUCTO
    public boolean ModificarProductos(Productos pro){
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, proveedor = ?, stock = ?, precio = ? WHERE id = ?";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1,pro.getCodigo());
            ps.setString(2,pro.getNombre());
            ps.setString(3,pro.getProveedor());
            ps.setInt(4,pro.getStock());
            ps.setDouble(5,pro.getPrecio());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
            
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
    // METODO BUSCAR PRODUCTO POR CODIGO
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM producto WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock((int) rs.getDouble("stock"));
                
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto; 
        
        
    }
}
