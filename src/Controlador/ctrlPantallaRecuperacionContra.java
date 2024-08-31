package Controlador;

import Modelo.CodigoRecuperacion;
import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Vista.jfrCodigoVerificacion;
import Vista.jfrRecuperacionContra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

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
        
            if(vista.txtCorreoRec.getText().isEmpty()){
            JOptionPane.showMessageDialog(vista, "Ingrese su correo");
                
            }

            else if(!vista.txtCorreoRec.getText().contains("@") || !vista.txtCorreoRec.getText().contains(".com")){
                    JOptionPane.showMessageDialog(vista, "Correo inválido");

            }
            else {
                String recipient = vista.txtCorreoRec.getText();
                String subject = "Recuperacion de contraseña";
                Random random = new Random();
                int codigoRecuperacion = 100000 + random.nextInt(999999);
                CodigoRecuperacion.setCodigoRecuperacion(codigoRecuperacion);
                String content = "Este es el codigo de recuperacion: " + codigoRecuperacion;

                EnvioCorreo.envioCorreo(recipient, subject, content);
                JOptionPane.showMessageDialog(vista, "Correo enviado exitosamente.");
                jfrCodigoVerificacion pantallaCod = new jfrCodigoVerificacion();
                pantallaCod.setVisible(true);
                pantallaCod.setLocationRelativeTo(null);
                vista.dispose();
            }  
        }
    }
}
