package Modelo;

import java.sql.*;

public class ClaseConexion {
    private static final String URL = "jdbc:oracle:thin:@192.168.0.11:1521:xe";
    private static final String USUARIO = "PTC";
    private static final String CONTRASENA = "PTC";
    
    public static Connection getConexion() {
        try {
            // Cargar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Obtener la conexión en una variable
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            
            // Retornamos la variable que tiene la conexión
            return conexion;
        } catch (SQLException e) {
            System.out.println("Este es el error" + e);
              return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Este es el error de la clase" + ex);
              return null;
        }
      
    }
}
