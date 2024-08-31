package Controlador;

import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Vista.jfrRecuperacionContra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ctrlPantallaRecuperacionContra implements ActionListener {
    
    private CredencialesCorreo modelo;
    private jfrRecuperacionContra vista;
    
    public ctrlPantallaRecuperacionContra(CredencialesCorreo modelo, jfrRecuperacionContra vista){
        this.modelo = modelo;
        this.vista = vista;
       this.vista.btnEnviarCorreo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
        
             Random random = new Random();
             int numeroAleatorio = 100000 + random.nextInt(900000);

            String recipient = vista.txtCorreoRec.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el codigo de recuperacion: " + numeroAleatorio;

            EnvioCorreo.envioCorreo(recipient, subject, content);

        }
        
    }
            
           
    }
