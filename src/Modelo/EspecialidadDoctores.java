package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class EspecialidadDoctores {
    private Connection conexion; 
    
    public EspecialidadDoctores(Connection conexion){
       this.conexion = conexion;
    }
    
    public ArrayList<String> obtenerEspecialidades(){
       ArrayList<String> especialidades = new ArrayList<>();
       String query = "SELECT especialidad_doctor FROM EspecialidadDoctores";
       
       try(PreparedStatement stmt = conexion.prepareStatement(query);
               ResultSet rs = stmt.executeQuery()){
             while (rs.next()){
                especialidades.add(rs.getString("especialidad_doctor"));
             }
       }catch(Exception e){
          e.printStackTrace();
       }
       
       return especialidades;
    }
}
