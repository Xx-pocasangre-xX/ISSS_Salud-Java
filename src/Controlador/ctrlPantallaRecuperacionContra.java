package Controlador;

import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Vista.jfrRecuperacionContra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class ctrlPantallaRecuperacionContra implements ActionListener {
    
    private CredencialesCorreo modelo;
    private jfrRecuperacionContra vista;
    
    public ctrlPantallaRecuperacionContra(jfrRecuperacionContra vista, CredencialesCorreo modelo){
        this.modelo = modelo;
        this.vista = vista;
       this.vista.btnEnviarCorreo.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
            
            Random random = new Random();  
            
            int numeroAleatorio =100000 + random.nextInt(999999);
            String recipient = vista.txtCorreoRec.getText();
            String subject = "recuperacion de contraseña";
            String content = "Este es el codigo que utilizara para cambiar su contraseña";
            
            EnvioCorreo.envioCorreo(recipient, subject, content);
        
        }  
    } 
}
