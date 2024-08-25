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
       cargarEspecialidadesMedicas();
    }
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, UnidadesMedicas modelo2){
      this.vista = vista;
      this.modelo2 = modelo2;
      cargarUnidadesMedicas();
    }
    
    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdmin vista, Doctores modelo3){
      this.vista = vista;
      this.modelo3 = modelo3;
      
      this.vista.btnCargarImagen.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          cargarImagen();
        }
      });
      
      this.vista.btnAgregar.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
           agregarDoctor();
         }
      });
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
    
    private void cargarImagen(){
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(vista);
      if(result == JFileChooser.APPROVE_OPTION){
        File selectedFile = fileChooser.getSelectedFile();
        
        ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
        
        int width = vista.profileImage.getWidth();
        int height = vista.profileImage.getHeight();
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        vista.profileImage.setIcon(new ImageIcon(scaledImage));
        vista.profileImage.setText(selectedFile.getAbsolutePath());
      }
    }
    
    private void agregarDoctor(){
      String correo = vista.txtCorreoDoctor.getText();
      String contrasena = new String(vista.txtContrasenaDoctor.getPassword());
      String nombre = vista.txtNombreDoctor.getText();
      String foto = vista.profileImage.getText();
      int idEspecialidad = vista.cbEspecialidadesMedicas.getSelectedIndex() + 1;
      int idUnidad = vista.cbUnidadesMedicas.getSelectedIndex() + 1;
      
      if(modelo3.agregarDoctor(correo, contrasena, nombre, foto, idEspecialidad, idUnidad)){
        JOptionPane.showMessageDialog(vista, "Doctor agregado exitosamente.");
        limpiarCampos();
      }else{
        JOptionPane.showMessageDialog(vista, "Error al agregar el doctor");
      }
    }
    
    private void limpiarCampos() {
        vista.txtCorreoDoctor.setText("");
        vista.txtContrasenaDoctor.setText("");
        vista.txtNombreDoctor.setText("");
        vista.cbEspecialidadesMedicas.setSelectedIndex(0);
        vista.cbUnidadesMedicas.setSelectedIndex(0);
    }
}
