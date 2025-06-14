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
import javax.swing.JOptionPane;

/**
 * TRABAJO PRACTICO N°3
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 * MODULO PROVEEDOR PERSISTENCIA
 */
public class ProveedorDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    // METODO REGISTRAR PROVEEDOR
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor (ruc, nombre, telefono, direccion,razonSocial) VALUES(?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, pr.getRuc());
            ps.setString(2,pr.getNombre());
            ps.setString(3,pr.getTelefono());
            ps.setString(4,pr.getDireccion());
            ps.setString(5,pr.getRazon());
            ps.execute(); 
            JOptionPane.showMessageDialog(null,"Proveedor Registrado Exitosamente!!");
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
            
        }finally{
        try{
            con.close();
            
        }catch(SQLException e){
            System.out.println(e.toString());
        } 
      }   
    }
 
    // METODO LISTAR PROVEEDOR
    public List ListarProveedor(){
        List<Proveedor> Listapr = new ArrayList();
        String sql = "SELECT * FROM proveedor";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Proveedor pr = new Proveedor();
                
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getInt("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon(rs.getString("razonSocial"));
                Listapr.add(pr);
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return Listapr;   
    }
    
    
    // METODO ELIMINAR PROVEEDOR
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedor WHERE id = ?";
        
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
    
    // METODO MODIICAR PROVEEDOR
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedor SET ruc = ?, nombre = ?, telefono = ?, direccion = ?, razonSocial = ? WHERE id = ?";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1,pr.getRuc());
            ps.setString(2,pr.getNombre());
            ps.setString(3,pr.getTelefono());
            ps.setString(4,pr.getDireccion());
            ps.setString(5,pr.getRazon());
            ps.setInt(6, pr.getId());
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
    
}
