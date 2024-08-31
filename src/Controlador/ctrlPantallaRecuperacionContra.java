package Controlador;

import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Vista.jfrRecuperacionContra;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class ctrlPantallaRecuperacionContra implements MouseListener {
    
    private CredencialesCorreo modelo;
    private jfrRecuperacionContra vista;
    
    public ctrlPantallaRecuperacionContra(CredencialesCorreo modelo, jfrRecuperacionContra vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEnviarCorreo.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
        
             Random random = new Random();
        
        // Genera un número aleatorio de 4 dígitos (1000 a 9999)
            int numeroAleatorio = 1000 + random.nextInt(9000);

            String recipient = vista.txtCorreoRec.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el codigo de recuperacion" + numeroAleatorio;

            EnvioCorreo.envioCorreo(recipient, subject, content);

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
