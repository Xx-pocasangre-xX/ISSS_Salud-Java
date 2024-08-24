package Controlador;

import Modelo.EspecialidadDoctores;
import Modelo.UnidadesMedicas;
import Vista.jfrPantallaMenuAdmin;
import java.util.ArrayList;

public class ctrlPantallaMenuAdmin {
    private jfrPantallaMenuAdmin vista;
    private EspecialidadDoctores modelo;
    private UnidadesMedicas modelo2;
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, EspecialidadDoctores modelo){
       this.vista = vista;
       this.modelo = modelo;
       cargarEspecialidadesMedicas();
    }
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, UnidadesMedicas modelo2){
      this.vista = vista;
      this.modelo2 = modelo2;
      cargarUnidadesMedicas();
    }
    
    private void cargarEspecialidadesMedicas(){
      ArrayList<String> especialidades = modelo.obtenerEspecialidades();
      vista.cbEspecialidadesMedicas.removeAllItems();
      for(String especialidad : especialidades){
        vista.cbEspecialidadesMedicas.addItem(especialidad);
      }
    }
    
    private void cargarUnidadesMedicas(){
       ArrayList<String> unidades = modelo2.obtenerUnidadesMedicas();
       vista.cbUnidadesMedicas.removeAllItems();
       for(String unidad : unidades){
         vista.cbUnidadesMedicas.addItem(unidad);
       }
    }
}
