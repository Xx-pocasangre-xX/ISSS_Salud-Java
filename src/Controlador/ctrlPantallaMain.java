package Controlador;
import Modelo.Usuarios;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlPantallaMain implements ActionListener{
    
    private final jfrPantallaMain vista;
    Usuarios modelo;
    
    public ctrlPantallaMain(jfrPantallaMain vista, Usuarios modelo){
       this.vista = vista;
       this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnBienvenida){
          jfrPantallaLogin loginView = new jfrPantallaLogin();
          loginView.setLocationRelativeTo(null);
          loginView.setVisible(true);
          vista.dispose();
          
          loginView.btnVerContrasena.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              modelo.togglePasswordVisibility(loginView);
            }
          });
        }
    }
    
}