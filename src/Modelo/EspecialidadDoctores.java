package Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public void cargarEspecialidadesMedicas2(JComboBox cbEspecialidadDoctor, JComboBox cbDoctor){
      ArrayList<String> especialidades = obtenerEspecialidades();
      cbEspecialidadDoctor.removeAllItems();
      
      cbDoctor.setEnabled(false);
      
      for(String especialidad : especialidades){
        cbEspecialidadDoctor.addItem(especialidad);
      }
      
      cbEspecialidadDoctor.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          if(cbEspecialidadDoctor.getSelectedIndex() != -1){
            String especialidadSeleccionada = cbEspecialidadDoctor.getSelectedItem().toString();
              cargarDoctoresPorEspecialidad(cbDoctor, especialidadSeleccionada);
              cbDoctor.setEnabled(true);
          }else{
             cbDoctor.setEnabled(false);
             cbDoctor.removeAllItems();
          }
        }
      });
    }
    
    public ArrayList<String> obtenerDoctoresPorEspecialidad(String especialidad){
    Connection conexion = ClaseConexion.getConexion();
    ArrayList<String> doctores = new ArrayList<>();
    String query = "SELECT nombre_doctor FROM Doctores WHERE id_especialidad = (SELECT id_especialidad FROM EspecialidadDoctores WHERE especialidad_doctor = ?)";
    
    try(PreparedStatement stmt = conexion.prepareStatement(query)){
        stmt.setString(1, especialidad);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            doctores.add(rs.getString("nombre_doctor"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    
    return doctores;
}
    
    public void cargarDoctoresPorEspecialidad(JComboBox cbDoctor, String especialidad){
    ArrayList<String> doctores = obtenerDoctoresPorEspecialidad(especialidad);
    cbDoctor.removeAllItems();
    
    for(String doctor : doctores){
        cbDoctor.addItem(doctor);
    }
}
}
