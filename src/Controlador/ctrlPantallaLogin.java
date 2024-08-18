package Controlador;

import Modelo.Usuarios;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdmin;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ctrlPantallaLogin{
    private jfrPantallaLogin Vista;
    private Usuarios modelo;
    private boolean passwordVisible = false;
    private boolean isLoginProcessed = false;
    
    public ctrlPantallaLogin(jfrPantallaLogin Vista, Usuarios modelo){
      this.Vista = Vista;
      this.modelo = modelo;
      
      this.Vista.btnIniciarSesion.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnIniciarSesion) {
            procesarLogin();
        }
        }
      });
      
      this.Vista.btnVerContrasena.addMouseListener(new MouseAdapter(){
      @Override
        public void mouseClicked(MouseEvent e){
          togglePasswordVisibility();
        }
      
      });
      
    }
 
    public void procesarLogin() {
        if (isLoginProcessed) {
            return; // Evitar procesamiento múltiple
        }

        try {
            String correo = Vista.txtEmail.getText();
            String contrasena = new String(Vista.txtContrasena.getPassword());

            Vista.btnIniciarSesion.setEnabled(false);

            if (modelo.verificarCredenciales(correo, contrasena)) {
                isLoginProcessed = true; // Marca el login como procesado
                JOptionPane.showMessageDialog(Vista, "¡Bienvenid@!");
                
                jfrPantallaMenuAdmin menuAdmin = new jfrPantallaMenuAdmin();
                menuAdmin.setLocationRelativeTo(null);
                menuAdmin.setVisible(true);
                Vista.dispose();
            } else {
                JOptionPane.showMessageDialog(Vista, "Credenciales incorrectas. Inténtelo de nuevo.");
                Vista.btnIniciarSesion.setEnabled(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Vista, "Ocurrió un error. Inténtelo de nuevo.");
            Vista.btnIniciarSesion.setEnabled(true);
        }
    }
    
    public void togglePasswordVisibility(){
        
        int width = Vista.btnVerContrasena.getWidth();
        int height = Vista.btnVerContrasena.getHeight();
        
      if(passwordVisible){
        Vista.txtContrasena.setEchoChar('•');
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/no_ver_password.png"));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Vista.btnVerContrasena.setIcon(new ImageIcon(getClass().getResource("/Imagenes/no_ver_password.png")));
        Vista.btnVerContrasena.setIcon(new ImageIcon(scaledImage));
      }else{
        Vista.txtContrasena.setEchoChar((char) 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/ver_password.png"));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Vista.btnVerContrasena.setIcon(new ImageIcon(scaledImage));
      }
      
      passwordVisible = !passwordVisible;
    }
}