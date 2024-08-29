/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.EnvioCorreo;
import Modelo.Usuarios;
import Vista.jfrRecuperacionContra;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class ctrlPantallaRecuperacionContra implements MouseListener {
    
    private Usuarios modelo;
    private jfrRecuperacionContra vista;
    
    public ctrlPantallaRecuperacionContra(jfrRecuperacionContra vista, Usuarios modelo){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEnviarCorreo.addMouseListener(this);        
    }
    
     @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
            
        if(vista.txtCorreoRec.getText().isEmpty()){
            JOptionPane.showMessageDialog(vista, "Llene el campo del nombre");
        }
        else if(!vista.txtCorreoRec.getText().contains("@") || !vista.txtCorreoRec.getText().contains(".com")){
                        JOptionPane.showMessageDialog(vista, "Correo inválido");

        }
        else {
            String recipient = vista.txtCorreoRec.getText();
        String subject = "Recuperacion de contraseña";
         Random random = new Random();
        int codigoRecuperacion = 100000 + random.nextInt(900000);
        modelo.setCodigoRecuperacion(codigoRecuperacion);
        String content = "Este es el codigo de recuperacion" + codigoRecuperacion;
     
            EnvioCorreo.enviarCorreo(recipient, subject, content);
            JOptionPane.showMessageDialog(vista, "Correo enviado exitosamente.");
        }      
        
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
