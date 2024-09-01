package Controlador;

import Modelo.CorreoUsuario;
import Modelo.Usuarios;
import Vista.jfrCambioContra;
import Vista.jfrPantallaRecuperacionExitosa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPantallaCambioContra implements ActionListener{
    private Usuarios modelo;
    private jfrCambioContra vista;
    
    public ctrlPantallaCambioContra(Usuarios modelo, jfrCambioContra vista){
      this.modelo = modelo;
      this.vista = vista;
      this.vista.btnActualizarContrasena.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnActualizarContrasena){
          String nuevaContrasena = vista.txtContrasenaNueva.getText();
          String repetirContrasena = vista.txtRepetirContrasenaNueva.getText();
          
          if(nuevaContrasena.isEmpty() || repetirContrasena.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Los campos de contraseña no pueden estar vacíos");
          }else if(nuevaContrasena.length() < 8 || !nuevaContrasena.matches(".*[!@#$%^&*(),.?\":{}|<>].*") || !nuevaContrasena.matches(".*\\d.*")){
            JOptionPane.showMessageDialog(vista, "La contraseña debe contener mínimo 8 caracteres, un carácter especial y números");
          }else if(!nuevaContrasena.equals(repetirContrasena)){
            JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden. Intente de nuevo.");
          }else{
            String nuevaContrasenaEncriptada = modelo.encryptPassword(nuevaContrasena);
            String correoUsuario = CorreoUsuario.getCorreo();
            System.out.println("Correo: " + correoUsuario);  // Verificar el correo
            System.out.println("Nueva Contraseña Encriptada: " + nuevaContrasenaEncriptada);  // Verificar la contraseña encriptada
            boolean exito = modelo.actualizarContrasena(correoUsuario, nuevaContrasenaEncriptada);
            
            if(exito){
              JOptionPane.showMessageDialog(vista, "Contrasena actualizada exitosamente.");
              jfrPantallaRecuperacionExitosa pantallaExito = new jfrPantallaRecuperacionExitosa();
              pantallaExito.setVisible(true);
              pantallaExito.setLocationRelativeTo(null);
              vista.dispose();
            }else{
              JOptionPane.showMessageDialog(vista, "Hubo un error al actualizar la contrasena. Intente de nuevo.");
            }
          }
        }
    }
}
