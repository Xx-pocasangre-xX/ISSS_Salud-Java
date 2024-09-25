package Controlador;

import Modelo.Usuarios;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdminDoctores;
import static Vista.jfrPantallaMenuDoctor.initjfrPantallaMenuDoctor;
import static Vista.jfrPantallaMenuJefesEnfermeria.initjfrPantallaMenuJefesEnfermeria;
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
       this.vista.btnOlvidasteContra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnIniciarSesion){
           String correo = vista.txtEmail.getText();
           String contrasena = new String(vista.txtContrasena.getPassword());
           
           if(correo.isEmpty() || contrasena.isEmpty()){
             JOptionPane.showMessageDialog(vista, "Para iniciar sesión debe llenar todas las casillas.");
             return;
           }
           
           if(!modelo.validarCorreo(correo)){
             JOptionPane.showMessageDialog(vista, "El correo no es válido. Debe ser ejemplo@gmail.com o ejemplo@isss.gob.sv.");
             return;
           }
           
           String contrasenaEncriptada = modelo.encryptPassword(contrasena);
           
           int idRol = modelo.validarCredenciales(correo, contrasenaEncriptada);
           
           if(idRol != -1){
               switch (idRol){
                   case 1: 
                    JOptionPane.showMessageDialog(vista, "Login exitoso");
                    jfrPantallaMenuAdminDoctores menuAdmin = new jfrPantallaMenuAdminDoctores();
                    menuAdmin.setVisible(true);
                    menuAdmin.setLocationRelativeTo(null);
                    vista.dispose();
                    break;
                    
                   case 2: 
                    JOptionPane.showMessageDialog(vista, "La aplicación de escritorio es exclusiva para personal del ISSS. Por favor, descargue la versión móvil.");
                    vista.txtEmail.setText("");
                    vista.txtContrasena.setText("");
                    break;
                    
                    case 3: 
                    JOptionPane.showMessageDialog(vista, "Login exitoso");
                    initjfrPantallaMenuJefesEnfermeria();
                    vista.dispose();
                    break;
                    
                   default:
                        JOptionPane.showMessageDialog(vista, "Credenciales incorrectas. Inténtalo de nuevo.");
                        vista.txtEmail.setText("");
                        vista.txtContrasena.setText("");
                        break;
               }
           }else{
             int idDoctor = modelo.obtenerIdDoctor(correo, contrasenaEncriptada);
             if (idDoctor != -1) {
               modelo.setIdDoctor(idDoctor);  // Guarda el idDoctor en la clase de sesión
               JOptionPane.showMessageDialog(vista, "Login exitoso");
               initjfrPantallaMenuDoctor();  // Ya no es necesario pasar el idDoctor
               vista.dispose();
             } else {
               JOptionPane.showMessageDialog(vista, "Credenciales incorrectas. Inténtalo de nuevo.");
               vista.txtEmail.setText("");
               vista.txtContrasena.setText("");
}
           }
        }
        if(e.getSource() == vista.btnOlvidasteContra){
            jfrRecuperacionContra pantallaRec = new jfrRecuperacionContra();
            pantallaRec.setLocationRelativeTo(null);
            pantallaRec.setVisible(true);
            vista.dispose();
        }
    }  
}