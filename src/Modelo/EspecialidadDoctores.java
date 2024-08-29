package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class EspecialidadDoctores {
    
    public ArrayList<String> obtenerEspecialidades(){
       Connection conexion = ClaseConexion.getConexion();
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
    
    public void cargarEspecialidadesMedicas(JComboBox cbEspecialidadesMedicas){
      ArrayList<String> especialidades = obtenerEspecialidades();
      cbEspecialidadesMedicas.removeAllItems();
      for(String especialidad : especialidades){
        cbEspecialidadesMedicas.addItem(especialidad);
      }
    }
}
