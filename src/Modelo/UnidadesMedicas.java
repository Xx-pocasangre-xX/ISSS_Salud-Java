package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class UnidadesMedicas {
    
    public ArrayList<String> obtenerUnidadesMedicas(){
       Connection conexion = ClaseConexion.getConexion();
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
    
    public void cargarUnidadesMedicas(JComboBox cbUnidadesMedicas){
       ArrayList<String> unidades = obtenerUnidadesMedicas();
       cbUnidadesMedicas.removeAllItems();
       for(String unidad : unidades){
         cbUnidadesMedicas.addItem(unidad);
       }
    }
}
