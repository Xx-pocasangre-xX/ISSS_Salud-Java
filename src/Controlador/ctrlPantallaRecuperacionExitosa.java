package Controlador;

import Vista.jfrPantallaLogin;
import Vista.jfrPantallaRecuperacionExitosa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlPantallaRecuperacionExitosa implements ActionListener{
    
    private jfrPantallaRecuperacionExitosa vista;
    
    public ctrlPantallaRecuperacionExitosa(jfrPantallaRecuperacionExitosa vista){
      this.vista = vista;
      vista.btnVolverLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnVolverLogin){
          jfrPantallaLogin pantallaLogin = new jfrPantallaLogin();
          pantallaLogin.setLocationRelativeTo(null);
          pantallaLogin.setVisible(true);
          vista.dispose();
        }
    }
    
}
