/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 * TRABAJO PRACTICO N°1
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() {
        Connection con;
        try{
            String myBD = "jdbc:mysql://localhost:3306/sistemaventa?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD,"root","-----");
            return con;
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
}

