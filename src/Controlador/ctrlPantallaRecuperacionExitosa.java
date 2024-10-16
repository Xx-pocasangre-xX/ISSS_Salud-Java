package Controlador;

import Modelo.Usuarios;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaRecuperacionExitosa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlPantallaRecuperacionExitosa implements ActionListener{
    
    private jfrPantallaRecuperacionExitosa vista;
    Usuarios modelo;
    
    public ctrlPantallaRecuperacionExitosa(jfrPantallaRecuperacionExitosa vista, Usuarios modelo){
      this.vista = vista;
      this.modelo = modelo;
      vista.btnVolverLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnVolverLogin){
          jfrPantallaLogin pantallaLogin = new jfrPantallaLogin();
          pantallaLogin.setLocationRelativeTo(null);
          pantallaLogin.setVisible(true);
          vista.dispose();
          
          pantallaLogin.btnVerContrasena.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){
                       modelo.togglePasswordVisibility(pantallaLogin);
                     }
                  });
        }
    }
    
}
