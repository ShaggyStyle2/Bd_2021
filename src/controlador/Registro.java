/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.util.Date;
import modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author zicko
 */
public class Registro {
    
   public boolean agregar (Libro libro){
       
       Date date;
       try {
           
           Conexion con = new Conexion();
           Connection cnx = con.obtenerConexion();
           
           date = libro.getPublicacion();
           String query = "INSERT INTO LIBRO(titulo,autor,publicacion,precio,disponble) VALUES (?,?,?,?,?)";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1, libro.getTitulo());
           stmt.setString(2, libro.getAutor());
           stmt.setDate(3, new java.sql.Date(date.getTime()));
           stmt.setInt(4, libro.getPrecio());
           stmt.setBoolean(5, libro.isDisponible());
           
           stmt.executeUpdate();
           stmt.close();
           cnx.close();
           return true;
       
       
       } catch (SQLException e) {
           
           System.out.println("Error sql al agregar Libro");
           return false;
       }catch (Exception e){
           System.out.println("Error al agregar libro");
           return false;
       }
       
       
       
   }
    
}
