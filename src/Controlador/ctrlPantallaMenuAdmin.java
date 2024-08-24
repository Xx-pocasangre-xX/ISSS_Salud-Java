package Controlador;

import Modelo.EspecialidadDoctores;
import Vista.jfrPantallaMenuAdmin;
import java.util.ArrayList;

public class ctrlPantallaMenuAdmin {
    private jfrPantallaMenuAdmin vista;
    private EspecialidadDoctores modelo;
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, EspecialidadDoctores modelo){
       this.vista = vista;
       this.modelo = modelo;
       cargarEspecialidadesMedicas();
    }
    
    private void cargarEspecialidadesMedicas(){
      ArrayList<String> especialidades = modelo.obtenerEspecialidades();
      vista.cbEspecialidadesMedicas.removeAllItems();
      for(String especialidad : especialidades){
        vista.cbEspecialidadesMedicas.addItem(especialidad);
      }
    }
}
