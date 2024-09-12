package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Usuarios {
    
    public int validarCredenciales(String correo, String contrasena){
       String query = "SELECT id_rol FROM Usuarios WHERE correo_electronico = ? AND contrasena = ?";
       try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, correo);
         pst.setString(2, contrasena);
         try(ResultSet rs = pst.executeQuery()){
           if(rs.next()){
              return rs.getInt("id_rol");
           }
         }
       }catch(SQLException e){
         e.printStackTrace();
       }
       return -1;
       }
    
    public boolean esDoctor(String correo, String contrasena){
      String query = "SELECT COUNT(*) FROM Doctores WHERE correo_doctor = ? AND contrasena_doctor = ?";
      
      System.out.println("Correo ingresado: " + correo);
      System.out.println("Contraseña encriptada ingresada: " + contrasena);
    
      try(Connection conexion = ClaseConexion.getConexion();
              PreparedStatement pst = conexion.prepareStatement(query)){
        pst.setString(1, correo);
        pst.setString(2, contrasena);
        try(ResultSet rs = pst.executeQuery()){
          if(rs.next()){
              System.out.println("Consulta SQL ejecutada, valor devuelto: " + rs.getInt(1));
            return rs.getInt(1) > 0;
          }
        }
      }catch(SQLException e){
           System.out.println("Error en la consulta SQL: " + e.getMessage());
        e.printStackTrace();
      }
      return false;
    }
    
    public String encryptPassword(String password){
      try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash){
          sb.append(String.format("%02x", b));
        }
        return sb.toString();
      }catch(NoSuchAlgorithmException ex){
        throw new RuntimeException("Error al encriptar la contrasena", ex);
      }
    }
    
    public boolean existeCorreo(String correo){
      String query = "SELECT COUNT(*) FROM Usuarios WHERE correo_electronico = ?";
      try(Connection conexion = ClaseConexion.getConexion();
              PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, correo);
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
    
    public boolean actualizarContrasena(String correo, String nuevaContrasenaEncriptada){
       String query = "UPDATE Usuarios SET contrasena = ? WHERE correo_electronico = ?";
       try(Connection conexion = ClaseConexion.getConexion();
               PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, nuevaContrasenaEncriptada);
         pst.setString(2, correo);
         int filasAfectadas = pst.executeUpdate();
         
         return filasAfectadas > 0;
       }catch(SQLException e){
         e.printStackTrace();
       }
       return false;
    }
}
