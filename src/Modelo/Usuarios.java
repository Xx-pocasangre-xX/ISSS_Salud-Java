package Modelo;

import java.sql.*;

public class Usuarios {
    
    public boolean validarCredenciales(String correo, String contrasena){
       String query = "SELECT COUNT(*) FROM Usuarios WHERE correo_electronico = ? AND contrasena = ?";
       try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, correo);
         pst.setString(2, contrasena);
         try(ResultSet rs = pst.executeQuery()){
           if(rs.next()){
              return rs.getInt(1) > 0;
           }
         }
       }catch(SQLException e){
         e.printStackTrace();
       }
       return false;
       }
    }
