package Controlador;

import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlPantallaLogin{
   private jfrPantallaLogin pantallaLogin;
   private jfrPantallaMenuAdmin pantallaMenuAdmin;
   
   public ctrlPantallaLogin(jfrPantallaLogin pantallaLogin, jfrPantallaMenuAdmin pantallaMenuAdmin){
     this.pantallaLogin = pantallaLogin;
     this.pantallaMenuAdmin = pantallaMenuAdmin;
     
     this.pantallaLogin.btnIniciarSesion.addActionListener(new ActionListener(){
       @Override
         public void actionPerformed(ActionEvent e){
              iniciar();
         
         }
       });
   }
   
   public void iniciar(){
      pantallaLogin.setVisible(false);
      pantallaMenuAdmin.setLocationRelativeTo(null);
      pantallaMenuAdmin.setVisible(true);
    }
}