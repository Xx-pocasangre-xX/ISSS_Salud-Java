package Controlador;

import Modelo.Usuarios;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdmin;
import Vista.jfrRecuperacionContra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ctrlPantallaLogin implements ActionListener{
    
        private final jfrPantallaLogin vista;
        private final Usuarios modelo;
        
    public ctrlPantallaLogin(jfrPantallaLogin vista, Usuarios modelo){
       this.vista = vista;
       this.modelo = modelo;
       this.vista.btnIniciarSesion.addActionListener(this);
<<<<<<< HEAD
       this.vista.btnOlvidasteContra.addActionListener(this);
=======
       this.vista.txtOlvidasteTuContrasena.addActionListener(this);
>>>>>>> 373766ff1401b8d9b1ac28d21ebf9f1ecc8cac61
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnIniciarSesion){
           String correo = vista.txtEmail.getText();
           String contrasena = new String(vista.txtContrasena.getPassword());
           String contrasenaEncriptada = modelo.encryptPassword(contrasena);
           
           if(modelo.validarCredenciales(correo, contrasenaEncriptada)){
             JOptionPane.showMessageDialog(vista, "Login exitoso");
             jfrPantallaMenuAdmin menuAdmin = new jfrPantallaMenuAdmin();
             menuAdmin.setVisible(true);
             menuAdmin.setLocationRelativeTo(null);
             vista.dispose();
           }else{
             JOptionPane.showMessageDialog(vista, "Credenciales incorrectas. Inténtalo de nuevo.");
             vista.txtEmail.setText("");
             vista.txtContrasena.setText("");
           }
        }
        if(e.getSource() == vista.txtOlvidasteTuContrasena){
            jfrRecuperacionContra pantallaRec = new jfrRecuperacionContra();
            pantallaRec.setLocationRelativeTo(null);
            pantallaRec.setVisible(true);
            vista.dispose();
        }
    }
   
    
}