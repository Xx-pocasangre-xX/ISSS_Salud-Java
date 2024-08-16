package Controlador;

import Vista.jfrPantallaLogin;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

public class ctrlPantallaLogin {
    private jfrPantallaLogin Vista;
    private boolean passwordVisible = false;
    
    public ctrlPantallaLogin(jfrPantallaLogin Vista){
      this.Vista = Vista;
      initController();
    }
    
    private void initController(){
      Vista.btnVerContrasena.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
          togglePasswordVisibility();
        }
      });
    }
    
    private void togglePasswordVisibility(){
        
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
