package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class UnidadesMedicas {
    private Connection conexion;
    
    public UnidadesMedicas(Connection conexion){
      this.conexion = conexion;
    }
    
    public ArrayList<String> obtenerUnidadesMedicas(){
       ArrayList<String> unidadesMedicas = new ArrayList<>();
       String query = "SELECT nombre_unidad FROM UnidadesMedicas";
       
       try(PreparedStatement stmt = conexion.prepareStatement(query);
               ResultSet rs = stmt.executeQuery()){
             while (rs.next()){
                unidadesMedicas.add(rs.getString("nombre_unidad"));
             }
       }catch(Exception e){
          e.printStackTrace();
       }
       
       return unidadesMedicas;
    }
}
