package Controlador;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlPantallaMain implements ActionListener{
    
    private final jfrPantallaMain vista;
    
    public ctrlPantallaMain(jfrPantallaMain vista){
       this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnBienvenida){
          jfrPantallaLogin loginView = new jfrPantallaLogin();
          loginView.setLocationRelativeTo(null);
          loginView.setVisible(true);
          vista.dispose();
        }
    }
    
}