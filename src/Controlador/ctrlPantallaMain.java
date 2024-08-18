package Controlador;

import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ctrlPantallaMain {
    private jfrPantallaMain pantallaMain;
    private jfrPantallaLogin pantallaLogin;
    
    public ctrlPantallaMain(jfrPantallaMain pantallaMain, jfrPantallaLogin pantallaLogin){
      System.out.println("Constructor ctrlPantallaMain llamado");
      this.pantallaMain = pantallaMain;
      this.pantallaLogin = pantallaLogin;
      
      this.pantallaMain.btnBienvenida.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
             iniciar();
         }
      });
    }
    
    public void iniciar(){
      pantallaMain.setVisible(false);
      pantallaLogin.setLocationRelativeTo(null);
      pantallaLogin.setVisible(true);
    }
}
