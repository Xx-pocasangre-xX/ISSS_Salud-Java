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
<<<<<<< HEAD
        
        vista.btnEnviarCorreo.addMouseListener(this);
        
=======
       this.vista.btnEnviarCorreo.addActionListener(this);
>>>>>>> 6a8409f730c5eb0a576dc0cc04baa1eb059caa0b
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
<<<<<<< HEAD
        
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
=======
            
            Random random = new Random();  
            
            int numeroAleatorio =100000 + random.nextInt(999999);
            String recipient = vista.txtCorreoRec.getText();
            String subject = "recuperacion de contraseña";
            String content = "Este es el codigo que utilizara para cambiar su contraseña";
            
            EnvioCorreo.envioCorreo(recipient, subject, content);
        
        }  
    } 
>>>>>>> 6a8409f730c5eb0a576dc0cc04baa1eb059caa0b
}
