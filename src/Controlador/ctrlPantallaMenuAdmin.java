package Controlador;

import Modelo.Doctores;
import Modelo.EspecialidadDoctores;
import Modelo.UnidadesMedicas;
import Vista.jfrPantallaMenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
      this.modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
      
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
           modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
         }
      });
      
      this.vista.btnActualizar.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              int idDoctor = modelo3.getIdDoctorActual();
              String correo = vista.txtCorreoDoctor.getText();
              String nombre = vista.txtNombreDoctor.getText();
              int idEspecialidad = vista.cbEspecialidadesMedicas.getSelectedIndex() + 1;
              int idUnidad = vista.cbUnidadesMedicas.getSelectedIndex() + 1;
              
              if(modelo3.actualizarDoctor(idDoctor, correo, nombre, idEspecialidad, idUnidad)){
                JOptionPane.showMessageDialog(vista, "Actualización exitosa.");
                modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas);
                modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
              }else{
                JOptionPane.showMessageDialog(vista, "Error al actualizar el doctor.");
              }
          }
      });
      
      this.vista.btnLimpiar.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
             modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas);
          }
      
      });
      
      this.vista.btnEliminar.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              int idDoctor = modelo3.getIdDoctorActual();
              
              int confirmar = JOptionPane.showConfirmDialog(vista, "Estas seguro de que deseas aliminar a este doctor", "Confirmación", JOptionPane.YES_NO_OPTION);
              if(confirmar == JOptionPane.YES_OPTION){
                if(modelo3.eliminarDoctor(idDoctor)){
                  JOptionPane.showMessageDialog(vista, "Doctor elimando exitosamente.");
                  modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
                  modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas);
                  vista.profileImage.setIcon(null);
                }else{
                  JOptionPane.showMessageDialog(vista, "Error al eiminar el doctor");
                }
              }
          }
      
      });
    }
}