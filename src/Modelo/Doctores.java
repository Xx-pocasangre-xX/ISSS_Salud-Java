package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Doctores {
    private Connection conexion;
    
    public Doctores(Connection conexion){
      this.conexion = conexion;
    }
    
    public boolean agregarDoctor(String correo, String contrasena, String nombre, String foto, int idEspecialidad, int idUnidad){
       String query = "INSERT INTO Doctores(correo_doctor, contrasena_doctor, nombre_doctor, foto_doctor, id_especialidad, id_unidad) VALUES(?,?,?,?,?,?)";
       
       try(PreparedStatement ps = conexion.prepareStatement(query)){
          ps.setString(1, correo);
          ps.setString(2, encriptarContrasena(contrasena));
          ps.setString(3, nombre);
          ps.setString(4, foto);
          ps.setInt(5, idEspecialidad);
          ps.setInt(6, idUnidad);
          
          return ps.executeUpdate() > 0;
       }catch(SQLException e){
         e.printStackTrace();
         return false;
       }
    }
    
    private String encriptarContrasena(String contrasena){
      try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contrasena.getBytes());
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for(byte b: hash){
          String hex = Integer.toHexString(0xff & b);
          if(hex.length() == 1){
            hexString.append('0');
          }
          hexString.append(hex);
        }
        return hexString.toString();
      }catch(NoSuchAlgorithmException e){
        throw new RuntimeException(e);
      }
    }
}
