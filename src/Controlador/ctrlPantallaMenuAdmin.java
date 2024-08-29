package Controlador;

import Modelo.Doctores;
import Modelo.EspecialidadDoctores;
import Modelo.UnidadesMedicas;
import Vista.jfrPantallaMenuAdmin;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ctrlPantallaMenuAdmin {
    private jfrPantallaMenuAdmin vista;
    private EspecialidadDoctores modelo;
    private UnidadesMedicas modelo2;
    private Doctores modelo3;
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, EspecialidadDoctores modelo){
       this.vista = vista;
       this.modelo = modelo;
       this.modelo.cargarEspecialidadesMedicas(vista.cbEspecialidadesMedicas);
    }
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, UnidadesMedicas modelo2){
      this.vista = vista;
      this.modelo2 = modelo2;
      this.modelo2.cargarUnidadesMedicas(vista.cbUnidadesMedicas);
    }
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, Doctores modelo3){
      this.vista = vista;
      this.modelo3 = modelo3;
      this.modelo3.cargarCardsDoctores(vista.jpCardsDoctores);
      
      this.vista.btnCargarImagen.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          modelo3.cargarImagen(vista.profileImage, vista);
        }
      });
      
      this.vista.btnAgregar.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
           modelo3.agregarDoctor(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.profileImage, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas, vista);
         }
      });
    }
}