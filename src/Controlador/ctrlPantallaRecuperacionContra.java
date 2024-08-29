package Controlador;

import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Vista.jfrRecuperacionContra;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class ctrlPantallaRecuperacionContra implements MouseListener {
    
    private CredencialesCorreo modelo;
    private jfrRecuperacionContra vista;
    
    public ctrlPantallaRecuperacionContra(jfrRecuperacionContra vista, CredencialesCorreo modelo){
        this.modelo = modelo;
        this.vista = vista;
        vista.btnEnviarCorreo.addMouseListener(this);        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
            
        if(vista.txtCorreoRec.getText().isEmpty()){
            JOptionPane.showMessageDialog(vista, "Llene el campo del Correo");
        }
        else if(!vista.txtCorreoRec.getText().contains("@") || !vista.txtCorreoRec.getText().contains(".com")){
                        JOptionPane.showMessageDialog(vista, "Correo inválido");

        }
        else {
            String recipient = vista.txtCorreoRec.getText();
        String subject = "Recuperacion de contraseña";
         Random random = new Random();
        int codigoRecuperacion = 100000 + random.nextInt(999999);
        modelo.setCodigoRecuperacion(codigoRecuperacion);
        String content = "Este es el codigo de recuperacion" + codigoRecuperacion;
     
            EnvioCorreo.envioCorreo(recipient, subject, content);
            JOptionPane.showMessageDialog(vista, "Correo enviado exitosamente.");
        }      
        
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
