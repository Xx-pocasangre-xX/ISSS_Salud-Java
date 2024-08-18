package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.*;

public class Usuarios {
    Connection conexion = ClaseConexion.getConexion();
    
    public Usuarios(Connection conexion){
      this.conexion = conexion;
    }
    
    public boolean verificarCredenciales(String correo, String contrasena) throws SQLException, NoSuchAlgorithmException{
        String query = "SELECT * FROM Usuarios WHERE correo_electronico = ? AND contrasena = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, correo);
        statement.setString(2, encriptarContrasena(contrasena));
        
        ResultSet resultado = statement.executeQuery();
        return resultado.next();
    }
    
    private String encriptarContrasena(String contrasena) throws NoSuchAlgorithmException{
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] hash = md.digest(contrasena.getBytes());
      StringBuilder hexString = new StringBuilder();
      for (byte b : hash){
        hexString.append(String.format("%02x", b));
      }
      return hexString.toString();
    }
}
