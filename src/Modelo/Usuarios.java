package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
<<<<<<< HEAD
    private String Correo;
    private String Contrasena;
    private int codigoRecuperacion;

    // Métodos getters y setters
    public int getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(int codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }
    
     public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
=======
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
>>>>>>> master
    }
    }
